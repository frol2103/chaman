package be.frol.chaman.tables
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.jdbc.MySQLProfile
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Array(Annex.schema, AnnexRemoved.schema, Data.schema, DataDeleted.schema, Field.schema, FieldDeleted.schema, Item.schema, ItemDeleted.schema, PlayEvolutions.schema, User.schema).reduceLeft(_ ++ _)
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Annex
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(36,true)
   *  @param itemUuid Database column item_uuid SqlType(VARCHAR), Length(36,true)
   *  @param filesha Database column fileSha SqlType(VARCHAR), Length(40,true)
   *  @param name Database column name SqlType(VARCHAR), Length(255,true)
   *  @param mimetype Database column mimeType SqlType(VARCHAR), Length(255,true)
   *  @param author Database column author SqlType(VARCHAR), Length(36,true)
   *  @param timestamp Database column timestamp SqlType(TIMESTAMP) */
  case class AnnexRow(id: Long, uuid: String, itemUuid: String, filesha: String, name: String, mimetype: String, author: String, timestamp: java.sql.Timestamp)
  /** GetResult implicit for fetching AnnexRow objects using plain SQL queries */
  implicit def GetResultAnnexRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[AnnexRow] = GR{
    prs => import prs._
    AnnexRow.tupled((<<[Long], <<[String], <<[String], <<[String], <<[String], <<[String], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table annex. Objects of this class serve as prototypes for rows in queries. */
  class Annex(_tableTag: Tag) extends profile.api.Table[AnnexRow](_tableTag, Some("chaman"), "annex") {
    def * = (id, uuid, itemUuid, filesha, name, mimetype, author, timestamp) <> (AnnexRow.tupled, AnnexRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(uuid), Rep.Some(itemUuid), Rep.Some(filesha), Rep.Some(name), Rep.Some(mimetype), Rep.Some(author), Rep.Some(timestamp))).shaped.<>({r=>import r._; _1.map(_=> AnnexRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(36,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(36,varying=true))
    /** Database column item_uuid SqlType(VARCHAR), Length(36,true) */
    val itemUuid: Rep[String] = column[String]("item_uuid", O.Length(36,varying=true))
    /** Database column fileSha SqlType(VARCHAR), Length(40,true) */
    val filesha: Rep[String] = column[String]("fileSha", O.Length(40,varying=true))
    /** Database column name SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("name", O.Length(255,varying=true))
    /** Database column mimeType SqlType(VARCHAR), Length(255,true) */
    val mimetype: Rep[String] = column[String]("mimeType", O.Length(255,varying=true))
    /** Database column author SqlType(VARCHAR), Length(36,true) */
    val author: Rep[String] = column[String]("author", O.Length(36,varying=true))
    /** Database column timestamp SqlType(TIMESTAMP) */
    val timestamp: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("timestamp")
  }
  /** Collection-like TableQuery object for table Annex */
  lazy val Annex = new TableQuery(tag => new Annex(tag))

  /** Entity class storing rows of table AnnexRemoved
   *  @param fkAnnexId Database column fk_annex_id SqlType(BIGINT), PrimaryKey
   *  @param author Database column author SqlType(VARCHAR), Length(36,true)
   *  @param timestamp Database column timestamp SqlType(TIMESTAMP) */
  case class AnnexRemovedRow(fkAnnexId: Long, author: String, timestamp: java.sql.Timestamp)
  /** GetResult implicit for fetching AnnexRemovedRow objects using plain SQL queries */
  implicit def GetResultAnnexRemovedRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[AnnexRemovedRow] = GR{
    prs => import prs._
    AnnexRemovedRow.tupled((<<[Long], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table annex_removed. Objects of this class serve as prototypes for rows in queries. */
  class AnnexRemoved(_tableTag: Tag) extends profile.api.Table[AnnexRemovedRow](_tableTag, Some("chaman"), "annex_removed") {
    def * = (fkAnnexId, author, timestamp) <> (AnnexRemovedRow.tupled, AnnexRemovedRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(fkAnnexId), Rep.Some(author), Rep.Some(timestamp))).shaped.<>({r=>import r._; _1.map(_=> AnnexRemovedRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column fk_annex_id SqlType(BIGINT), PrimaryKey */
    val fkAnnexId: Rep[Long] = column[Long]("fk_annex_id", O.PrimaryKey)
    /** Database column author SqlType(VARCHAR), Length(36,true) */
    val author: Rep[String] = column[String]("author", O.Length(36,varying=true))
    /** Database column timestamp SqlType(TIMESTAMP) */
    val timestamp: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("timestamp")
  }
  /** Collection-like TableQuery object for table AnnexRemoved */
  lazy val AnnexRemoved = new TableQuery(tag => new AnnexRemoved(tag))

  /** Entity class storing rows of table Data
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param fieldUuid Database column field_uuid SqlType(VARCHAR), Length(36,true)
   *  @param ownerUuid Database column owner_uuid SqlType(VARCHAR), Length(36,true)
   *  @param valueUuid Database column value_uuid SqlType(VARCHAR), Length(36,true)
   *  @param subreferenceUuid Database column subreference_uuid SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param value Database column value SqlType(TEXT), Default(None)
   *  @param author Database column author SqlType(VARCHAR), Length(36,true)
   *  @param timestamp Database column timestamp SqlType(TIMESTAMP) */
  case class DataRow(id: Long, fieldUuid: String, ownerUuid: String, valueUuid: String, subreferenceUuid: Option[String] = None, value: Option[String] = None, author: String, timestamp: java.sql.Timestamp)
  /** GetResult implicit for fetching DataRow objects using plain SQL queries */
  implicit def GetResultDataRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Option[String]], e3: GR[java.sql.Timestamp]): GR[DataRow] = GR{
    prs => import prs._
    DataRow.tupled((<<[Long], <<[String], <<[String], <<[String], <<?[String], <<?[String], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table data. Objects of this class serve as prototypes for rows in queries. */
  class Data(_tableTag: Tag) extends profile.api.Table[DataRow](_tableTag, Some("chaman"), "data") {
    def * = (id, fieldUuid, ownerUuid, valueUuid, subreferenceUuid, value, author, timestamp) <> (DataRow.tupled, DataRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(fieldUuid), Rep.Some(ownerUuid), Rep.Some(valueUuid), subreferenceUuid, value, Rep.Some(author), Rep.Some(timestamp))).shaped.<>({r=>import r._; _1.map(_=> DataRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6, _7.get, _8.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column field_uuid SqlType(VARCHAR), Length(36,true) */
    val fieldUuid: Rep[String] = column[String]("field_uuid", O.Length(36,varying=true))
    /** Database column owner_uuid SqlType(VARCHAR), Length(36,true) */
    val ownerUuid: Rep[String] = column[String]("owner_uuid", O.Length(36,varying=true))
    /** Database column value_uuid SqlType(VARCHAR), Length(36,true) */
    val valueUuid: Rep[String] = column[String]("value_uuid", O.Length(36,varying=true))
    /** Database column subreference_uuid SqlType(VARCHAR), Length(36,true), Default(None) */
    val subreferenceUuid: Rep[Option[String]] = column[Option[String]]("subreference_uuid", O.Length(36,varying=true), O.Default(None))
    /** Database column value SqlType(TEXT), Default(None) */
    val value: Rep[Option[String]] = column[Option[String]]("value", O.Default(None))
    /** Database column author SqlType(VARCHAR), Length(36,true) */
    val author: Rep[String] = column[String]("author", O.Length(36,varying=true))
    /** Database column timestamp SqlType(TIMESTAMP) */
    val timestamp: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("timestamp")

    /** Index over (ownerUuid) (database name owner_uuid) */
    val index1 = index("owner_uuid", ownerUuid)
  }
  /** Collection-like TableQuery object for table Data */
  lazy val Data = new TableQuery(tag => new Data(tag))

  /** Entity class storing rows of table DataDeleted
   *  @param fkDataId Database column fk_field_data_id SqlType(BIGINT), PrimaryKey
   *  @param author Database column author SqlType(VARCHAR), Length(36,true)
   *  @param timestamp Database column timestamp SqlType(TIMESTAMP) */
  case class DataDeletedRow(fkDataId: Long, author: String, timestamp: java.sql.Timestamp)
  /** GetResult implicit for fetching DataDeletedRow objects using plain SQL queries */
  implicit def GetResultDataDeletedRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[DataDeletedRow] = GR{
    prs => import prs._
    DataDeletedRow.tupled((<<[Long], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table data_deleted. Objects of this class serve as prototypes for rows in queries. */
  class DataDeleted(_tableTag: Tag) extends profile.api.Table[DataDeletedRow](_tableTag, Some("chaman"), "data_deleted") {
    def * = (fkDataId, author, timestamp) <> (DataDeletedRow.tupled, DataDeletedRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(fkDataId), Rep.Some(author), Rep.Some(timestamp))).shaped.<>({r=>import r._; _1.map(_=> DataDeletedRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column fk_field_data_id SqlType(BIGINT), PrimaryKey */
    val fkDataId: Rep[Long] = column[Long]("fk_field_data_id", O.PrimaryKey)
    /** Database column author SqlType(VARCHAR), Length(36,true) */
    val author: Rep[String] = column[String]("author", O.Length(36,varying=true))
    /** Database column timestamp SqlType(TIMESTAMP) */
    val timestamp: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("timestamp")
  }
  /** Collection-like TableQuery object for table DataDeleted */
  lazy val DataDeleted = new TableQuery(tag => new DataDeleted(tag))

  /** Entity class storing rows of table Field
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(36,true)
   *  @param reference Database column reference SqlType(VARCHAR), Length(255,true)
   *  @param datatype Database column datatype SqlType(VARCHAR), Length(255,true)
   *  @param label Database column label SqlType(VARCHAR), Length(255,true)
   *  @param author Database column author SqlType(VARCHAR), Length(36,true)
   *  @param timestamp Database column timestamp SqlType(TIMESTAMP)
   *  @param config Database column config SqlType(TEXT), Default(None) */
  case class FieldRow(id: Long, uuid: String, reference: String, datatype: String, label: String, author: String, timestamp: java.sql.Timestamp, config: Option[String] = None)
  /** GetResult implicit for fetching FieldRow objects using plain SQL queries */
  implicit def GetResultFieldRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Option[String]]): GR[FieldRow] = GR{
    prs => import prs._
    FieldRow.tupled((<<[Long], <<[String], <<[String], <<[String], <<[String], <<[String], <<[java.sql.Timestamp], <<?[String]))
  }
  /** Table description of table field. Objects of this class serve as prototypes for rows in queries. */
  class Field(_tableTag: Tag) extends profile.api.Table[FieldRow](_tableTag, Some("chaman"), "field") {
    def * = (id, uuid, reference, datatype, label, author, timestamp, config) <> (FieldRow.tupled, FieldRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(uuid), Rep.Some(reference), Rep.Some(datatype), Rep.Some(label), Rep.Some(author), Rep.Some(timestamp), config)).shaped.<>({r=>import r._; _1.map(_=> FieldRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(36,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(36,varying=true))
    /** Database column reference SqlType(VARCHAR), Length(255,true) */
    val reference: Rep[String] = column[String]("reference", O.Length(255,varying=true))
    /** Database column datatype SqlType(VARCHAR), Length(255,true) */
    val datatype: Rep[String] = column[String]("datatype", O.Length(255,varying=true))
    /** Database column label SqlType(VARCHAR), Length(255,true) */
    val label: Rep[String] = column[String]("label", O.Length(255,varying=true))
    /** Database column author SqlType(VARCHAR), Length(36,true) */
    val author: Rep[String] = column[String]("author", O.Length(36,varying=true))
    /** Database column timestamp SqlType(TIMESTAMP) */
    val timestamp: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("timestamp")
    /** Database column config SqlType(TEXT), Default(None) */
    val config: Rep[Option[String]] = column[Option[String]]("config", O.Default(None))

    /** Index over (uuid) (database name uuid) */
    val index1 = index("uuid", uuid)
  }
  /** Collection-like TableQuery object for table Field */
  lazy val Field = new TableQuery(tag => new Field(tag))

  /** Entity class storing rows of table FieldDeleted
   *  @param fkFieldId Database column fk_field_id SqlType(BIGINT), PrimaryKey
   *  @param author Database column author SqlType(VARCHAR), Length(36,true)
   *  @param timestamp Database column timestamp SqlType(TIMESTAMP) */
  case class FieldDeletedRow(fkFieldId: Long, author: String, timestamp: java.sql.Timestamp)
  /** GetResult implicit for fetching FieldDeletedRow objects using plain SQL queries */
  implicit def GetResultFieldDeletedRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[FieldDeletedRow] = GR{
    prs => import prs._
    FieldDeletedRow.tupled((<<[Long], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table field_deleted. Objects of this class serve as prototypes for rows in queries. */
  class FieldDeleted(_tableTag: Tag) extends profile.api.Table[FieldDeletedRow](_tableTag, Some("chaman"), "field_deleted") {
    def * = (fkFieldId, author, timestamp) <> (FieldDeletedRow.tupled, FieldDeletedRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(fkFieldId), Rep.Some(author), Rep.Some(timestamp))).shaped.<>({r=>import r._; _1.map(_=> FieldDeletedRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column fk_field_id SqlType(BIGINT), PrimaryKey */
    val fkFieldId: Rep[Long] = column[Long]("fk_field_id", O.PrimaryKey)
    /** Database column author SqlType(VARCHAR), Length(36,true) */
    val author: Rep[String] = column[String]("author", O.Length(36,varying=true))
    /** Database column timestamp SqlType(TIMESTAMP) */
    val timestamp: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("timestamp")
  }
  /** Collection-like TableQuery object for table FieldDeleted */
  lazy val FieldDeleted = new TableQuery(tag => new FieldDeleted(tag))

  /** Entity class storing rows of table Item
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(36,true)
   *  @param title Database column title SqlType(VARCHAR), Length(255,true)
   *  @param description Database column description SqlType(VARCHAR), Length(100,true)
   *  @param author Database column author SqlType(VARCHAR), Length(36,true)
   *  @param timestamp Database column timestamp SqlType(TIMESTAMP) */
  case class ItemRow(id: Long, uuid: String, title: String, description: String, author: String, timestamp: java.sql.Timestamp)
  /** GetResult implicit for fetching ItemRow objects using plain SQL queries */
  implicit def GetResultItemRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[ItemRow] = GR{
    prs => import prs._
    ItemRow.tupled((<<[Long], <<[String], <<[String], <<[String], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table item. Objects of this class serve as prototypes for rows in queries. */
  class Item(_tableTag: Tag) extends profile.api.Table[ItemRow](_tableTag, Some("chaman"), "item") {
    def * = (id, uuid, title, description, author, timestamp) <> (ItemRow.tupled, ItemRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(uuid), Rep.Some(title), Rep.Some(description), Rep.Some(author), Rep.Some(timestamp))).shaped.<>({r=>import r._; _1.map(_=> ItemRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(36,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(36,varying=true))
    /** Database column title SqlType(VARCHAR), Length(255,true) */
    val title: Rep[String] = column[String]("title", O.Length(255,varying=true))
    /** Database column description SqlType(VARCHAR), Length(100,true) */
    val description: Rep[String] = column[String]("description", O.Length(100,varying=true))
    /** Database column author SqlType(VARCHAR), Length(36,true) */
    val author: Rep[String] = column[String]("author", O.Length(36,varying=true))
    /** Database column timestamp SqlType(TIMESTAMP) */
    val timestamp: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("timestamp")

    /** Index over (uuid) (database name uuid) */
    val index1 = index("uuid", uuid)
  }
  /** Collection-like TableQuery object for table Item */
  lazy val Item = new TableQuery(tag => new Item(tag))

  /** Entity class storing rows of table ItemDeleted
   *  @param fkItemId Database column fk_item_id SqlType(BIGINT), PrimaryKey
   *  @param author Database column author SqlType(VARCHAR), Length(36,true)
   *  @param timestamp Database column timestamp SqlType(TIMESTAMP) */
  case class ItemDeletedRow(fkItemId: Long, author: String, timestamp: java.sql.Timestamp)
  /** GetResult implicit for fetching ItemDeletedRow objects using plain SQL queries */
  implicit def GetResultItemDeletedRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[ItemDeletedRow] = GR{
    prs => import prs._
    ItemDeletedRow.tupled((<<[Long], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table item_deleted. Objects of this class serve as prototypes for rows in queries. */
  class ItemDeleted(_tableTag: Tag) extends profile.api.Table[ItemDeletedRow](_tableTag, Some("chaman"), "item_deleted") {
    def * = (fkItemId, author, timestamp) <> (ItemDeletedRow.tupled, ItemDeletedRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(fkItemId), Rep.Some(author), Rep.Some(timestamp))).shaped.<>({r=>import r._; _1.map(_=> ItemDeletedRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column fk_item_id SqlType(BIGINT), PrimaryKey */
    val fkItemId: Rep[Long] = column[Long]("fk_item_id", O.PrimaryKey)
    /** Database column author SqlType(VARCHAR), Length(36,true) */
    val author: Rep[String] = column[String]("author", O.Length(36,varying=true))
    /** Database column timestamp SqlType(TIMESTAMP) */
    val timestamp: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("timestamp")
  }
  /** Collection-like TableQuery object for table ItemDeleted */
  lazy val ItemDeleted = new TableQuery(tag => new ItemDeleted(tag))

  /** Entity class storing rows of table PlayEvolutions
   *  @param id Database column id SqlType(INT), PrimaryKey
   *  @param hash Database column hash SqlType(VARCHAR), Length(255,true)
   *  @param appliedAt Database column applied_at SqlType(TIMESTAMP)
   *  @param applyScript Database column apply_script SqlType(MEDIUMTEXT), Length(16777215,true), Default(None)
   *  @param revertScript Database column revert_script SqlType(MEDIUMTEXT), Length(16777215,true), Default(None)
   *  @param state Database column state SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param lastProblem Database column last_problem SqlType(MEDIUMTEXT), Length(16777215,true), Default(None) */
  case class PlayEvolutionsRow(id: Int, hash: String, appliedAt: java.sql.Timestamp, applyScript: Option[String] = None, revertScript: Option[String] = None, state: Option[String] = None, lastProblem: Option[String] = None)
  /** GetResult implicit for fetching PlayEvolutionsRow objects using plain SQL queries */
  implicit def GetResultPlayEvolutionsRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Option[String]]): GR[PlayEvolutionsRow] = GR{
    prs => import prs._
    PlayEvolutionsRow.tupled((<<[Int], <<[String], <<[java.sql.Timestamp], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table play_evolutions. Objects of this class serve as prototypes for rows in queries. */
  class PlayEvolutions(_tableTag: Tag) extends profile.api.Table[PlayEvolutionsRow](_tableTag, Some("chaman"), "play_evolutions") {
    def * = (id, hash, appliedAt, applyScript, revertScript, state, lastProblem) <> (PlayEvolutionsRow.tupled, PlayEvolutionsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(hash), Rep.Some(appliedAt), applyScript, revertScript, state, lastProblem)).shaped.<>({r=>import r._; _1.map(_=> PlayEvolutionsRow.tupled((_1.get, _2.get, _3.get, _4, _5, _6, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.PrimaryKey)
    /** Database column hash SqlType(VARCHAR), Length(255,true) */
    val hash: Rep[String] = column[String]("hash", O.Length(255,varying=true))
    /** Database column applied_at SqlType(TIMESTAMP) */
    val appliedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("applied_at")
    /** Database column apply_script SqlType(MEDIUMTEXT), Length(16777215,true), Default(None) */
    val applyScript: Rep[Option[String]] = column[Option[String]]("apply_script", O.Length(16777215,varying=true), O.Default(None))
    /** Database column revert_script SqlType(MEDIUMTEXT), Length(16777215,true), Default(None) */
    val revertScript: Rep[Option[String]] = column[Option[String]]("revert_script", O.Length(16777215,varying=true), O.Default(None))
    /** Database column state SqlType(VARCHAR), Length(255,true), Default(None) */
    val state: Rep[Option[String]] = column[Option[String]]("state", O.Length(255,varying=true), O.Default(None))
    /** Database column last_problem SqlType(MEDIUMTEXT), Length(16777215,true), Default(None) */
    val lastProblem: Rep[Option[String]] = column[Option[String]]("last_problem", O.Length(16777215,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table PlayEvolutions */
  lazy val PlayEvolutions = new TableQuery(tag => new PlayEvolutions(tag))

  /** Entity class storing rows of table User
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(36,true)
   *  @param username Database column username SqlType(VARCHAR), Length(255,true)
   *  @param openidconnectiss Database column openidconnectiss SqlType(VARCHAR), Length(255,true)
   *  @param openidconnectsub Database column openidconnectsub SqlType(VARCHAR), Length(255,true)
   *  @param timestamp Database column timestamp SqlType(TIMESTAMP) */
  case class UserRow(id: Long, uuid: String, username: String, openidconnectiss: String, openidconnectsub: String, timestamp: java.sql.Timestamp)
  /** GetResult implicit for fetching UserRow objects using plain SQL queries */
  implicit def GetResultUserRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[UserRow] = GR{
    prs => import prs._
    UserRow.tupled((<<[Long], <<[String], <<[String], <<[String], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table user. Objects of this class serve as prototypes for rows in queries. */
  class User(_tableTag: Tag) extends profile.api.Table[UserRow](_tableTag, Some("chaman"), "user") {
    def * = (id, uuid, username, openidconnectiss, openidconnectsub, timestamp) <> (UserRow.tupled, UserRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(uuid), Rep.Some(username), Rep.Some(openidconnectiss), Rep.Some(openidconnectsub), Rep.Some(timestamp))).shaped.<>({r=>import r._; _1.map(_=> UserRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(36,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(36,varying=true))
    /** Database column username SqlType(VARCHAR), Length(255,true) */
    val username: Rep[String] = column[String]("username", O.Length(255,varying=true))
    /** Database column openidconnectiss SqlType(VARCHAR), Length(255,true) */
    val openidconnectiss: Rep[String] = column[String]("openidconnectiss", O.Length(255,varying=true))
    /** Database column openidconnectsub SqlType(VARCHAR), Length(255,true) */
    val openidconnectsub: Rep[String] = column[String]("openidconnectsub", O.Length(255,varying=true))
    /** Database column timestamp SqlType(TIMESTAMP) */
    val timestamp: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("timestamp")

    /** Index over (uuid,openidconnectiss,openidconnectsub) (database name uuid) */
    val index1 = index("uuid", (uuid, openidconnectiss, openidconnectsub))
  }
  /** Collection-like TableQuery object for table User */
  lazy val User = new TableQuery(tag => new User(tag))
}
