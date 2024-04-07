package com.vpbank.common.model;



@javax.annotation.processing.Generated("dsl_json")
public class _WofMAccount_DslJsonConverter implements com.dslplatform.json.Configuration {
	private static final java.nio.charset.Charset utf8 = java.nio.charset.Charset.forName("UTF-8");
	@Override
	public void configure(com.dslplatform.json.DslJson __dsljson) {
		ObjectFormatConverter objectConverter = new ObjectFormatConverter(__dsljson);
		__dsljson.registerBinder(com.vpbank.common.model.WofMAccount.class, objectConverter);
		__dsljson.registerReader(com.vpbank.common.model.WofMAccount.class, objectConverter);
		__dsljson.registerWriter(com.vpbank.common.model.WofMAccount.class, objectConverter);
	}
	public final static class ObjectFormatConverter implements com.dslplatform.json.runtime.FormatConverter<com.vpbank.common.model.WofMAccount>, com.dslplatform.json.JsonReader.BindObject<com.vpbank.common.model.WofMAccount> {
		private final boolean alwaysSerialize;
		private final com.dslplatform.json.DslJson __dsljson;
		public ObjectFormatConverter(com.dslplatform.json.DslJson __dsljson) {
			this.alwaysSerialize = !__dsljson.omitDefaults;
			this.__dsljson = __dsljson;
		}
		public com.vpbank.common.model.WofMAccount read(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			if (reader.wasNull()) return null;
			return bind(reader, new com.vpbank.common.model.WofMAccount());
		}
		private static final byte[] quoted_jti = "\"jti\":".getBytes(utf8);
		private static final byte[] name_jti = "jti".getBytes(utf8);
		private static final byte[] quoted_email = ",\"email\":".getBytes(utf8);
		private static final byte[] name_email = "email".getBytes(utf8);
		private static final byte[] quoted_iat = ",\"iat\":".getBytes(utf8);
		private static final byte[] name_iat = "iat".getBytes(utf8);
		private static final byte[] quoted_exp = ",\"exp\":".getBytes(utf8);
		private static final byte[] name_exp = "exp".getBytes(utf8);
		private static final byte[] quoted_id = ",\"id\":".getBytes(utf8);
		private static final byte[] name_id = "id".getBytes(utf8);
		private static final byte[] quoted_address = ",\"sub\":".getBytes(utf8);
		private static final byte[] name_address = "sub".getBytes(utf8);
		public final void write(final com.dslplatform.json.JsonWriter writer, final com.vpbank.common.model.WofMAccount instance) {
			if (instance == null) writer.writeNull();
			else {
				writer.writeByte((byte)'{');
				if (alwaysSerialize) { writeContentFull(writer, instance); writer.writeByte((byte)'}'); }
				else if (writeContentMinimal(writer, instance)) writer.getByteBuffer()[writer.size() - 1] = '}';
				else writer.writeByte((byte)'}');
			}
		}
		public void writeContentFull(final com.dslplatform.json.JsonWriter writer, final com.vpbank.common.model.WofMAccount instance) {
			writer.writeAscii(quoted_jti);
			if (instance.getJti() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getJti(), writer);
			writer.writeAscii(quoted_email);
			if (instance.getEmail() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getEmail(), writer);
			writer.writeAscii(quoted_iat);
			if (instance.getIat() == null) writer.writeNull();
			else com.dslplatform.json.NumberConverter.serialize(instance.getIat(), writer);
			writer.writeAscii(quoted_exp);
			if (instance.getExp() == null) writer.writeNull();
			else com.dslplatform.json.NumberConverter.serialize(instance.getExp(), writer);
			writer.writeAscii(quoted_id);
			if (instance.getId() == null) writer.writeNull();
			else com.dslplatform.json.NumberConverter.serialize(instance.getId(), writer);
			writer.writeAscii(quoted_address);
			if (instance.getAddress() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getAddress(), writer);
		}
		public boolean writeContentMinimal(final com.dslplatform.json.JsonWriter writer, final com.vpbank.common.model.WofMAccount instance) {
			boolean hasWritten = false;
			if (instance.getJti() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_jti); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getJti(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getEmail() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_email); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getEmail(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getIat() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_iat); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.NumberConverter.serialize(instance.getIat(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getExp() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_exp); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.NumberConverter.serialize(instance.getExp(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getId() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_id); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.NumberConverter.serialize(instance.getId(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getAddress() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_address); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getAddress(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			return hasWritten;
		}
		public com.vpbank.common.model.WofMAccount bind(final com.dslplatform.json.JsonReader reader, final com.vpbank.common.model.WofMAccount instance) throws java.io.IOException {
			if (reader.last() != '{') throw reader.newParseError("Expecting '{' for object start");
			reader.getNextToken();
			bindContent(reader, instance);
			return instance;
		}
		public com.vpbank.common.model.WofMAccount readContent(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			com.vpbank.common.model.WofMAccount instance = new com.vpbank.common.model.WofMAccount();
 			bindContent(reader, instance);
			return instance;
		}
		public void bindContent(final com.dslplatform.json.JsonReader reader, final com.vpbank.common.model.WofMAccount instance) throws java.io.IOException {
			if (reader.last() == '}') return;
			if (reader.fillNameWeakHash() != 327 || !reader.wasLastName(name_jti)) { bindSlow(reader, instance, 0); return; }
			reader.getNextToken();
			instance.setJti(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 520 || !reader.wasLastName(name_email)) { bindSlow(reader, instance, 1); return; }
			reader.getNextToken();
			instance.setEmail(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 318 || !reader.wasLastName(name_iat)) { bindSlow(reader, instance, 2); return; }
			reader.getNextToken();
			instance.setIat(com.dslplatform.json.NumberConverter.NULLABLE_LONG_READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 333 || !reader.wasLastName(name_exp)) { bindSlow(reader, instance, 3); return; }
			reader.getNextToken();
			instance.setExp(com.dslplatform.json.NumberConverter.NULLABLE_LONG_READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 205 || !reader.wasLastName(name_id)) { bindSlow(reader, instance, 4); return; }
			reader.getNextToken();
			instance.setId(com.dslplatform.json.NumberConverter.NULLABLE_LONG_READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 330 || !reader.wasLastName(name_address)) { bindSlow(reader, instance, 5); return; }
			reader.getNextToken();
			instance.setAddress(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() != '}') {
				if (reader.last() == ',') {
					reader.getNextToken();
					reader.fillNameWeakHash();
					bindSlow(reader, instance, 6);
				}
				if (reader.last() != '}') throw reader.newParseError("Expecting '}' for object end");
			}
		}
		private void bindSlow(final com.dslplatform.json.JsonReader reader, final com.vpbank.common.model.WofMAccount instance, int index) throws java.io.IOException {
			switch(reader.getLastHash()) {
				case -598853355:
					reader.getNextToken();
					instance.setAddress(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case 926444256:
					reader.getNextToken();
					instance.setId(com.dslplatform.json.NumberConverter.NULLABLE_LONG_READER.read(reader));
					reader.getNextToken();
					break;
				case 1923516200:
					reader.getNextToken();
					instance.setExp(com.dslplatform.json.NumberConverter.NULLABLE_LONG_READER.read(reader));
					reader.getNextToken();
					break;
				case -1747143279:
					reader.getNextToken();
					instance.setIat(com.dslplatform.json.NumberConverter.NULLABLE_LONG_READER.read(reader));
					reader.getNextToken();
					break;
				case -1970842681:
					reader.getNextToken();
					instance.setEmail(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case -1061274650:
					reader.getNextToken();
					instance.setJti(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				default:
					reader.getNextToken();
					reader.skip();
			}
			while (reader.last() == ','){
				reader.getNextToken();
				switch(reader.fillName()) {
					case -598853355:
						reader.getNextToken();
						instance.setAddress(com.dslplatform.json.StringConverter.READER.read(reader));
						reader.getNextToken();
						break;
					case 926444256:
						reader.getNextToken();
						instance.setId(com.dslplatform.json.NumberConverter.NULLABLE_LONG_READER.read(reader));
						reader.getNextToken();
						break;
					case 1923516200:
						reader.getNextToken();
						instance.setExp(com.dslplatform.json.NumberConverter.NULLABLE_LONG_READER.read(reader));
						reader.getNextToken();
						break;
					case -1747143279:
						reader.getNextToken();
						instance.setIat(com.dslplatform.json.NumberConverter.NULLABLE_LONG_READER.read(reader));
						reader.getNextToken();
						break;
					case -1970842681:
						reader.getNextToken();
						instance.setEmail(com.dslplatform.json.StringConverter.READER.read(reader));
						reader.getNextToken();
						break;
					case -1061274650:
						reader.getNextToken();
						instance.setJti(com.dslplatform.json.StringConverter.READER.read(reader));
						reader.getNextToken();
						break;
					default:
						reader.getNextToken();
						reader.skip();
				}
			}
			if (reader.last() != '}') throw reader.newParseError("Expecting '}' for object end");
		}
	}
}
