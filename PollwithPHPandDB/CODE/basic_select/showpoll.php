<?php
/**
 * This page will process a vote and display the results of a poll
 * 
 */
session_start();
include "connect.php";


// make sure the SESSION attribute is set
if (isset($_GET["pollid"])) {
    $pollid = $_GET["pollid"];

    // get the information from the polls table
    $selectcommand = "SELECT * FROM polls WHERE PollID=?";
    $stmt = $dbh->prepare($selectcommand);
    $stmt->execute(array($pollid));

    // The result should be unique, so just get the first row
    $row = $stmt->fetch();

    // if $row is false, then the pollid must have been wrong
    if ($row) {
        $title = $row['Title'];
        $question = $row['Question'];
        $answers = Array();
        $results = Array();
        for ($i = 1; $i <= 4; $i++) {
            array_push($answers, $row["Answer$i"]);
            array_push($results, $row["Votes$i"]);
        }
    }
}
?>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Poll page</title>
        <link rel="stylesheet" href="../css/style.css">
        <meta name="viewport" content="width=device-width">
        <style type="text/css">
            th {
                border-bottom:1px solid black;
            }
        </style>
    </head>
    <body>
        <div id="container">
            <?php
            // make sure the GET parameter is set
            if (isset($pollid)) {

                // if $answers is not set, then the pollid must have been wrong
                if (isset($answers)) {
                    // display the poll
                    echo "<h1>$title</h1>";
                    echo "<p><b>$question</b></p>";
                    echo "<table><tr><th style='text-align:left'>Answer</th><th>Votes</th></tr>";
                    for ($i = 0; $i < 4; $i++) {
                        echo "<tr><td>{$answers[$i]}</td><td style='text-align:center'>{$results[$i]}</td>";
                    }
                    echo "</table>";
                } else {
                    echo "<p>Poll ID $pollid not found.</p>";
                }
                echo "<i style='color:blue'>$selectcommand</i><br>";
            } else {
                echo '<p>No poll selected</p>';
            }
            session_destroy();
            ?>
            <p><a href="index.html">back</a></p>
        </div>
    </body>
</html>
