<?php
/**
 * This page will process a vote and display the results of a poll
 */
include "connect.php";

// make sure the POST parameter is set
if (isset($_POST["pollid"])) {
    $pollid = $_POST["pollid"];
    // do the vote
    if (isset($_POST["answer"]) && is_numeric($_POST["answer"])) {
        $answer = $_POST["answer"];
        $updatecommand = "UPDATE polls SET Votes$answer=Votes$answer+1 WHERE PollID=$pollid";
        $stmt = $dbh->prepare($updatecommand);
        $result = $stmt->execute();
        if ($result && $stmt->rowCount() > 0) {
            $success = "<p>Your vote has been recorded.</p>";
        } else {
            $success = "<p style='color:red'>Sorry! Something went wrong with your vote.</p>";
        }
    } else {
        $success = "<p style='color:red'>Bad Vote Parameter!</p>";
    }
} else {
    $success = "<p>Poll ID not found.";
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
            // make sure the poll was found
            if (isset($pollid)) {
                echo $success;
                echo "<i style='color:blue'>$updatecommand</i><br>";
            } else {
                echo '<p>No poll selected</p>';
            }
            ?>
            <p><a href="index.html">back</a></p>
        </div>
    </body>
</html>
