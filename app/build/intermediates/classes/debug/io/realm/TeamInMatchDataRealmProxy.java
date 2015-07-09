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

public class TeamInMatchDataRealmProxy extends TeamInMatchData {

    @Override
    public org.citruscircuits.realm.Team getTeam() {
        if (row.isNullLink(Realm.columnIndices.get("TeamInMatchData").get("team"))) {
            return null;
        }
        return realm.get(org.citruscircuits.realm.Team.class, row.getLink(Realm.columnIndices.get("TeamInMatchData").get("team")));
    }

    @Override
    public void setTeam(org.citruscircuits.realm.Team value) {
        if (value == null) {
            row.nullifyLink(Realm.columnIndices.get("TeamInMatchData").get("team"));
        }
        row.setLink(Realm.columnIndices.get("TeamInMatchData").get("team"), value.row.getIndex());
    }

    @Override
    public org.citruscircuits.realm.Match getMatch() {
        if (row.isNullLink(Realm.columnIndices.get("TeamInMatchData").get("match"))) {
            return null;
        }
        return realm.get(org.citruscircuits.realm.Match.class, row.getLink(Realm.columnIndices.get("TeamInMatchData").get("match")));
    }

    @Override
    public void setMatch(org.citruscircuits.realm.Match value) {
        if (value == null) {
            row.nullifyLink(Realm.columnIndices.get("TeamInMatchData").get("match"));
        }
        row.setLink(Realm.columnIndices.get("TeamInMatchData").get("match"), value.row.getIndex());
    }

    @Override
    public org.citruscircuits.realm.UploadedTeamInMatchData getUploadedData() {
        if (row.isNullLink(Realm.columnIndices.get("TeamInMatchData").get("uploadedData"))) {
            return null;
        }
        return realm.get(org.citruscircuits.realm.UploadedTeamInMatchData.class, row.getLink(Realm.columnIndices.get("TeamInMatchData").get("uploadedData")));
    }

    @Override
    public void setUploadedData(org.citruscircuits.realm.UploadedTeamInMatchData value) {
        if (value == null) {
            row.nullifyLink(Realm.columnIndices.get("TeamInMatchData").get("uploadedData"));
        }
        row.setLink(Realm.columnIndices.get("TeamInMatchData").get("uploadedData"), value.row.getIndex());
    }

    @Override
    public org.citruscircuits.realm.CalculatedTeamInMatchData getCalculatedData() {
        if (row.isNullLink(Realm.columnIndices.get("TeamInMatchData").get("calculatedData"))) {
            return null;
        }
        return realm.get(org.citruscircuits.realm.CalculatedTeamInMatchData.class, row.getLink(Realm.columnIndices.get("TeamInMatchData").get("calculatedData")));
    }

