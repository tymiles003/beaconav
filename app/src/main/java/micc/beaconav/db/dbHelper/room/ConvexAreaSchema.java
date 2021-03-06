package micc.beaconav.db.dbHelper.room;

import micc.beaconav.db.dbJSONManager.tableScheme.TableSchema;
import micc.beaconav.db.dbJSONManager.tableScheme.columnSchema.ColumnSchema;
import micc.beaconav.db.dbJSONManager.tableScheme.columnSchema.basicTypes.FloatSchema;
import micc.beaconav.db.dbJSONManager.tableScheme.columnSchema.basicTypes.IntegerSchema;
import micc.beaconav.db.dbJSONManager.tableScheme.columnSchema.basicTypes.LongSchema;
import micc.beaconav.db.dbJSONManager.tableScheme.columnSchema.basicTypes.StringSchema;

/**
 * Created by nagash on 01/02/15.
 */
public class ConvexAreaSchema extends TableSchema<RoomRow>
{
    public static final String          tableName  = "ConvexArea";

    static final LongSchema    ID          = new LongSchema("ID");
    static final LongSchema    ID_room        = new LongSchema("ID_room");

    private static final ColumnSchema[] columns = new ColumnSchema[]{ ID, ID_room};

    @Override
    protected String generateTableName() {
        return tableName;
    }

    @Override
    protected ColumnSchema[] generateTableColumns() {
        return columns;
    }

    @Override
    protected RoomRow generateRow() {
        return new RoomRow();
    }

}
