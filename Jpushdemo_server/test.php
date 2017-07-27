<?php


require __DIR__ . '/autoload.php';

use JPush\Client as JPush;
$app_key='77a355c409d78895807cb6bf';
$master_secret='c0e17e9f856e808ff2ac1ec0';
// array for JSON response
$response = array();
if (isset($_GET['text']) ){


	$client = new JPush($app_key, $master_secret);

	$push_payload = $client->push()
	    ->setPlatform('all')
	    ->addAllAudience()
	    ->setNotificationAlert($_GET['text']);
	try {
	    $response = $push_payload->send();
	    print_r($response);
	} catch (\JPush\Exceptions\APIConnectionException $e) {
	    // try something here
	    print $e;
	} catch (\JPush\Exceptions\APIRequestException $e) {
	    // try something here
	    print $e;
	}
	$response["success"] = 1;
    $response["message"] = "success";
}
else{
	$response["success"] = 0;
    $response["message"] = "Required field(s) is missing";

}

 
    // echo no users JSON
    echo json_encode($response);
?>
