
function calculateDifference() {

    // To get input
    let startHour = parseInt(document.getElementById("startHour").value) || 0;
    let startMinute = parseInt(document.getElementById("startMinute").value) || 0;
    let startSecond = parseInt(document.getElementById("startSecond").value) || 0;

    let endHour = parseInt(document.getElementById("endHour").value) || 0;
    let endMinute = parseInt(document.getElementById("endMinute").value) || 0;
    let endSecond = parseInt(document.getElementById("endSecond").value) || 0;

    // to check if user input is correct
    if(startHour == 24)
        startHour = 0;
    if(endHour == 24)
        endHour = 0;
    if (startHour > 24 || endHour > 24 ||
         startMinute > 59 || startSecond > 59 || 
         endMinute > 59 || endSecond > 59 || 
         startHour < 0 || startMinute < 0 ||
          startSecond < 0 || endHour < 0 || 
          endMinute < 0 || endSecond < 0) {
            alert("Please enter a valid input");
            return;
          }
    // To display the input
    console.log("start time :",startHour, startMinute, startSecond);
    console.log("End Time :", endHour, endMinute, endSecond);

    // Calculate the difference in time.
    let timeOneInSeconds = (startHour * 3600) + (startMinute * 60) + startSecond;
    let timeTwoInSeconds = (endHour * 3600) + (endMinute * 60) + endSecond;
    let difference = Math.abs(timeOneInSeconds - timeTwoInSeconds);
    let resultHour = Math.floor(difference / 3600);
    difference %= 3600;
    let resultMinute = Math.floor(difference / 60);
    difference %= 60;
    let resultSecond = difference;

    // Format the output 
    let formattedResult = resultHour.toString().padStart(2, '0') + ":" + resultMinute.toString().padStart(2, '0') + ":" + resultSecond.toString().padStart(2, '0');
    document.getElementById("result").textContent = formattedResult;
}