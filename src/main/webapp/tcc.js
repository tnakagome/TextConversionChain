function clearFields() {
    var form1=document.forms["form1"];
    var index = 1;
    while (true) {
        var selector = form1.elements["converter"+index];
        if (selector != null) {
            form1.elements["converter"+index].options[0].selected = true;
            index++;
        }
        else {
            break;
        }
    }
    index = 2;
    var table1 = document.getElementById("table1");
    while (true) {
        var text = table1.rows[index].cells[2];
        if (text != null) {
            text.innerHTML="";
            index++;
        }
        else {
            break;
        }
    }
    form1.elements["text"].value = "";
    form1.elements["text"].focus();
}

function validateFields() {
    var text = form1.elements["text"].value;
    if (text == null || text.length == 0) {
        alert("Text is empty.");
        return false;
    }
    var selector = form1.elements["converter1"].value;
    if (selector == "Null" || selector == "Empty") {
        alert("Converter is not selected.");
        return false;
    }
    return true;
}
