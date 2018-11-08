var person = {
  name: 'Dan',
  address: 'Cluj-Napoca'
};
twoWayDataBind(person, jsService(), htmlService());

function ChangeDataModel() {
  person = getNewPerson(person);
  person.updateHtmlBindings();
}

function getNewPerson(person) {
  var newPerson = person;
  var date = new Date();
  var timestamp = date.getUTCHours() + ':' + date.getUTCMinutes() + ':' + date.getUTCSeconds();
  if (newPerson.name.indexOf(' timestamp @ ') == -1) newPerson.name += ' timestamp @ ' + timestamp;
  else newPerson.name += ' *';
  if (newPerson.address.indexOf(' timestamp @ ') == -1) newPerson.address += ' timestamp @ ' + timestamp;
  else newPerson.address += ' *';
  return newPerson;
}
