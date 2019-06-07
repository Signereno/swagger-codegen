package io.swagger.codegen.languages;

import io.swagger.codegen.CodegenProperty;

public class IdfyCsharpDotNet2ClientCodegen extends CsharpDotNet2ClientCodegen {

    public IdfyCsharpDotNet2ClientCodegen() {
        super();
        setModelPackage(packageName);
    }

    @Override
    public String modelPackage() {
        return packageName;
    }

    @Override
    public String toEnumVarName(String name, String datatype) {
        if (name.length() == 0) {
            return "Empty";
        }

        // for symbol, e.g. $, #
        if (getSymbolName(name) != null) {
            return camelize(getSymbolName(name));
        }

        String enumName = sanitizeName(name);

        enumName = enumName.replaceFirst("^_", "");
        enumName = enumName.replaceFirst("_$", "");

        enumName = camelize(enumName);

        if (enumName.matches("\\d.*")) { // starts with number
            return "_" + enumName;
        } else {
            return enumName;
        }
    }

    @Override
    public String toEnumName(CodegenProperty property) {
        return sanitizeName(camelize(property.name)) + "";
    }
}
