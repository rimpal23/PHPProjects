<!DOCTYPE html>
<?php
/**
 * This page will display a list of all poll titles found in the database.
 * In this version the list is displayed in a form which links to the show poll
 * page.
 * 
 */
include "connect.php";

// Create arrays to hold ids and titles
$pollids = Array();
$polltitles = Array();

// prepare the command
$command = "SELECT Title,pollid FROM polls ORDER BY Title";
$stmt = $dbh->prepare($command);
$stmt->execute();
        
// Fetch and store the polls
while ($row = $stmt->fetch()) {
    array_push($pollids, $row['pollid']);
    array_push($polltitles, $row['Title']);
}
?>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Poll page</title>
        <link rel="stylesheet" href="../css/style.css">
        <meta name="viewport" content="width=device-width">
    </head>
    <body>
        <div id="container">
            <h1>Available Polls</h1>
            <?php
            // Output all the polls
            for ($i = 0; $i < count($pollids); $i++) {
                // display the poll title
                echo "<a href='showpoll?pollid={$pollids[$i]}'>{$polltitles[$i]}</a><br>\n";
            }
            ?>
            <i style='color:blue'><?= $command ?></i><br/>
            <p><a href="index.html">back</a></p>
        </div>
    </body>
</html>
