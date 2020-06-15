/*
 * Swagger Petstore
 * This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\
 *
 * OpenAPI spec version: 1.0.0
 * Contact: apiteam@swagger.io
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 *
 * Swagger Codegen version: 2.4.6-SNAPSHOT
 *
 * Do not edit the class manually.
 *
 */

(function(root, factory) {
  if (typeof define === 'function' && define.amd) {
    // AMD.
    define(['expect.js', '../../../js/petstore/index'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    factory(require('expect.js'), require('../../../js/petstore/index'));
  } else {
    // Browser globals (root is window)
    factory(root.expect, root.SwaggerPetstore);
  }
}(this, function(expect, SwaggerPetstore) {
  'use strict';

  var instance;

  describe('petstore', function() {
    describe('ReadOnlyFirst', function() {
      beforeEach(function() {
        instance = new SwaggerPetstore.ReadOnlyFirst();
      });

      it('should create an instance of ReadOnlyFirst', function() {
        // TODO: update the code to test ReadOnlyFirst
        expect(instance).to.be.a(SwaggerPetstore.ReadOnlyFirst);
      });

      it('should have the property bar (base name: "bar")', function() {
        // TODO: update the code to test the property bar
        expect(instance).to.have.property('bar');
        // expect(instance.bar).to.be(expectedValueLiteral);
      });

      it('should have the property baz (base name: "baz")', function() {
        // TODO: update the code to test the property baz
        expect(instance).to.have.property('baz');
        // expect(instance.baz).to.be(expectedValueLiteral);
      });

    });
  });

}));
