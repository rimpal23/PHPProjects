<?php
/**
 * This page will process a vote and display the results of a poll
 * 
 * Sam Scott, February 2015 
 */
session_start();
include "connect.php";
include "Poll.php";

// make sure the SESSION attribute is set
if (isset($_SESSION['pollid'])) {
    
    // do the vote
    if (isset($_POST["answer"]) && is_numeric($_POST["answer"])) {
        $updatecommand = "UPDATE polls SET Votes{$_POST["answer"]}=Votes{$_POST["answer"]}+1 WHERE PollID=?";
        $stmt = $dbh->prepare($updatecommand);
        $result = $stmt->execute(array($_SESSION['pollid']));
        if ($result) {
            $success = "<p>Your vote has been recorded.</p>";
        } else {
            $success = "<p style='color:red'>Sorry! Something went wrong with your vote.</p>";
        }
    } else {
        $success = "<p style='color:red'>Bad Vote Parameter!</p>";
    }

    // get the information from the polls table
    $selectcommand = "SELECT * FROM polls WHERE PollID=?";
    $stmt = $dbh->prepare($selectcommand);
    $stmt->execute(array($_SESSION['pollid']));

    // The result should be unique, so just get the first row
    $row = $stmt->fetch();

    // if $row is false, then the pollid must have been wrong
    if ($row) {
        $answers = Array();
        $results = Array();
        for ($i = 1; $i <= 4; $i++) {
            array_push($answers, $row["Answer$i"]);
            array_push($results, $row["Votes$i"]);
        }
        $poll = new Poll($_SESSION["pollid"], $row['Title'], $row['Question'], $answers, $results);
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
            if (isset($_SESSION['pollid'])) {

                // if $poll is not set, then the pollid must have been wrong
                if (isset($poll)) {
                    // display the poll
                    echo "<h1>$poll->title</h1>";
                    echo "<p><b>$poll->question</b></p>";
                    echo "<table><tr><th style='text-align:left'>Answer</th><th>Votes</th></tr>";
                    for ($i = 0; $i < 4; $i++) {
                        echo "<tr><td>{$poll->answers[$i]}</td><td style='text-align:center'>{$poll->results[$i]}</td>";
                    }
                    echo "</table>";
                } else {
                    echo "<p>Poll ID {$_SESSION['pollid']}not found.";
                }
                echo $success;
                echo "<i style='color:blue'>$updatecommand</i><br>";
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
