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

public class TeamRealmProxy extends Team {

    @Override
    public int getNumber() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("Team").get("number"));
    }

    @Override
    public void setNumber(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("Team").get("number"), (long) value);
    }

    @Override
    public String getName() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(Realm.columnIndices.get("Team").get("name"));
    }

    @Override
    public void setName(String value) {
        realm.checkIfValid();
        row.setString(Realm.columnIndices.get("Team").get("name"), (String) value);
    }

    @Override
    public int getSeed() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("Team").get("seed"));
    }

    @Override
    public void setSeed(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("Team").get("seed"), (long) value);
    }

    @Override
    public RealmList<org.citruscircuits.realm.TeamInMatchData> getMatchData() {
        return new RealmList<TeamInMatchData>(TeamInMatchData.class, row.getLinkList(Realm.columnIndices.get("Team").get("matchData")), realm);
    }

    @Override
    public void setMatchData(RealmList<org.citruscircuits.realm.TeamInMatchData> value) {
        LinkView links = row.getLinkList(Realm.columnIndices.get("Team").get("matchData"));
        if (value == null) {
            return;
        }
        for (RealmObject linkedObject : (RealmList<? extends RealmObject>) value) {
            links.add(linkedObject.row.getIndex());
        }
    }

    @Override
    public org.citruscircuits.realm.CalculatedTeamData getCalculatedData() {
        if (row.isNullLink(Realm.columnIndices.get("Team").get("calculatedData"))) {
            return null;
        }
        return realm.get(org.citruscircuits.realm.CalculatedTeamData.class, row.getLink(Realm.columnIndices.get("Team").get("calculatedData")));
    }

    @Override
    public void setCalculatedData(org.citruscircuits.realm.CalculatedTeamData value) {
        if (value == null) {
            row.nullifyLink(Realm.columnIndices.get("Team").get("calculatedData"));
        }
        row.setLink(Realm.columnIndices.get("Team").get("calculatedData"), value.row.getIndex());
    }

    @Override
    public org.citruscircuits.realm.UploadedTeamData getUploadedData() {
        if (row.isNullLink(Realm.columnIndices.get("Team").get("uploadedData"))) {
            return null;
        }
        return realm.get(org.citruscircuits.realm.UploadedTeamData.class, row.getLink(Realm.columnIndices.get("Team").get("uploadedData")));
    }

    @Override
    public void setUploadedData(org.citruscircuits.realm.UploadedTeamData value) {
        if (value == null) {
            row.nullifyLink(Realm.columnIndices.get("Team").get("uploadedData"));
        }
        row.setLink(Realm.columnIndices.get("Team").get("uploadedData"), value.row.getIndex());
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if(!transaction.hasTable("class_Team")) {
            Table table = transaction.getTable("class_Team");
            table.addColumn(ColumnType.INTEGER, "number");
            table.addColumn(ColumnType.STRING, "name");
            table.addColumn(ColumnType.INTEGER, "seed");
            if (!transaction.hasTable("class_TeamInMatchData")) {
                TeamInMatchDataRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK_LIST, "matchData", transaction.getTable("class_TeamInMatchData"));
            if (!transaction.hasTable("class_CalculatedTeamData")) {
                CalculatedTeamDataRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK, "calculatedData", transaction.getTable("class_CalculatedTeamData"));
            if (!transaction.hasTable("class_UploadedTeamData")) {
                UploadedTeamDataRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK, "uploadedData", transaction.getTable("class_UploadedTeamData"));
            return table;
        }
        return transaction.getTable("class_Team");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if(transaction.hasTable("class_Team")) {
            Table table = transaction.getTable("class_Team");
            if(table.getColumnCount() != 6) {
                throw new IllegalStateException("Column count does not match");
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for(long i = 0; i < 6; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }
            if (!columnTypes.containsKey("number")) {
                throw new IllegalStateException("Missing column 'number'");
            }
            if (columnTypes.get("number") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'number'");
            }
            if (!columnTypes.containsKey("name")) {
                throw new IllegalStateException("Missing column 'name'");
            }
            if (columnTypes.get("name") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'name'");
            }
            if (!columnTypes.containsKey("seed")) {
                throw new IllegalStateException("Missing column 'seed'");
            }
            if (columnTypes.get("seed") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'seed'");
            }
            if(!columnTypes.containsKey("matchData")) {
                throw new IllegalStateException("Missing column 'matchData'");
            }
            if(columnTypes.get("matchData") != ColumnType.LINK_LIST) {
                throw new IllegalStateException("Invalid type 'TeamInMatchData' for column 'matchData'");
            }
            if (!transaction.hasTable("class_TeamInMatchData")) {
                throw new IllegalStateException("Missing table 'class_TeamInMatchData' for column 'matchData'");
            }
            if (!columnTypes.containsKey("calculatedData")) {
                throw new IllegalStateException("Missing column 'calculatedData'");
            }
            if (columnTypes.get("calculatedData") != ColumnType.LINK) {
                throw new IllegalStateException("Invalid type 'CalculatedTeamData' for column 'calculatedData'");
            }
            if (!transaction.hasTable("class_CalculatedTeamData")) {
                throw new IllegalStateException("Missing table 'class_CalculatedTeamData' for column 'calculatedData'");
            }
            if (!columnTypes.containsKey("uploadedData")) {
                throw new IllegalStateException("Missing column 'uploadedData'");
            }
            if (columnTypes.get("uploadedData") != ColumnType.LINK) {
                throw new IllegalStateException("Invalid type 'UploadedTeamData' for column 'uploadedData'");
            }
            if (!transaction.hasTable("class_UploadedTeamData")) {
                throw new IllegalStateException("Missing table 'class_UploadedTeamData' for column 'uploadedData'");
            }
        }
    }

    public static List<String> getFieldNames() {
        return Arrays.asList("number", "name", "seed", "matchData", "calculatedData", "uploadedData");
    }

    void populateUsingJsonObject(JSONObject json)
        throws JSONException {
        if (json.has("number")) {
            setNumber((int) json.getInt("number"));
        }
        if (json.has("name")) {
            setName((String) json.getString("name"));
        }
        if (json.has("seed")) {
            setSeed((int) json.getInt("seed"));
        }
        if (json.has("matchData")) {
            JSONArray array = json.getJSONArray("matchData");
            for (int i = 0; i < array.length(); i++) {
                org.citruscircuits.realm.TeamInMatchData obj = realm.createObject(org.citruscircuits.realm.TeamInMatchData.class);
                ((RealmObject) obj).populateUsingJsonObject(array.getJSONObject(i));
                getMatchData().add(obj);
            }
        }
        if (json.has("calculatedData")) {
            org.citruscircuits.realm.CalculatedTeamData obj = realm.createObject(org.citruscircuits.realm.CalculatedTeamData.class);
            ((RealmObject) obj).populateUsingJsonObject(json.getJSONObject("calculatedData"));
            setCalculatedData(obj);
        }
        if (json.has("uploadedData")) {
            org.citruscircuits.realm.UploadedTeamData obj = realm.createObject(org.citruscircuits.realm.UploadedTeamData.class);
            ((RealmObject) obj).populateUsingJsonObject(json.getJSONObject("uploadedData"));
            setUploadedData(obj);
        }
    }

    void populateUsingJsonStream(JsonReader reader)
        throws IOException {
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("number") && reader.peek() != JsonToken.NULL) {
                setNumber((int) reader.nextInt());
            } else if (name.equals("name")  && reader.peek() != JsonToken.NULL) {
                setName((String) reader.nextString());
            } else if (name.equals("seed")  && reader.peek() != JsonToken.NULL) {
                setSeed((int) reader.nextInt());
            } else if (name.equals("matchData")  && reader.peek() != JsonToken.NULL) {
                reader.beginArray();
                while (reader.hasNext()) {
                    org.citruscircuits.realm.TeamInMatchData obj = realm.createObject(org.citruscircuits.realm.TeamInMatchData.class);
                    ((RealmObject) obj).populateUsingJsonStream(reader);
                    getMatchData().add(obj);
                }
                reader.endArray();
            } else if (name.equals("calculatedData")  && reader.peek() != JsonToken.NULL) {
                org.citruscircuits.realm.CalculatedTeamData obj = realm.createObject(org.citruscircuits.realm.CalculatedTeamData.class);
                ((RealmObject) obj).populateUsingJsonStream(reader);
                setCalculatedData(obj);
            } else if (name.equals("uploadedData")  && reader.peek() != JsonToken.NULL) {
                org.citruscircuits.realm.UploadedTeamData obj = realm.createObject(org.citruscircuits.realm.UploadedTeamData.class);
                ((RealmObject) obj).populateUsingJsonStream(reader);
                setUploadedData(obj);
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Team = [");
        stringBuilder.append("{number:");
        stringBuilder.append(getNumber());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(getName());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{seed:");
        stringBuilder.append(getSeed());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{matchData:");
        stringBuilder.append("RealmList<TeamInMatchData>[").append(getMatchData().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{calculatedData:");
        stringBuilder.append(getCalculatedData() != null ? "CalculatedTeamData" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{uploadedData:");
        stringBuilder.append(getUploadedData() != null ? "UploadedTeamData" : "null");
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
        TeamRealmProxy aTeam = (TeamRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aTeam.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aTeam.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aTeam.row.getIndex()) return false;

        return true;
    }

}
