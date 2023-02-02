<?php

try {
    $dbh = new PDO('mysql:host=localhost;dbname=xxxxx', "xxxxx", "xxxxx");
} catch (Exception $e) {
    die('Could not connect to DB: ' . $e->getMessage());
}


