const URL = "http://localhost:8081/";


let orangesTrigger = document.getElementById('orangesTrigger');
let applesTrigger = document.getElementById('applesTrigger');
let pearsTrigger = document.getElementById('pearsTrigger');
let grapesTrigger = document.getElementById('grapesTrigger');

orangesTrigger.onclick = orangesFunction;
applesTrigger.onclick = applesFunction;
pearsTrigger.onclick = pearsFunction;
grapesTrigger.onclick = grapesFunction;


// VV Sends Nothing To Java
// VV Java Does <Stuff> And
// VV Receives A String From Java
async function orangesFunction() {

  console.log("Starting Oranges Function");

  // VV Trigger Java app.get Handler With
  // VV The Path "/tester"
  let response = await fetch(URL + "tester", { } );

  // VV Obtains Data From Java Through ctx.json(<whateverData>);
  // VV In This Case We Obtain A String
  let data = await response.json();

  console.log(data);
  console.log("\n");

}




// VV Sends An Object To Java And
// VV Java Does <Stuff> And
// VV Receives A String From Java
async function applesFunction () {

  console.log("Starting Apples Function");

  // VV Parameter Object Being Sent To Java Server
  let sender = { 

    "apples" : "This Is The Apple String",
    "applePie" : "This Is An Apple Pie String"

  };

  let response = await fetch(URL + "tester", {

    method : 'POST',
    // VV Obtained In Java With ctx.body();
    body : JSON.stringify(sender)

  });

  // VV Obtains Data From Java Through ctx.json(<whatever>);
  // VV In This Case It Is A String
  let data = await response.json();

  console.log(data);
  console.log("\n");

}




// VV Sends No Parameter To Java In The Fetch Body
// VV Sends A Path Parameter To Java
// VV Obtains A List Of Strings From Java
async function pearsFunction() {

  console.log("Starting Pears Function");

  let param = 413;

  // VV Trigger Java app.get Handler With
  // VV The Path "/tester/413"
  // VV Will Trigger app.get
  let response = await fetch(URL + "tester/" + param, { } );

  // VV Obtains Data From Java Through ctx.json(<whateverData>);
  // VV In This Case We Obtain A String
  let data = await response.json();

  console.log(data);
  console.log("Data[0] : First String In Array : " + data[0]);
  console.log("Data[1] : Second String In Array : " + data[1]);
  console.log("Data[2] : Third String In Array : " + data[2]);
  console.log("Data[3] : Out Of Bounds Exception!! : " + data[3]);
  console.log("\n");

}




// VV Sends A string To Java With A Parameter
// VV Java Does <Stuff> And
// VV Receives A String From Java
async function grapesFunction () {

  console.log("Starting Grapes Function");

  // VV Parameter Object Being Sent To Java Server
  let sender = "Give Me Grapes!!"

  let param = "8";

  let response = await fetch(URL + "tester/" + param, {

    method : 'POST',
    // VV Obtained In Java With ctx.body();
    body : JSON.stringify(sender)

  });

  // VV Obtains Data From Java Through ctx.json(<whatever>);
  // VV In This Case It Is A String
  let data = await response.json();

  console.log(data);

  console.log("Grape Number : " + Object(data).length);

  let i = 1;

  for (let grape of data) {

    console.log("\n");
    console.log("Grape Inventory : " + i);
    console.log(grape);
    console.log("Seeds Output : " + Object(grape).seeds);

    ++ i;

  }

  console.log("\n");
  console.log("End Of Grapes Function!!");
  console.log("\n");

}


