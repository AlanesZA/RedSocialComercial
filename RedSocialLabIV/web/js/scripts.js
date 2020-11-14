function getToday() {
    var d = new Date();
    
    var day = d.getDate() > 9 ? d.getDate() : '0' + d.getDate();
    var month = (d.getMonth() + 1) > 9 ? (d.getMonth() + 1) : ('0' + (d.getMonth() + 1));
    var year = d.getFullYear();
    
    var today = day + '-' + month + '-' + year;
    
    return today;
    
}