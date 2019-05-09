package io.swagger.codegen.languages;

import io.swagger.codegen.*;

import io.swagger.models.Model;
import io.swagger.models.properties.ArrayProperty;
import io.swagger.models.properties.MapProperty;
import io.swagger.models.properties.Property;
import org.apache.commons.lang3.BooleanUtils;

import java.util.*;

public class IdfyJavaClientCodegen extends JavaClientCodegen {
    public IdfyJavaClientCodegen() {
        super();

    }
    @Override
    public void postProcessModelProperty(CodegenModel model, CodegenProperty property) {
        super.postProcessModelProperty(model, property);
        if(additionalProperties.containsKey("gson")) {
            model.imports.remove("SerializedName");
            model.imports.remove("TypeAdapter");
            model.imports.remove("JsonAdapter");
            model.imports.remove("JsonReader");
            model.imports.remove("JsonWriter");
            model.imports.remove("IOException");
        }

        if(!BooleanUtils.toBoolean(model.isEnum)) {
            // needed by all pojos, but not enums
            model.imports.remove("ApiModelProperty");
            model.imports.remove("ApiModel");
        }
    }

    @Override
    public CodegenModel fromModel(String name, Model model, Map<String, Model> allDefinitions) {
        CodegenModel codegenModel = super.fromModel(name, model, allDefinitions);
        if(codegenModel.imports.contains("ApiModel")) {
            codegenModel.imports.remove("ApiModel");
        }
        return codegenModel;
    }

    //@Override
    //public String getTypeDeclaration(Property p) {
    //    if (p instanceof ArrayProperty) {
    //        ArrayProperty ap = (ArrayProperty) p;
    //        Property inner = ap.getItems();
    //        if (inner == null) {
    //            return null;
    //        }
    //        return getSwaggerType(p) + "<" + getTypeDeclaration(inner) + ">";
    //    } else if (p instanceof MapProperty) {
    //        MapProperty mp = (MapProperty) p;
    //        Property inner = mp.getAdditionalProperties();
    //        if (inner == null) {
    //            return null;
    //        }
    //        return getSwaggerType(p) + "<String, " + getTypeDeclaration(inner) + ">";
    //    }
    //    return super.getTypeDeclaration(p);
    //}

}
