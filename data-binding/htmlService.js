function htmlService() {

  function getHtmlElementValue(element) {
    var value = null;
    try {
      value = JSON.parse(element.value);
    }
    catch (e) {
      value = element.value;
    }

    return value;
  }

  function setHtmlNodeValue(element, value) {
    if (element.nodeName === 'INPUT') {
      element.value = (typeof value !== 'undefined' ? value : '');
    }
    else {
      element.innerHTML = value;
    }
  }

  function updateAll(elements, value) {
    elements.forEach(function (element) {
      setHtmlNodeValue(element, value);
    });
  }

  return {
    getHtmlElementValue: getHtmlElementValue,
    setHtmlNodeValue: setHtmlNodeValue,
    updateAll: updateAll
  }
}