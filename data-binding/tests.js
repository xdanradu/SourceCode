(function (jsService, htmlService) {
  console.log('Test 1: ' + (jsService.getBoundProperty('person.name') == 'name' ? 'PASSED' : 'FAILED'));
  console.log('Test 2: ' + (jsService.getBoundProperty('person.age') == 'age' ? 'PASSED' : 'FAILED'));
  console.log('Test 3: ' + (jsService.getBoundProperty('address') == 'address' ? 'PASSED' : 'FAILED'));
  console.log('Test 4: ' + (jsService.getBoundProperty('') == '' ? 'PASSED' : 'FAILED'));

  var element = document.createElement('input');
  element.value = '12345';
  console.log('Test 4: ' + (htmlService.getHtmlElementValue(element) == '12345' ? 'PASSED' : 'FAILED'));

  var element = document.createElement('input');
  element.value = '';
  console.log('Test 5: ' + (htmlService.getHtmlElementValue(element) == '' ? 'PASSED' : 'FAILED'));

})(jsService(), htmlService());
