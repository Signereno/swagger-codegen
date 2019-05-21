package io.swagger.codegen.languages;

import io.swagger.codegen.*;

import io.swagger.models.Model;
import io.swagger.models.properties.ArrayProperty;
import io.swagger.models.properties.MapProperty;
import io.swagger.models.properties.Property;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

import static java.util.Collections.sort;

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

    @Override
    public Map<String, Object> postProcessOperations(Map<String, Object> objs) {
        super.postProcessOperations(objs);
        Map<String, Object> operations = (Map<String, Object>) objs.get("operations");
        if (operations != null) {
            List<CodegenOperation> ops = (List<CodegenOperation>) operations.get("operation");
            for (CodegenOperation operation : ops) {
                if (operation.returnBaseType != null && operation.returnBaseType == "Object") {
                    operation.returnBaseType = null;

                }
            }
        }
        return objs;
    }

    @Override
    public String toApiName(String name) {
        if (name.length() == 0) {
            return "DefaultService";
        }
        return camelize(name) + "Service";
    }

}
