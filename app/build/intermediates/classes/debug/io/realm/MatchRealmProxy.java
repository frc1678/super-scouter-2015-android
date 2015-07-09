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

public class MatchRealmProxy extends Match {

    @Override
    public String getMatch() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(Realm.columnIndices.get("Match").get("match"));
    }

    @Override
    public void setMatch(String value) {
        realm.checkIfValid();
        row.setString(Realm.columnIndices.get("Match").get("match"), (String) value);
    }

    @Override
    public RealmList<org.citruscircuits.realm.Team> getRedTeams() {
        return new RealmList<Team>(Team.class, row.getLinkList(Realm.columnIndices.get("Match").get("redTeams")), realm);
    }

    @Override
    public void setRedTeams(RealmList<org.citruscircuits.realm.Team> value) {
        LinkView links = row.getLinkList(Realm.columnIndices.get("Match").get("redTeams"));
        if (value == null) {
            return;
        }
        for (RealmObject linkedObject : (RealmList<? extends RealmObject>) value) {
            links.add(linkedObject.row.getIndex());
        }
    }

    @Override
    public RealmList<org.citruscircuits.realm.Team> getBlueTeams() {
        return new RealmList<Team>(Team.class, row.getLinkList(Realm.columnIndices.get("Match").get("blueTeams")), realm);
    }

    @Override
    public void setBlueTeams(RealmList<org.citruscircuits.realm.Team> value) {
        LinkView links = row.getLinkList(Realm.columnIndices.get("Match").get("blueTeams"));
        if (value == null) {
            return;
        }
        for (RealmObject linkedObject : (RealmList<? extends RealmObject>) value) {
            links.add(linkedObject.row.getIndex());
        }
    }

    @Override
    public RealmList<org.citruscircuits.realm.TeamInMatchData> getTeamInMatchDatas() {
        return new RealmList<TeamInMatchData>(TeamInMatchData.class, row.getLinkList(Realm.columnIndices.get("Match").get("teamInMatchDatas")), realm);
    }

    @Override
    public void setTeamInMatchDatas(RealmList<org.citruscircuits.realm.TeamInMatchData> value) {
        LinkView links = row.getLinkList(Realm.columnIndices.get("Match").get("teamInMatchDatas"));
        if (value == null) {
            return;
        }
        for (RealmObject linkedObject : (RealmList<? extends RealmObject>) value) {
            links.add(linkedObject.row.getIndex());
        }
    }

    @Override
    public int getOfficialRedScore() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("Match").get("officialRedScore"));
    }

    @Override
    public void setOfficialRedScore(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("Match").get("officialRedScore"), (long) value);
    }

    @Override
    public int getOfficialBlueScore() {
        realm.checkIfValid();
        return (int) row.getLong(Realm.columnIndices.get("Match").get("officialBlueScore"));
    }

    @Override
    public void setOfficialBlueScore(int value) {
        realm.checkIfValid();
        row.setLong(Realm.columnIndices.get("Match").get("officialBlueScore"), (long) value);
    }

    @Override
    public org.citruscircuits.realm.CalculatedMatchData getCalculatedData() {
        if (row.isNullLink(Realm.columnIndices.get("Match").get("calculatedData"))) {
            return null;
        }
        return realm.get(org.citruscircuits.realm.CalculatedMatchData.class, row.getLink(Realm.columnIndices.get("Match").get("calculatedData")));
    }

    @Override
    public void setCalculatedData(org.citruscircuits.realm.CalculatedMatchData value) {
        if (value == null) {
            row.nullifyLink(Realm.columnIndices.get("Match").get("calculatedData"));
        }
        row.setLink(Realm.columnIndices.get("Match").get("calculatedData"), value.row.getIndex());
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if(!transaction.hasTable("class_Match")) {
            Table table = transaction.getTable("class_Match");
            table.addColumn(ColumnType.STRING, "match");
            if (!transaction.hasTable("class_Team")) {
                TeamRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK_LIST, "redTeams", transaction.getTable("class_Team"));
            if (!transaction.hasTable("class_Team")) {
                TeamRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK_LIST, "blueTeams", transaction.getTable("class_Team"));
            if (!transaction.hasTable("class_TeamInMatchData")) {
                TeamInMatchDataRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK_LIST, "teamInMatchDatas", transaction.getTable("class_TeamInMatchData"));
            table.addColumn(ColumnType.INTEGER, "officialRedScore");
            table.addColumn(ColumnType.INTEGER, "officialBlueScore");
            if (!transaction.hasTable("class_CalculatedMatchData")) {
                CalculatedMatchDataRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK, "calculatedData", transaction.getTable("class_CalculatedMatchData"));
            return table;
        }
        return transaction.getTable("class_Match");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if(transaction.hasTable("class_Match")) {
            Table table = transaction.getTable("class_Match");
            if(table.getColumnCount() != 7) {
                throw new IllegalStateException("Column count does not match");
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for(long i = 0; i < 7; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }
            if (!columnTypes.containsKey("match")) {
                throw new IllegalStateException("Missing column 'match'");
            }
            if (columnTypes.get("match") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'match'");
            }
            if(!columnTypes.containsKey("redTeams")) {
                throw new IllegalStateException("Missing column 'redTeams'");
            }
            if(columnTypes.get("redTeams") != ColumnType.LINK_LIST) {
                throw new IllegalStateException("Invalid type 'Team' for column 'redTeams'");
            }
            if (!transaction.hasTable("class_Team")) {
                throw new IllegalStateException("Missing table 'class_Team' for column 'redTeams'");
            }
            if(!columnTypes.containsKey("blueTeams")) {
                throw new IllegalStateException("Missing column 'blueTeams'");
            }
            if(columnTypes.get("blueTeams") != ColumnType.LINK_LIST) {
                throw new IllegalStateException("Invalid type 'Team' for column 'blueTeams'");
            }
            if (!transaction.hasTable("class_Team")) {
                throw new IllegalStateException("Missing table 'class_Team' for column 'blueTeams'");
            }
            if(!columnTypes.containsKey("teamInMatchDatas")) {
                throw new IllegalStateException("Missing column 'teamInMatchDatas'");
            }
            if(columnTypes.get("teamInMatchDatas") != ColumnType.LINK_LIST) {
                throw new IllegalStateException("Invalid type 'TeamInMatchData' for column 'teamInMatchDatas'");
            }
            if (!transaction.hasTable("class_TeamInMatchData")) {
                throw new IllegalStateException("Missing table 'class_TeamInMatchData' for column 'teamInMatchDatas'");
            }
            if (!columnTypes.containsKey("officialRedScore")) {
                throw new IllegalStateException("Missing column 'officialRedScore'");
            }
            if (columnTypes.get("officialRedScore") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'officialRedScore'");
            }
            if (!columnTypes.containsKey("officialBlueScore")) {
                throw new IllegalStateException("Missing column 'officialBlueScore'");
            }
            if (columnTypes.get("officialBlueScore") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'officialBlueScore'");
            }
            if (!columnTypes.containsKey("calculatedData")) {
                throw new IllegalStateException("Missing column 'calculatedData'");
            }
            if (columnTypes.get("calculatedData") != ColumnType.LINK) {
                throw new IllegalStateException("Invalid type 'CalculatedMatchData' for column 'calculatedData'");
            }
            if (!transaction.hasTable("class_CalculatedMatchData")) {
                throw new IllegalStateException("Missing table 'class_CalculatedMatchData' for column 'calculatedData'");
            }
        }
    }

    public static List<String> getFieldNames() {
        return Arrays.asList("match", "redTeams", "blueTeams", "teamInMatchDatas", "officialRedScore", "officialBlueScore", "calculatedData");
    }

    void populateUsingJsonObject(JSONObject json)
        throws JSONException {
        if (json.has("match")) {
            setMatch((String) json.getString("match"));
        }
        if (json.has("redTeams")) {
            JSONArray array = json.getJSONArray("redTeams");
            for (int i = 0; i < array.length(); i++) {
                org.citruscircuits.realm.Team obj = realm.createObject(org.citruscircuits.realm.Team.class);
                ((RealmObject) obj).populateUsingJsonObject(array.getJSONObject(i));
                getRedTeams().add(obj);
            }
        }
        if (json.has("blueTeams")) {
            JSONArray array = json.getJSONArray("blueTeams");
            for (int i = 0; i < array.length(); i++) {
                org.citruscircuits.realm.Team obj = realm.createObject(org.citruscircuits.realm.Team.class);
                ((RealmObject) obj).populateUsingJsonObject(array.getJSONObject(i));
                getBlueTeams().add(obj);
            }
        }
        if (json.has("teamInMatchDatas")) {
            JSONArray array = json.getJSONArray("teamInMatchDatas");
            for (int i = 0; i < array.length(); i++) {
                org.citruscircuits.realm.TeamInMatchData obj = realm.createObject(org.citruscircuits.realm.TeamInMatchData.class);
                ((RealmObject) obj).populateUsingJsonObject(array.getJSONObject(i));
                getTeamInMatchDatas().add(obj);
            }
        }
        if (json.has("officialRedScore")) {
            setOfficialRedScore((int) json.getInt("officialRedScore"));
        }
        if (json.has("officialBlueScore")) {
            setOfficialBlueScore((int) json.getInt("officialBlueScore"));
        }
        if (json.has("calculatedData")) {
            org.citruscircuits.realm.CalculatedMatchData obj = realm.createObject(org.citruscircuits.realm.CalculatedMatchData.class);
            ((RealmObject) obj).populateUsingJsonObject(json.getJSONObject("calculatedData"));
            setCalculatedData(obj);
        }
    }

    void populateUsingJsonStream(JsonReader reader)
        throws IOException {
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("match") && reader.peek() != JsonToken.NULL) {
                setMatch((String) reader.nextString());
            } else if (name.equals("redTeams")  && reader.peek() != JsonToken.NULL) {
                reader.beginArray();
                while (reader.hasNext()) {
                    org.citruscircuits.realm.Team obj = realm.createObject(org.citruscircuits.realm.Team.class);
                    ((RealmObject) obj).populateUsingJsonStream(reader);
                    getRedTeams().add(obj);
                }
                reader.endArray();
            } else if (name.equals("blueTeams")  && reader.peek() != JsonToken.NULL) {
                reader.beginArray();
                while (reader.hasNext()) {
                    org.citruscircuits.realm.Team obj = realm.createObject(org.citruscircuits.realm.Team.class);
                    ((RealmObject) obj).populateUsingJsonStream(reader);
                    getBlueTeams().add(obj);
                }
                reader.endArray();
            } else if (name.equals("teamInMatchDatas")  && reader.peek() != JsonToken.NULL) {
                reader.beginArray();
                while (reader.hasNext()) {
                    org.citruscircuits.realm.TeamInMatchData obj = realm.createObject(org.citruscircuits.realm.TeamInMatchData.class);
                    ((RealmObject) obj).populateUsingJsonStream(reader);
                    getTeamInMatchDatas().add(obj);
                }
                reader.endArray();
            } else if (name.equals("officialRedScore")  && reader.peek() != JsonToken.NULL) {
                setOfficialRedScore((int) reader.nextInt());
            } else if (name.equals("officialBlueScore")  && reader.peek() != JsonToken.NULL) {
                setOfficialBlueScore((int) reader.nextInt());
            } else if (name.equals("calculatedData")  && reader.peek() != JsonToken.NULL) {
                org.citruscircuits.realm.CalculatedMatchData obj = realm.createObject(org.citruscircuits.realm.CalculatedMatchData.class);
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
        StringBuilder stringBuilder = new StringBuilder("Match = [");
        stringBuilder.append("{match:");
        stringBuilder.append(getMatch());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{redTeams:");
        stringBuilder.append("RealmList<Team>[").append(getRedTeams().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{blueTeams:");
        stringBuilder.append("RealmList<Team>[").append(getBlueTeams().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{teamInMatchDatas:");
        stringBuilder.append("RealmList<TeamInMatchData>[").append(getTeamInMatchDatas().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{officialRedScore:");
        stringBuilder.append(getOfficialRedScore());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{officialBlueScore:");
        stringBuilder.append(getOfficialBlueScore());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{calculatedData:");
        stringBuilder.append(getCalculatedData() != null ? "CalculatedMatchData" : "null");
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
        MatchRealmProxy aMatch = (MatchRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aMatch.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aMatch.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aMatch.row.getIndex()) return false;

        return true;
    }

}
