function jsService() {

  function getBoundObject(objectAttributesGivenInHtml) {
    objectAttributesGivenInHtml = objectAttributesGivenInHtml.split('.');
    var binding = window;

    for (var i = 0; i < objectAttributesGivenInHtml.length - 1; i++) {
      if (typeof binding[objectAttributesGivenInHtml[i]] === 'undefined') return;

      binding = binding[objectAttributesGivenInHtml[i]];
    }

    return binding;
  }

  function getBoundProperty(objectAttributesGivenInHtml) {
    return objectAttributesGivenInHtml.substring(objectAttributesGivenInHtml.lastIndexOf('.') + 1);
  }

  function getBoundValue(objectAttributesGivenInHtml) {
    var object = getBoundObject(objectAttributesGivenInHtml);
    var property = getBoundProperty(objectAttributesGivenInHtml);

    return (object ? object[property] : undefined);
  }

  function updateObjectWithNewValue(objectAttributesGivenInHtml, newValue) {
    var boundObject = getBoundObject(objectAttributesGivenInHtml);
    var property = getBoundProperty(objectAttributesGivenInHtml);
    boundObject[property] = newValue;
  }

  return {
    getBoundObject: getBoundObject,
    getBoundProperty: getBoundProperty,
    getBoundValue: getBoundValue,
    updateObjectWithNewValue: updateObjectWithNewValue
  }
}
