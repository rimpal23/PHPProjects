<!DOCTYPE html>
<?php
/**
 * This page will display a list of all poll titles found in the database.
 * In this version the list is displayed in a form which links to the show poll
 * page.
 * 
 * This page needs the accompanying polls.sql import file. Import the file
 * into your local DB using phpMyAdmin.
 * 
 * Sam Scott, February 2015 
 */
include "connect.php";
include "Poll.php";

$pollArray = Array();

$command = "SELECT Title,pollid FROM polls ORDER BY Title";
$stmt = $dbh->prepare($command);
$stmt->execute();

// Fetch all the rows
while ($row = $stmt->fetch()) {
    $poll = new Poll($row['pollid'], $row['Title']);
    array_push($pollArray, $poll);
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
            <form action="showpoll.php" method="get">
                <?php
                // Output all the polls
                foreach ($pollArray as $row) {
                    // display the poll title
                    echo "<input type='radio' name='pollid' value='$row->id' id='$row->id'>";
                    echo "<label for='$row->id'> $row->title</label><br>\n";
                }
                ?>
                <input type="submit" value="Go!"/>
            </form>
            <i style='color:blue'><?=$command?></i><br/>
            <p><a href="index.html">back</a></p>
        </div>
    </body>
</html>
