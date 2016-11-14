package net.trigyan.glide.repository.model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class ConfigurationSerializer extends StdSerializer<BaseConfiguration> {

	
	


	public ConfigurationSerializer(Class<BaseConfiguration> t) {
		super(t);
		// TODO Auto-generated constructor stub
	}





	public ConfigurationSerializer() {
		this(null);
	}
	

	

	@Override
	public void serialize(BaseConfiguration value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject();
		gen.writeStringField(value.propertyName.stringValue(),value.propertyValue.stringValue());
		gen.writeEndObject();

	}

}
