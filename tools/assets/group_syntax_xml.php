<?php
$elements = array();  // the currently filling [child] XmlElement array

$path = __DIR__ . '/syntax';
$files = scandir($path);
foreach($files as $file) {
  if ($file == '.' || $file == '..') {
    continue;
  }
  if (substr($file, -4) != '.xml') {
    continue;
  }
  $xml = file_get_contents($path.'/'.$file);
  xml_to_object($xml);
}
echo json_encode($elements);
echo "\n\n";
exit;


function xml_to_object($xml) {
  global $elements;
  $parser = xml_parser_create();
  xml_parser_set_option($parser, XML_OPTION_CASE_FOLDING, 0);
  xml_parser_set_option($parser, XML_OPTION_SKIP_WHITE, 1);
  xml_parse_into_struct($parser, $xml, $tags);
  xml_parser_free($parser);


  $stack = array();
  foreach ($tags as $tag) {
    $index = count($elements);
    if ($tag['type'] == "complete" || $tag['type'] == "open") {
      $t = $tag['tag'];
      $elements[$t]['count']++;
      $elements[$t]['text'] = $tag['value'] ? $tag['value'] : $elements[$t]['text'];
      if ($tag['attributes']) {
        foreach ($tag['attributes'] as $key => $value) {
          $elements[$t]['attributes'][$key]++;
        }
      }

      if ($tag['type'] == "open") {  // push
        if(!isset($elements[$t]['children']))$elements[$t]['children'] = array();
        $stack[count($stack)] = &$elements;
        $elements = &$elements[$t]['children'];
      }
    }
    if ($tag['type'] == "close") {  // pop
      $elements = &$stack[count($stack) - 1];
      unset($stack[count($stack) - 1]);
    }
  }
}