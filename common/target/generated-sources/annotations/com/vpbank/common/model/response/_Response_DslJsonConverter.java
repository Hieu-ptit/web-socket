package com.vpbank.common.model.response;



@javax.annotation.processing.Generated("dsl_json")
public class _Response_DslJsonConverter implements com.dslplatform.json.Configuration {
	private static final java.nio.charset.Charset utf8 = java.nio.charset.Charset.forName("UTF-8");
	@Override
	public void configure(com.dslplatform.json.DslJson __dsljson) {
		ConverterFactory factory = new ConverterFactory();
		__dsljson.registerReaderFactory(factory);
		__dsljson.registerWriterFactory(factory);
	}
	private final static class ConverterFactory implements com.dslplatform.json.DslJson.ConverterFactory<ObjectFormatConverter> {
		@Override
		public ObjectFormatConverter tryCreate(java.lang.reflect.Type manifest, com.dslplatform.json.DslJson __dsljson) {
			if (manifest instanceof java.lang.reflect.ParameterizedType) {
				java.lang.reflect.ParameterizedType pt = (java.lang.reflect.ParameterizedType) manifest;
				java.lang.Class<?> rawClass = (java.lang.Class<?>) pt.getRawType();
				if (rawClass.isAssignableFrom(com.vpbank.common.model.response.Response.class)) {
					return new ObjectFormatConverter(__dsljson, pt.getActualTypeArguments());
				}
			} else if (com.vpbank.common.model.response.Response.class.equals(manifest)) {
				java.lang.reflect.Type[] unknownArgs = new java.lang.reflect.Type[1];
				java.util.Arrays.fill(unknownArgs, Object.class);
				if (__dsljson.tryFindReader(Object.class) != null && __dsljson.tryFindWriter(Object.class) != null) {
					return new ObjectFormatConverter(__dsljson, unknownArgs);
				}
			}
			return null;
		}
	}
	public final static class ObjectFormatConverter<T extends java.lang.Object> implements com.dslplatform.json.runtime.FormatConverter<com.vpbank.common.model.response.Response<T>> {
		private final boolean alwaysSerialize;
		private final com.dslplatform.json.DslJson __dsljson;
		private final java.lang.reflect.Type[] actualTypes;
		private final com.dslplatform.json.JsonReader.ReadObject<T> reader_data;
		private final com.dslplatform.json.JsonWriter.WriteObject<T> writer_data;
		private com.dslplatform.json.JsonReader.ReadObject<com.vpbank.common.model.response.Response.Metadata> reader_meta;
		private com.dslplatform.json.JsonReader.ReadObject<com.vpbank.common.model.response.Response.Metadata> reader_meta() {
			if (reader_meta == null) {
				java.lang.reflect.Type manifest = com.vpbank.common.model.response.Response.Metadata.class;
				reader_meta = __dsljson.tryFindReader(manifest);
				if (reader_meta == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find reader for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return reader_meta;
		}
		private com.dslplatform.json.JsonWriter.WriteObject<com.vpbank.common.model.response.Response.Metadata> writer_meta;
		private com.dslplatform.json.JsonWriter.WriteObject<com.vpbank.common.model.response.Response.Metadata> writer_meta() {
			if (writer_meta == null) {
				java.lang.reflect.Type manifest = com.vpbank.common.model.response.Response.Metadata.class;
				writer_meta = __dsljson.tryFindWriter(manifest);
				if (writer_meta == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find writer for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return writer_meta;
		}
		public ObjectFormatConverter(com.dslplatform.json.DslJson __dsljson, java.lang.reflect.Type[] actualTypes) {
			this.alwaysSerialize = !__dsljson.omitDefaults;
			this.__dsljson = __dsljson;
			this.actualTypes = actualTypes;
			java.lang.reflect.Type manifest_data = actualTypes[0];
			this.reader_data = __dsljson.tryFindReader(manifest_data);
			if (reader_data == null) {
				throw new com.dslplatform.json.ConfigurationException("Unable to find reader for " + manifest_data + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.withRuntime().includeServiceLoader())");
			}
			this.writer_data = __dsljson.tryFindWriter(manifest_data);
			if (writer_data == null) {
				throw new com.dslplatform.json.ConfigurationException("Unable to find writer for " + manifest_data + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.withRuntime().includeServiceLoader())");
			}
		}
		private static final byte[] quoted_data = "\"data\":".getBytes(utf8);
		private static final byte[] name_data = "data".getBytes(utf8);
		private static final byte[] quoted_meta = ",\"meta\":".getBytes(utf8);
		private static final byte[] name_meta = "meta".getBytes(utf8);
		public final void write(final com.dslplatform.json.JsonWriter writer, final com.vpbank.common.model.response.Response<T> instance) {
			if (instance == null) writer.writeNull();
			else {
				writer.writeByte((byte)'{');
				if (alwaysSerialize) { writeContentFull(writer, instance); writer.writeByte((byte)'}'); }
				else if (writeContentMinimal(writer, instance)) writer.getByteBuffer()[writer.size() - 1] = '}';
				else writer.writeByte((byte)'}');
			}
		}
		public void writeContentFull(final com.dslplatform.json.JsonWriter writer, final com.vpbank.common.model.response.Response<T> instance) {
			writer.writeAscii(quoted_data);
			if (instance.getData() == null) writer.writeNull();
			else writer_data.write(writer, instance.getData());
			writer.writeAscii(quoted_meta);
			if (instance.getMeta() == null) writer.writeNull();
			else writer_meta().write(writer, instance.getMeta());
		}
		public boolean writeContentMinimal(final com.dslplatform.json.JsonWriter writer, final com.vpbank.common.model.response.Response<T> instance) {
			boolean hasWritten = false;
			if (instance.getData() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_data); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				writer_data.write(writer, instance.getData());
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getMeta() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_meta); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				writer_meta().write(writer, instance.getMeta());
				writer.writeByte((byte)','); hasWritten = true;
			}
			return hasWritten;
		}
		public com.vpbank.common.model.response.Response<T> read(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			if (reader.wasNull()) return null;
			else if (reader.last() != '{') throw reader.newParseError("Expecting '{' for object start");
			reader.getNextToken();
			return readContent(reader);
		}
		public com.vpbank.common.model.response.Response<T> readContent(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			T _data_ = null;
			com.vpbank.common.model.response.Response.Metadata _meta_ = null;
			if (reader.last() == '}') {
				return new com.vpbank.common.model.response.Response<T>(_data_, _meta_);
			}
			switch(reader.fillName()) {
				case -663559515:
					reader.getNextToken();
					_data_ = reader_data.read(reader);
					reader.getNextToken();
					break;
				case -2114039976:
					reader.getNextToken();
					_meta_ = reader_meta().read(reader);
					reader.getNextToken();
					break;
				default:
					reader.getNextToken();
					reader.skip();
			}
			while (reader.last() == ','){
				reader.getNextToken();
				switch(reader.fillName()) {
					case -663559515:
						reader.getNextToken();
						_data_ = reader_data.read(reader);
						reader.getNextToken();
						break;
					case -2114039976:
						reader.getNextToken();
						_meta_ = reader_meta().read(reader);
						reader.getNextToken();
						break;
					default:
						reader.getNextToken();
						reader.skip();
				}
			}
			if (reader.last() != '}') throw reader.newParseError("Expecting '}' for object end");
			return new com.vpbank.common.model.response.Response<T>(_data_, _meta_);
		}
	}
}
