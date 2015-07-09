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

public class CompetitionRealmProxy extends Competition {

    @Override
    public String getName() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(Realm.columnIndices.get("Competition").get("name"));
    }

    @Override
    public void setName(String value) {
        realm.checkIfValid();
        row.setString(Realm.columnIndices.get("Competition").get("name"), (String) value);
    }

    @Override
    public String getCompetitionCode() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(Realm.columnIndices.get("Competition").get("competitionCode"));
    }

    @Override
    public void setCompetitionCode(String value) {
        realm.checkIfValid();
        row.setString(Realm.columnIndices.get("Competition").get("competitionCode"), (String) value);
    }

    @Override
    public RealmList<org.citruscircuits.realm.Match> getMatches() {
        return new RealmList<Match>(Match.class, row.getLinkList(Realm.columnIndices.get("Competition").get("matches")), realm);
    }

    @Override
    public void setMatches(RealmList<org.citruscircuits.realm.Match> value) {
        LinkView links = row.getLinkList(Realm.columnIndices.get("Competition").get("matches"));
        if (value == null) {
            return;
        }
        for (RealmObject linkedObject : (RealmList<? extends RealmObject>) value) {
            links.add(linkedObject.row.getIndex());
        }
    }

    @Override
    public RealmList<org.citruscircuits.realm.Team> getAttendingTeams() {
        return new RealmList<Team>(Team.class, row.getLinkList(Realm.columnIndices.get("Competition").get("attendingTeams")), realm);
    }

    @Override
    public void setAttendingTeams(RealmList<org.citruscircuits.realm.Team> value) {
        LinkView links = row.getLinkList(Realm.columnIndices.get("Competition").get("attendingTeams"));
        if (value == null) {
            return;
        }
        for (RealmObject linkedObject : (RealmList<? extends RealmObject>) value) {
            links.add(linkedObject.row.getIndex());
        }
    }

    @Override
    public org.citruscircuits.realm.CalculatedCompetitionData getCalculatedData() {
        if (row.isNullLink(Realm.columnIndices.get("Competition").get("calculatedData"))) {
            return null;
        }
        return realm.get(org.citruscircuits.realm.CalculatedCompetitionData.class, row.getLink(Realm.columnIndices.get("Competition").get("calculatedData")));
    }

    @Override
    public void setCalculatedData(org.citruscircuits.realm.CalculatedCompetitionData value) {
        if (value == null) {
            row.nullifyLink(Realm.columnIndices.get("Competition").get("calculatedData"));
        }
        row.setLink(Realm.columnIndices.get("Competition").get("calculatedData"), value.row.getIndex());
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if(!transaction.hasTable("class_Competition")) {
            Table table = transaction.getTable("class_Competition");
            table.addColumn(ColumnType.STRING, "name");
            table.addColumn(ColumnType.STRING, "competitionCode");
            if (!transaction.hasTable("class_Match")) {
                MatchRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK_LIST, "matches", transaction.getTable("class_Match"));
            if (!transaction.hasTable("class_Team")) {
                TeamRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK_LIST, "attendingTeams", transaction.getTable("class_Team"));
            if (!transaction.hasTable("class_CalculatedCompetitionData")) {
                CalculatedCompetitionDataRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK, "calculatedData", transaction.getTable("class_CalculatedCompetitionData"));
            return table;
        }
        return transaction.getTable("class_Competition");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if(transaction.hasTable("class_Competition")) {
            Table table = transaction.getTable("class_Competition");
            if(table.getColumnCount() != 5) {
                throw new IllegalStateException("Column count does not match");
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for(long i = 0; i < 5; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }
            if (!columnTypes.containsKey("name")) {
                throw new IllegalStateException("Missing column 'name'");
            }
            if (columnTypes.get("name") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'name'");
            }
            if (!columnTypes.containsKey("competitionCode")) {
                throw new IllegalStateException("Missing column 'competitionCode'");
            }
            if (columnTypes.get("competitionCode") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'competitionCode'");
            }
            if(!columnTypes.containsKey("matches")) {
                throw new IllegalStateException("Missing column 'matches'");
            }
            if(columnTypes.get("matches") != ColumnType.LINK_LIST) {
                throw new IllegalStateException("Invalid type 'Match' for column 'matches'");
            }
            if (!transaction.hasTable("class_Match")) {
                throw new IllegalStateException("Missing table 'class_Match' for column 'matches'");
            }
            if(!columnTypes.containsKey("attendingTeams")) {
                throw new IllegalStateException("Missing column 'attendingTeams'");
            }
            if(columnTypes.get("attendingTeams") != ColumnType.LINK_LIST) {
                throw new IllegalStateException("Invalid type 'Team' for column 'attendingTeams'");
            }
            if (!transaction.hasTable("class_Team")) {
                throw new IllegalStateException("Missing table 'class_Team' for column 'attendingTeams'");
            }
            if (!columnTypes.containsKey("calculatedData")) {
                throw new IllegalStateException("Missing column 'calculatedData'");
            }
            if (columnTypes.get("calculatedData") != ColumnType.LINK) {
                throw new IllegalStateException("Invalid type 'CalculatedCompetitionData' for column 'calculatedData'");
            }
            if (!transaction.hasTable("class_CalculatedCompetitionData")) {
                throw new IllegalStateException("Missing table 'class_CalculatedCompetitionData' for column 'calculatedData'");
            }
        }
    }

    public static List<String> getFieldNames() {
        return Arrays.asList("name", "competitionCode", "matches", "attendingTeams", "calculatedData");
    }

    void populateUsingJsonObject(JSONObject json)
        throws JSONException {
        if (json.has("name")) {
            setName((String) json.getString("name"));
        }
        if (json.has("competitionCode")) {
            setCompetitionCode((String) json.getString("competitionCode"));
        }
        if (json.has("matches")) {
            JSONArray array = json.getJSONArray("matches");
            for (int i = 0; i < array.length(); i++) {
                org.citruscircuits.realm.Match obj = realm.createObject(org.citruscircuits.realm.Match.class);
                ((RealmObject) obj).populateUsingJsonObject(array.getJSONObject(i));
                getMatches().add(obj);
            }
        }
        if (json.has("attendingTeams")) {
            JSONArray array = json.getJSONArray("attendingTeams");
            for (int i = 0; i < array.length(); i++) {
                org.citruscircuits.realm.Team obj = realm.createObject(org.citruscircuits.realm.Team.class);
                ((RealmObject) obj).populateUsingJsonObject(array.getJSONObject(i));
                getAttendingTeams().add(obj);
            }
        }
        if (json.has("calculatedData")) {
            org.citruscircuits.realm.CalculatedCompetitionData obj = realm.createObject(org.citruscircuits.realm.CalculatedCompetitionData.class);
            ((RealmObject) obj).populateUsingJsonObject(json.getJSONObject("calculatedData"));
            setCalculatedData(obj);
        }
    }

    void populateUsingJsonStream(JsonReader reader)
        throws IOException {
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("name") && reader.peek() != JsonToken.NULL) {
                setName((String) reader.nextString());
            } else if (name.equals("competitionCode")  && reader.peek() != JsonToken.NULL) {
                setCompetitionCode((String) reader.nextString());
            } else if (name.equals("matches")  && reader.peek() != JsonToken.NULL) {
                reader.beginArray();
                while (reader.hasNext()) {
                    org.citruscircuits.realm.Match obj = realm.createObject(org.citruscircuits.realm.Match.class);
                    ((RealmObject) obj).populateUsingJsonStream(reader);
                    getMatches().add(obj);
                }
                reader.endArray();
            } else if (name.equals("attendingTeams")  && reader.peek() != JsonToken.NULL) {
                reader.beginArray();
                while (reader.hasNext()) {
                    org.citruscircuits.realm.Team obj = realm.createObject(org.citruscircuits.realm.Team.class);
                    ((RealmObject) obj).populateUsingJsonStream(reader);
                    getAttendingTeams().add(obj);
                }
                reader.endArray();
            } else if (name.equals("calculatedData")  && reader.peek() != JsonToken.NULL) {
                org.citruscircuits.realm.CalculatedCompetitionData obj = realm.createObject(org.citruscircuits.realm.CalculatedCompetitionData.class);
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
        StringBuilder stringBuilder = new StringBuilder("Competition = [");
        stringBuilder.append("{name:");
        stringBuilder.append(getName());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{competitionCode:");
        stringBuilder.append(getCompetitionCode());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{matches:");
        stringBuilder.append("RealmList<Match>[").append(getMatches().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{attendingTeams:");
        stringBuilder.append("RealmList<Team>[").append(getAttendingTeams().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{calculatedData:");
        stringBuilder.append(getCalculatedData() != null ? "CalculatedCompetitionData" : "null");
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
        CompetitionRealmProxy aCompetition = (CompetitionRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aCompetition.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aCompetition.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aCompetition.row.getIndex()) return false;

        return true;
    }

}
