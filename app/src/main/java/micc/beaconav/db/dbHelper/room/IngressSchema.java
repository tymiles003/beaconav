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
public class IngressSchema extends TableSchema<RoomRow>
{
    public static final String          tableName  = "Room";

    public static final LongSchema     ID          = new LongSchema("ID");
    public static final LongSchema     ID_area_a   = new LongSchema("ID_area_a");
    public static final LongSchema     ID_area_b   = new LongSchema("ID_area_b");
    public static final FloatSchema    x           = new FloatSchema("x");
    public static final FloatSchema    y           = new FloatSchema("y");
    public static final LongSchema    dock_a_x    = new LongSchema("dock_a_x");
    public static final LongSchema    dock_a_y    = new LongSchema("dock_a_y");
    public static final LongSchema    dock_b_x    = new LongSchema("dock_b_x");
    public static final LongSchema    dock_b_y    = new LongSchema("dock_b_y");


    private static final ColumnSchema[] columns =
            new ColumnSchema[]{ ID, ID_area_a, ID_area_b, x, y, dock_a_x, dock_a_y, dock_b_x, dock_b_y};


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