    @Override
    public void setCalculatedData(org.citruscircuits.realm.CalculatedTeamInMatchData value) {
        if (value == null) {
            row.nullifyLink(Realm.columnIndices.get("TeamInMatchData").get("calculatedData"));
        }
        row.setLink(Realm.columnIndices.get("TeamInMatchData").get("calculatedData"), value.row.getIndex());
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if(!transaction.hasTable("class_TeamInMatchData")) {
            Table table = transaction.getTable("class_TeamInMatchData");
            if (!transaction.hasTable("class_Team")) {
                TeamRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK, "team", transaction.getTable("class_Team"));
            if (!transaction.hasTable("class_Match")) {
                MatchRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK, "match", transaction.getTable("class_Match"));
            if (!transaction.hasTable("class_UploadedTeamInMatchData")) {
                UploadedTeamInMatchDataRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK, "uploadedData", transaction.getTable("class_UploadedTeamInMatchData"));
            if (!transaction.hasTable("class_CalculatedTeamInMatchData")) {
                CalculatedTeamInMatchDataRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK, "calculatedData", transaction.getTable("class_CalculatedTeamInMatchData"));
            return table;
        }
        return transaction.getTable("class_TeamInMatchData");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if(transaction.hasTable("class_TeamInMatchData")) {
            Table table = transaction.getTable("class_TeamInMatchData");
            if(table.getColumnCount() != 4) {
                throw new IllegalStateException("Column count does not match");
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for(long i = 0; i < 4; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }
            if (!columnTypes.containsKey("team")) {
                throw new IllegalStateException("Missing column 'team'");
            }
            if (columnTypes.get("team") != ColumnType.LINK) {
                throw new IllegalStateException("Invalid type 'Team' for column 'team'");
            }
            if (!transaction.hasTable("class_Team")) {
                throw new IllegalStateException("Missing table 'class_Team' for column 'team'");
            }
            if (!columnTypes.containsKey("match")) {
                throw new IllegalStateException("Missing column 'match'");
            }
            if (columnTypes.get("match") != ColumnType.LINK) {
                throw new IllegalStateException("Invalid type 'Match' for column 'match'");
            }
            if (!transaction.hasTable("class_Match")) {
                throw new IllegalStateException("Missing table 'class_Match' for column 'match'");
            }
            if (!columnTypes.containsKey("uploadedData")) {
                throw new IllegalStateException("Missing column 'uploadedData'");
            }
            if (columnTypes.get("uploadedData") != ColumnType.LINK) {
                throw new IllegalStateException("Invalid type 'UploadedTeamInMatchData' for column 'uploadedData'");
            }
            if (!transaction.hasTable("class_UploadedTeamInMatchData")) {
                throw new IllegalStateException("Missing table 'class_UploadedTeamInMatchData' for column 'uploadedData'");
            }
            if (!columnTypes.containsKey("calculatedData")) {
                throw new IllegalStateException("Missing column 'calculatedData'");
            }
            if (columnTypes.get("calculatedData") != ColumnType.LINK) {
                throw new IllegalStateException("Invalid type 'CalculatedTeamInMatchData' for column 'calculatedData'");
            }
            if (!transaction.hasTable("class_CalculatedTeamInMatchData")) {
                throw new IllegalStateException("Missing table 'class_CalculatedTeamInMatchData' for column 'calculatedData'");
            }
        }
    }

    public static List<String> getFieldNames() {
        return Arrays.asList("team", "match", "uploadedData", "calculatedData");
    }

    void populateUsingJsonObject(JSONObject json)
        throws JSONException {
        if (json.has("team")) {
            org.citruscircuits.realm.Team obj = realm.createObject(org.citruscircuits.realm.Team.class);
            ((RealmObject) obj).populateUsingJsonObject(json.getJSONObject("team"));
            setTeam(obj);
        }
        if (json.has("match")) {
            org.citruscircuits.realm.Match obj = realm.createObject(org.citruscircuits.realm.Match.class);
            ((RealmObject) obj).populateUsingJsonObject(json.getJSONObject("match"));
            setMatch(obj);
        }
        if (json.has("uploadedData")) {
            org.citruscircuits.realm.UploadedTeamInMatchData obj = realm.createObject(org.citruscircuits.realm.UploadedTeamInMatchData.class);
            ((RealmObject) obj).populateUsingJsonObject(json.getJSONObject("uploadedData"));
            setUploadedData(obj);
        }
        if (json.has("calculatedData")) {
            org.citruscircuits.realm.CalculatedTeamInMatchData obj = realm.createObject(org.citruscircuits.realm.CalculatedTeamInMatchData.class);
            ((RealmObject) obj).populateUsingJsonObject(json.getJSONObject("calculatedData"));
            setCalculatedData(obj);
        }
    }

    void populateUsingJsonStream(JsonReader reader)
        throws IOException {
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("team") && reader.peek() != JsonToken.NULL) {
                org.citruscircuits.realm.Team obj = realm.createObject(org.citruscircuits.realm.Team.class);
                ((RealmObject) obj).populateUsingJsonStream(reader);
                setTeam(obj);
            } else if (name.equals("match")  && reader.peek() != JsonToken.NULL) {
                org.citruscircuits.realm.Match obj = realm.createObject(org.citruscircuits.realm.Match.class);
                ((RealmObject) obj).populateUsingJsonStream(reader);
                setMatch(obj);
            } else if (name.equals("uploadedData")  && reader.peek() != JsonToken.NULL) {
                org.citruscircuits.realm.UploadedTeamInMatchData obj = realm.createObject(org.citruscircuits.realm.UploadedTeamInMatchData.class);
                ((RealmObject) obj).populateUsingJsonStream(reader);
                setUploadedData(obj);
            } else if (name.equals("calculatedData")  && reader.peek() != JsonToken.NULL) {
                org.citruscircuits.realm.CalculatedTeamInMatchData obj = realm.createObject(org.citruscircuits.realm.CalculatedTeamInMatchData.class);
                ((RealmObject) obj).populateUsingJsonStream(reader);
                setCalculatedData(obj);
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("TeamInMatchData = [");
        stringBuilder.append("{team:");
        stringBuilder.append(getTeam() != null ? "Team" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{match:");
        stringBuilder.append(getMatch() != null ? "Match" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{uploadedData:");
        stringBuilder.append(getUploadedData() != null ? "UploadedTeamInMatchData" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{calculatedData:");
        stringBuilder.append(getCalculatedData() != null ? "CalculatedTeamInMatchData" : "null");
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
        TeamInMatchDataRealmProxy aTeamInMatchData = (TeamInMatchDataRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aTeamInMatchData.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aTeamInMatchData.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aTeamInMatchData.row.getIndex()) return false;

        return true;
    }

}
