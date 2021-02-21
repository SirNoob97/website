function decode(attValue){
  return attValue.replace(/[a-zA-Z]/g, function(c){
    return String.fromCharCode((c <= "Z" ? 90 : 122) >=  (c = c.charCodeAt(0) + 13) ? c : c - 26);
  })
};

function openMailer(tag) {
  var value = decode("znvygb:znegvanyq467@tznvy.pbz");
  tag.setAttribute("href", value);
  tag.setAttribute("onclick", "");
  tag.firstChild.nodeValue = "I dont like spam bots";
}
