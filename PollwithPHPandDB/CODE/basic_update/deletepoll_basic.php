<!DOCTYPE html>
<?php
/**
 * A one-page app that displays a list of available polls and allows one to
 * be selected and deleted. This is a very basic version which does not use
 * prepared statements with parameters.
 * 
 */
include "connect.php";

// delete poll, if parameter set

if (isset($_POST["pollid"])) {
    $deleteid = $_POST["pollid"];
    if ($deleteid < 167) {
        $message = "Sorry, you're not allowed to delete that poll. If you create a new one, you can delete it.";
    } else {
        $deletecommand = "DELETE FROM polls WHERE pollid=$deleteid";
        $stmt = $dbh->prepare($deletecommand);
        if ($stmt->execute() && $stmt->rowCount() > 0) {
            $message = "Poll $deleteid deleted.";
        } else {
            $message = "Poll $deleteid could not be deleted.";
        }
    }
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
                have to <a href="createpoll_basic.html">create a poll</a> in order to try 
                out this page.</p>
            <form action="deletepoll_basic.php" method="post">
                <input type="number" name="pollid" placeholder="Poll ID" min="167" required><br>
                <input type="submit" value="Delete!">
                <?php
                if (isset($message)) {
                    echo "<p>$message</p>";
                }
                ?>
            </form>
            <p><a href="index.html">back</a></p>
            <p style='color:blue'>
                <?php
                if (isset($deletecommand)) {
                    echo $deletecommand;
                }
                ?>
            </p>
        </div>
    </body>
</html>
