package io.realm;


import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmObject;
import io.realm.internal.ColumnType;
import io.realm.internal.ImplicitTransaction;
import io.realm.internal.LinkView;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import java.io.IOException;
import java.util.*;
import org.citruscircuits.realm.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UploadedTeamDataRealmProxy extends UploadedTeamData {

    @Override
    public String getPitOrganization() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(Realm.columnIndices.get("UploadedTeamData").get("pitOrganization"));
    }

    @Override
    public void setPitOrganization(String value) {
        realm.checkIfValid();
        row.setString(Realm.columnIndices.get("UploadedTeamData").get("pitOrganization"), (String) value);
    }

    @Override
    public String getProgrammingLanguage() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(Realm.columnIndices.get("UploadedTeamData").get("programmingLanguage"));
    }

    @Override
    public void setProgrammingLanguage(String value) {
        realm.checkIfValid();
        row.setString(Realm.columnIndices.get("UploadedTeamData").get("programmingLanguage"), (String) value);
    }

    @Override
    public String getPitNotes() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(Realm.columnIndices.get("UploadedTeamData").get("pitNotes"));
    }

    @Override
    public void setPitNotes(String value) {
        realm.checkIfValid();
        row.setString(Realm.columnIndices.get("UploadedTeamData").get("pitNotes"), (String) value);
    }

    @Override
    public boolean isCanMountMechanism() {
        realm.checkIfValid();
        return (boolean) row.getBoolean(Realm.columnIndices.get("UploadedTeamData").get("canMountMechanism"));
    }

    @Override
    public void setCanMountMechanism(boolean value) {
        realm.checkIfValid();
        row.setBoolean(Realm.columnIndices.get("UploadedTeamData").get("canMountMechanism"), (boolean) value);
    }

    @Override
    public boolean isWillingToMount() {
        realm.checkIfValid();
        return (boolean) row.getBoolean(Realm.columnIndices.get("UploadedTeamData").get("willingToMount"));
    }

    @Override
    public void setWillingToMount(boolean value) {
        realm.checkIfValid();
        row.setBoolean(Realm.columnIndices.get("UploadedTeamData").get("willingToMount"), (boolean) value);
    }

    @Override
    public float getEaseOfMounting() {
        realm.checkIfValid();
        return (float) row.getFloat(Realm.columnIndices.get("UploadedTeamData").get("easeOfMounting"));
    }

    @Override
    public void setEaseOfMounting(float value) {
        realm.checkIfValid();
        row.setFloat(Realm.columnIndices.get("UploadedTeamData").get("easeOfMounting"), (float) value);
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if(!transaction.hasTable("class_UploadedTeamData")) {
            Table table = transaction.getTable("class_UploadedTeamData");
            table.addColumn(ColumnType.STRING, "pitOrganization");
            table.addColumn(ColumnType.STRING, "programmingLanguage");
            table.addColumn(ColumnType.STRING, "pitNotes");
            table.addColumn(ColumnType.BOOLEAN, "canMountMechanism");
            table.addColumn(ColumnType.BOOLEAN, "willingToMount");
            table.addColumn(ColumnType.FLOAT, "easeOfMounting");
            return table;
        }
        return transaction.getTable("class_UploadedTeamData");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if(transaction.hasTable("class_UploadedTeamData")) {
            Table table = transaction.getTable("class_UploadedTeamData");
            if(table.getColumnCount() != 6) {
                throw new IllegalStateException("Column count does not match");
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for(long i = 0; i < 6; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }
            if (!columnTypes.containsKey("pitOrganization")) {
                throw new IllegalStateException("Missing column 'pitOrganization'");
            }
            if (columnTypes.get("pitOrganization") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'pitOrganization'");
            }
            if (!columnTypes.containsKey("programmingLanguage")) {
                throw new IllegalStateException("Missing column 'programmingLanguage'");
            }
            if (columnTypes.get("programmingLanguage") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'programmingLanguage'");
            }
            if (!columnTypes.containsKey("pitNotes")) {
                throw new IllegalStateException("Missing column 'pitNotes'");
            }
            if (columnTypes.get("pitNotes") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'pitNotes'");
            }
            if (!columnTypes.containsKey("canMountMechanism")) {
                throw new IllegalStateException("Missing column 'canMountMechanism'");
            }
            if (columnTypes.get("canMountMechanism") != ColumnType.BOOLEAN) {
                throw new IllegalStateException("Invalid type 'boolean' for column 'canMountMechanism'");
            }
            if (!columnTypes.containsKey("willingToMount")) {
                throw new IllegalStateException("Missing column 'willingToMount'");
            }
            if (columnTypes.get("willingToMount") != ColumnType.BOOLEAN) {
                throw new IllegalStateException("Invalid type 'boolean' for column 'willingToMount'");
            }
            if (!columnTypes.containsKey("easeOfMounting")) {
                throw new IllegalStateException("Missing column 'easeOfMounting'");
            }
            if (columnTypes.get("easeOfMounting") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'easeOfMounting'");
            }
        }
    }

    public static List<String> getFieldNames() {
        return Arrays.asList("pitOrganization", "programmingLanguage", "pitNotes", "canMountMechanism", "willingToMount", "easeOfMounting");
    }

    void populateUsingJsonObject(JSONObject json)
        throws JSONException {
        if (json.has("pitOrganization")) {
            setPitOrganization((String) json.getString("pitOrganization"));
        }
        if (json.has("programmingLanguage")) {
            setProgrammingLanguage((String) json.getString("programmingLanguage"));
        }
        if (json.has("pitNotes")) {
            setPitNotes((String) json.getString("pitNotes"));
        }
        if (json.has("canMountMechanism")) {
            setCanMountMechanism((boolean) json.getBoolean("canMountMechanism"));
        }
        if (json.has("willingToMount")) {
            setWillingToMount((boolean) json.getBoolean("willingToMount"));
        }
        if (json.has("easeOfMounting")) {
            setEaseOfMounting((float) json.getDouble("easeOfMounting"));
        }
    }

    void populateUsingJsonStream(JsonReader reader)
        throws IOException {
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("pitOrganization") && reader.peek() != JsonToken.NULL) {
                setPitOrganization((String) reader.nextString());
            } else if (name.equals("programmingLanguage")  && reader.peek() != JsonToken.NULL) {
                setProgrammingLanguage((String) reader.nextString());
            } else if (name.equals("pitNotes")  && reader.peek() != JsonToken.NULL) {
                setPitNotes((String) reader.nextString());
            } else if (name.equals("canMountMechanism")  && reader.peek() != JsonToken.NULL) {
                setCanMountMechanism((boolean) reader.nextBoolean());
            } else if (name.equals("willingToMount")  && reader.peek() != JsonToken.NULL) {
                setWillingToMount((boolean) reader.nextBoolean());
            } else if (name.equals("easeOfMounting")  && reader.peek() != JsonToken.NULL) {
                setEaseOfMounting((float) reader.nextDouble());
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("UploadedTeamData = [");
        stringBuilder.append("{pitOrganization:");
        stringBuilder.append(getPitOrganization());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{programmingLanguage:");
        stringBuilder.append(getProgrammingLanguage());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{pitNotes:");
        stringBuilder.append(getPitNotes());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{canMountMechanism:");
        stringBuilder.append(isCanMountMechanism());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{willingToMount:");
        stringBuilder.append(isWillingToMount());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{easeOfMounting:");
        stringBuilder.append(getEaseOfMounting());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        String realmName = realm.getPath();
        String tableName = row.getTable().getName();
        long rowIndex = row.getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UploadedTeamDataRealmProxy aUploadedTeamData = (UploadedTeamDataRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aUploadedTeamData.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aUploadedTeamData.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aUploadedTeamData.row.getIndex()) return false;

        return true;
    }

}
