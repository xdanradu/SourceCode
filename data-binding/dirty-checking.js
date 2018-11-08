function twoWayDataBind(scope, jsService, htmlService) {
  var boundHtmlElements = {};
  var oldValues = {};

  (function () {
    document.addEventListener('DOMContentLoaded', function () {
      initializeDomDataBinding();
      watchForHtmlChanges();
    });
  })();

  function initializeDomDataBinding() {
    var allDomElementsWithDataBinding = document.querySelectorAll('[data-bind]');

    for (var i = 0, element; element = allDomElementsWithDataBinding[i]; i++) {

      var htmlAttribute = element.getAttribute('data-bind');
      var value = jsService.getBoundValue(htmlAttribute);
      htmlService.setHtmlNodeValue(element, value);

      updateOldValues(htmlAttribute, value);
      addElementToBoundHtmlElements(htmlAttribute, element);

    }
  }

  function updateOldValues(property, newValue) {
    oldValues[property] = newValue;
  }

  function addElementToBoundHtmlElements(htmlAttribute, element) {
    boundHtmlElements[htmlAttribute] = boundHtmlElements[htmlAttribute] || [];
    if (boundHtmlElements[htmlAttribute].indexOf(element) === -1) {
      boundHtmlElements[htmlAttribute].push(element);
    }
  }

  function watchForHtmlChanges() {
    document.addEventListener('keyup', function (e) {
      var htmlInputElement = e.target;

      if (htmlInputElement.hasAttribute('data-bind')) {
        updateTriggeredBy(htmlInputElement);
      }
    });
  }

  function updateTriggeredBy(htmlInputElement) {
    var objectAttributesGivenInHtml = htmlInputElement.getAttribute('data-bind');
    var valueFromHtml = htmlService.getHtmlElementValue(htmlInputElement);
    jsService.updateObjectWithNewValue(objectAttributesGivenInHtml, valueFromHtml);
    updateHtmlBindings();
  }

  function updateHtmlBindings() {
    var changed = true;

    while (changed) {
      changed = false;

      for (var element in boundHtmlElements) {

        var currentValue = jsService.getBoundValue(element);
        if (currentValue !== oldValues[element]) {
          changed = true;
          htmlService.updateAll(boundHtmlElements[element], currentValue);
          updateOldValues(element, currentValue);
        }

      }
    }
  }

  scope.updateHtmlBindings = updateHtmlBindings;
}
