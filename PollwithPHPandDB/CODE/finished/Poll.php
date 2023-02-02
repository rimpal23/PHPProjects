<?php

class Poll {

    public $id;
    public $title;
    public $question;
    public $answers;
    public $results;

    function __construct($id, $title, $question=null, $answers=null, $results=null) {
        $this->id = $id;
        $this->title = $title;
        $this->question = $question;
        $this->answers = $answers;
        $this->results = $results;
    }
}
