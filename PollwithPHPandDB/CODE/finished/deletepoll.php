<!DOCTYPE html>
<?php
/**
 * A one-page app that displays a list of available polls and allows one to
 * be selected and deleted.
 * 
 * This page needs the accompanying polls.sql import file. Import the file
 * into your local DB using phpMyAdmin.
 * 
 * Sam Scott, February 2015 
 */
include "connect.php";
include "Poll.php";

// delete poll, if parameter set
if (isset($_POST["pollid"])) {
    $deleteid = $_POST["pollid"];
    if ($deleteid < 167) {
        $message = "Sorry, you're not allowed to delete that poll. If you create a new one, you can delete it.";
    } else {
        $deletecommand = "DELETE FROM polls WHERE pollid=?";
        $stmt = $dbh->prepare($deletecommand);
        if ($stmt->execute(Array($deleteid))) {
            $message = "Poll $deleteid deleted.";
        } else {
            $message = "Poll $deleteid could not be deleted.";
        }
    }
}

// get the information from the polls table
$selectcommand = "SELECT Title,pollid FROM polls ORDER BY Title";
$stmt = $dbh->prepare($selectcommand);
$stmt->execute();

// Process all the rows
$polls = Array();
while ($row = $stmt->fetch()) {
    array_push($polls, new Poll($row['pollid'], $row['Title']));
}
?>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Polls</title>
        <link rel="stylesheet" href="../css/style.css">
        <meta name="viewport" content="width=device-width">
    </head>
    <body>
        <div id="container">
            <h1>Available Polls</h1>
            <p>Note that there are 5 example polls that cannot be deleted. You may 
                have to <a href="createpoll.html">create a poll</a> in order to try 
                out this page.</p>
            <form action="deletepoll.php" method="post">
                <?php
                // Process all the rows
                foreach ($polls as $poll) {
                    // display the poll title
                    echo "<input type='radio' name='pollid' value='$poll->id' id='$poll->id'";
                    if ($poll->id < 167) {
                        echo "disabled='true'";
                    }
                    echo ">";
                    echo "<label for=''>$poll->title</label><br>\n";
                }
                ?>
                <input type="submit" value="Delete!">
                <?php
                if (isset($message)) {
                    echo "<p>$message</p>";
                }
                ?>
            </form>
            <p><a href="index.html">back</a></p>
            <?php
            if (isset($deletecommand)) {
                echo "<p style='color:blue'>$deletecommand</p>";
            }
            ?>
            <p style='color:blue'><?= $selectcommand ?></p>
        </div>
    </body>
</html>
