<?php
	function find_word($str,$word){
		$position = stripos($str,$word);
		return substr($str,$position,strlen($word));
	}
?>