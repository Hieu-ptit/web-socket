package com.vpbank.common.model.response;



@javax.annotation.processing.Generated("dsl_json")
public class _Response$Metadata_DslJsonConverter implements com.dslplatform.json.Configuration {
	private static final java.nio.charset.Charset utf8 = java.nio.charset.Charset.forName("UTF-8");
	@Override
	public void configure(com.dslplatform.json.DslJson __dsljson) {
		ObjectFormatConverter objectConverter = new ObjectFormatConverter(__dsljson);
		__dsljson.registerReader(com.vpbank.common.model.response.Response.Metadata.class, objectConverter);
		__dsljson.registerWriter(com.vpbank.common.model.response.Response.Metadata.class, objectConverter);
	}
	public final static class ObjectFormatConverter implements com.dslplatform.json.runtime.FormatConverter<com.vpbank.common.model.response.Response.Metadata> {
		private final boolean alwaysSerialize;
		private final com.dslplatform.json.DslJson __dsljson;
		private com.dslplatform.json.JsonReader.ReadObject<com.vpbank.common.exception.FieldViolation> reader_errors;
		private com.dslplatform.json.JsonReader.ReadObject<com.vpbank.common.exception.FieldViolation> reader_errors() {
			if (reader_errors == null) {
				java.lang.reflect.Type manifest = com.vpbank.common.exception.FieldViolation.class;
				reader_errors = __dsljson.tryFindReader(manifest);
				if (reader_errors == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find reader for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return reader_errors;
		}
		private com.dslplatform.json.JsonWriter.WriteObject<com.vpbank.common.exception.FieldViolation> writer_errors;
		private com.dslplatform.json.JsonWriter.WriteObject<com.vpbank.common.exception.FieldViolation> writer_errors() {
			if (writer_errors == null) {
				java.lang.reflect.Type manifest = com.vpbank.common.exception.FieldViolation.class;
				writer_errors = __dsljson.tryFindWriter(manifest);
				if (writer_errors == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find writer for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return writer_errors;
		}
		public ObjectFormatConverter(com.dslplatform.json.DslJson __dsljson) {
			this.alwaysSerialize = !__dsljson.omitDefaults;
			this.__dsljson = __dsljson;
		}
		private static final byte[] quoted_code = "\"code\":".getBytes(utf8);
		private static final byte[] name_code = "code".getBytes(utf8);
		private static final byte[] quoted_page = ",\"page\":".getBytes(utf8);
		private static final byte[] name_page = "page".getBytes(utf8);
		private static final byte[] quoted_size = ",\"size\":".getBytes(utf8);
		private static final byte[] name_size = "size".getBytes(utf8);
		private static final byte[] quoted_total = ",\"total\":".getBytes(utf8);
		private static final byte[] name_total = "total".getBytes(utf8);
		private static final byte[] quoted_message = ",\"message\":".getBytes(utf8);
		private static final byte[] name_message = "message".getBytes(utf8);
		private static final byte[] quoted_errors = ",\"errors\":".getBytes(utf8);
		private static final byte[] name_errors = "errors".getBytes(utf8);
		public final void write(final com.dslplatform.json.JsonWriter writer, final com.vpbank.common.model.response.Response.Metadata instance) {
			if (instance == null) writer.writeNull();
			else {
				writer.writeByte((byte)'{');
				if (alwaysSerialize) { writeContentFull(writer, instance); writer.writeByte((byte)'}'); }
				else if (writeContentMinimal(writer, instance)) writer.getByteBuffer()[writer.size() - 1] = '}';
				else writer.writeByte((byte)'}');
			}
		}
		public void writeContentFull(final com.dslplatform.json.JsonWriter writer, final com.vpbank.common.model.response.Response.Metadata instance) {
			writer.writeAscii(quoted_code);
			if (instance.getCode() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getCode(), writer);
			writer.writeAscii(quoted_page);
			if (instance.getPage() == null) writer.writeNull();
			else com.dslplatform.json.NumberConverter.serialize(instance.getPage(), writer);
			writer.writeAscii(quoted_size);
			if (instance.getSize() == null) writer.writeNull();
			else com.dslplatform.json.NumberConverter.serialize(instance.getSize(), writer);
			writer.writeAscii(quoted_total);
			if (instance.getTotal() == null) writer.writeNull();
			else com.dslplatform.json.NumberConverter.serialize(instance.getTotal(), writer);
			writer.writeAscii(quoted_message);
			if (instance.getMessage() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getMessage(), writer);
			writer.writeAscii(quoted_errors);
			if (instance.getErrors() == null) writer.writeNull();
			else writer.serialize(instance.getErrors(), writer_errors());
		}
		public boolean writeContentMinimal(final com.dslplatform.json.JsonWriter writer, final com.vpbank.common.model.response.Response.Metadata instance) {
			boolean hasWritten = false;
			if (instance.getCode() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_code); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getCode(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getPage() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_page); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.NumberConverter.serialize(instance.getPage(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getSize() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_size); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.NumberConverter.serialize(instance.getSize(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getTotal() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_total); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.NumberConverter.serialize(instance.getTotal(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getMessage() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_message); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getMessage(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getErrors() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_errors); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				writer.serialize(instance.getErrors(), writer_errors());
				writer.writeByte((byte)','); hasWritten = true;
			}
			return hasWritten;
		}
		public com.vpbank.common.model.response.Response.Metadata read(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			if (reader.wasNull()) return null;
			else if (reader.last() != '{') throw reader.newParseError("Expecting '{' for object start");
			reader.getNextToken();
			return readContent(reader);
		}
		public com.vpbank.common.model.response.Response.Metadata readContent(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			java.lang.String _code_ = null;
			java.lang.Integer _page_ = null;
			java.lang.Integer _size_ = null;
			java.lang.Long _total_ = null;
			java.lang.String _message_ = null;
			java.util.List<com.vpbank.common.exception.FieldViolation> _errors_ = null;
			if (reader.last() == '}') {
				return new com.vpbank.common.model.response.Response.Metadata(_code_, _page_, _size_, _total_, _message_, _errors_);
			}
			switch(reader.fillName()) {
				case 80777981:
					reader.getNextToken();
					_total_ = com.dslplatform.json.NumberConverter.NULLABLE_LONG_READER.read(reader);
					reader.getNextToken();
					break;
				case -114201356:
					reader.getNextToken();
					_code_ = com.dslplatform.json.StringConverter.READER.read(reader);
					reader.getNextToken();
					break;
				case 597743964:
					reader.getNextToken();
					_size_ = com.dslplatform.json.NumberConverter.NULLABLE_INT_READER.read(reader);
					reader.getNextToken();
					break;
				case -2124547466:
					reader.getNextToken();
					_page_ = com.dslplatform.json.NumberConverter.NULLABLE_INT_READER.read(reader);
					reader.getNextToken();
					break;
				case 619841764:
					reader.getNextToken();
					_message_ = com.dslplatform.json.StringConverter.READER.read(reader);
					reader.getNextToken();
					break;
				case -99108218:
					reader.getNextToken();
					_errors_ = reader.readCollection(reader_errors());
					reader.getNextToken();
					break;
				default:
					reader.getNextToken();
					reader.skip();
			}
			while (reader.last() == ','){
				reader.getNextToken();
				switch(reader.fillName()) {
					case 80777981:
						reader.getNextToken();
						_total_ = com.dslplatform.json.NumberConverter.NULLABLE_LONG_READER.read(reader);
						reader.getNextToken();
						break;
					case -114201356:
						reader.getNextToken();
						_code_ = com.dslplatform.json.StringConverter.READER.read(reader);
						reader.getNextToken();
						break;
					case 597743964:
						reader.getNextToken();
						_size_ = com.dslplatform.json.NumberConverter.NULLABLE_INT_READER.read(reader);
						reader.getNextToken();
						break;
					case -2124547466:
						reader.getNextToken();
						_page_ = com.dslplatform.json.NumberConverter.NULLABLE_INT_READER.read(reader);
						reader.getNextToken();
						break;
					case 619841764:
						reader.getNextToken();
						_message_ = com.dslplatform.json.StringConverter.READER.read(reader);
						reader.getNextToken();
						break;
					case -99108218:
						reader.getNextToken();
						_errors_ = reader.readCollection(reader_errors());
						reader.getNextToken();
						break;
					default:
						reader.getNextToken();
						reader.skip();
				}
			}
			if (reader.last() != '}') throw reader.newParseError("Expecting '}' for object end");
			return new com.vpbank.common.model.response.Response.Metadata(_code_, _page_, _size_, _total_, _message_, _errors_);
		}
	}
}
