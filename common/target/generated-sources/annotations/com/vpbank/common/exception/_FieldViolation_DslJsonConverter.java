package com.vpbank.common.exception;



@javax.annotation.processing.Generated("dsl_json")
public class _FieldViolation_DslJsonConverter implements com.dslplatform.json.Configuration {
	private static final java.nio.charset.Charset utf8 = java.nio.charset.Charset.forName("UTF-8");
	@Override
	public void configure(com.dslplatform.json.DslJson __dsljson) {
		ObjectFormatConverter objectConverter = new ObjectFormatConverter(__dsljson);
		__dsljson.registerReader(com.vpbank.common.exception.FieldViolation.class, objectConverter);
		__dsljson.registerWriter(com.vpbank.common.exception.FieldViolation.class, objectConverter);
	}
	public final static class ObjectFormatConverter implements com.dslplatform.json.runtime.FormatConverter<com.vpbank.common.exception.FieldViolation> {
		private final boolean alwaysSerialize;
		private final com.dslplatform.json.DslJson __dsljson;
		public ObjectFormatConverter(com.dslplatform.json.DslJson __dsljson) {
			this.alwaysSerialize = !__dsljson.omitDefaults;
			this.__dsljson = __dsljson;
		}
		private static final byte[] quoted_field = "\"field\":".getBytes(utf8);
		private static final byte[] name_field = "field".getBytes(utf8);
		private static final byte[] quoted_description = ",\"description\":".getBytes(utf8);
		private static final byte[] name_description = "description".getBytes(utf8);
		public final void write(final com.dslplatform.json.JsonWriter writer, final com.vpbank.common.exception.FieldViolation instance) {
			if (instance == null) writer.writeNull();
			else {
				writer.writeByte((byte)'{');
				if (alwaysSerialize) { writeContentFull(writer, instance); writer.writeByte((byte)'}'); }
				else if (writeContentMinimal(writer, instance)) writer.getByteBuffer()[writer.size() - 1] = '}';
				else writer.writeByte((byte)'}');
			}
		}
		public void writeContentFull(final com.dslplatform.json.JsonWriter writer, final com.vpbank.common.exception.FieldViolation instance) {
			writer.writeAscii(quoted_field);
			if (instance.getField() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getField(), writer);
			writer.writeAscii(quoted_description);
			if (instance.getDescription() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getDescription(), writer);
		}
		public boolean writeContentMinimal(final com.dslplatform.json.JsonWriter writer, final com.vpbank.common.exception.FieldViolation instance) {
			boolean hasWritten = false;
			if (instance.getField() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_field); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getField(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getDescription() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_description); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getDescription(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			return hasWritten;
		}
		public com.vpbank.common.exception.FieldViolation read(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			if (reader.wasNull()) return null;
			else if (reader.last() != '{') throw reader.newParseError("Expecting '{' for object start");
			reader.getNextToken();
			return readContent(reader);
		}
		public com.vpbank.common.exception.FieldViolation readContent(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			java.lang.String _field_ = null;
			java.lang.String _description_ = null;
			if (reader.last() == '}') {
				return new com.vpbank.common.exception.FieldViolation(_field_, _description_);
			}
			switch(reader.fillName()) {
				case 1736598119:
					reader.getNextToken();
					_field_ = com.dslplatform.json.StringConverter.READER.read(reader);
					reader.getNextToken();
					break;
				case 879704937:
					reader.getNextToken();
					_description_ = com.dslplatform.json.StringConverter.READER.read(reader);
					reader.getNextToken();
					break;
				default:
					reader.getNextToken();
					reader.skip();
			}
			while (reader.last() == ','){
				reader.getNextToken();
				switch(reader.fillName()) {
					case 1736598119:
						reader.getNextToken();
						_field_ = com.dslplatform.json.StringConverter.READER.read(reader);
						reader.getNextToken();
						break;
					case 879704937:
						reader.getNextToken();
						_description_ = com.dslplatform.json.StringConverter.READER.read(reader);
						reader.getNextToken();
						break;
					default:
						reader.getNextToken();
						reader.skip();
				}
			}
			if (reader.last() != '}') throw reader.newParseError("Expecting '}' for object end");
			return new com.vpbank.common.exception.FieldViolation(_field_, _description_);
		}
	}
}
