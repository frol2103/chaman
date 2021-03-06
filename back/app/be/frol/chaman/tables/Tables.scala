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
  lazy val schema: profile.SchemaDescription = Array(Field.schema, FieldData.schema, FieldDataDeleted.schema, FieldDeleted.schema, PlayEvolutions.schema, Template.schema, TemplateDeleted.schema, TemplateParent.schema, TemplateParentDeleted.schema, User.schema).reduceLeft(_ ++ _)
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Field
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(36,true)
   *  @param reference Database column reference SqlType(VARCHAR), Length(255,true)
   *  @param datatype Database column datatype SqlType(VARCHAR), Length(255,true)
   *  @param label Database column label SqlType(VARCHAR), Length(255,true)
   *  @param defaultValue Database column default_value SqlType(TEXT), Default(None)
   *  @param timestamp Database column timestamp SqlType(TIMESTAMP) */
  case class FieldRow(id: Long, uuid: String, reference: String, datatype: String, label: String, defaultValue: Option[String] = None, timestamp: java.sql.Timestamp)
  /** GetResult implicit for fetching FieldRow objects using plain SQL queries */
  implicit def GetResultFieldRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Option[String]], e3: GR[java.sql.Timestamp]): GR[FieldRow] = GR{
    prs => import prs._
    FieldRow.tupled((<<[Long], <<[String], <<[String], <<[String], <<[String], <<?[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table field. Objects of this class serve as prototypes for rows in queries. */
  class Field(_tableTag: Tag) extends profile.api.Table[FieldRow](_tableTag, Some("chaman"), "field") {
    def * = (id, uuid, reference, datatype, label, defaultValue, timestamp) <> (FieldRow.tupled, FieldRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(uuid), Rep.Some(reference), Rep.Some(datatype), Rep.Some(label), defaultValue, Rep.Some(timestamp))).shaped.<>({r=>import r._; _1.map(_=> FieldRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column default_value SqlType(TEXT), Default(None) */
    val defaultValue: Rep[Option[String]] = column[Option[String]]("default_value", O.Default(None))
    /** Database column timestamp SqlType(TIMESTAMP) */
    val timestamp: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("timestamp")
  }
  /** Collection-like TableQuery object for table Field */
  lazy val Field = new TableQuery(tag => new Field(tag))

  /** Entity class storing rows of table FieldData
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param fieldUuid Database column field_uuid SqlType(VARCHAR), Length(36,true)
   *  @param referenceUuid Database column reference_uuid SqlType(VARCHAR), Length(36,true)
   *  @param value Database column value SqlType(TEXT), Default(None)
   *  @param timestamp Database column timestamp SqlType(TIMESTAMP) */
  case class FieldDataRow(id: Long, fieldUuid: String, referenceUuid: String, value: Option[String] = None, timestamp: java.sql.Timestamp)
  /** GetResult implicit for fetching FieldDataRow objects using plain SQL queries */
  implicit def GetResultFieldDataRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Option[String]], e3: GR[java.sql.Timestamp]): GR[FieldDataRow] = GR{
    prs => import prs._
    FieldDataRow.tupled((<<[Long], <<[String], <<[String], <<?[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table field_data. Objects of this class serve as prototypes for rows in queries. */
  class FieldData(_tableTag: Tag) extends profile.api.Table[FieldDataRow](_tableTag, Some("chaman"), "field_data") {
    def * = (id, fieldUuid, referenceUuid, value, timestamp) <> (FieldDataRow.tupled, FieldDataRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(fieldUuid), Rep.Some(referenceUuid), value, Rep.Some(timestamp))).shaped.<>({r=>import r._; _1.map(_=> FieldDataRow.tupled((_1.get, _2.get, _3.get, _4, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column field_uuid SqlType(VARCHAR), Length(36,true) */
    val fieldUuid: Rep[String] = column[String]("field_uuid", O.Length(36,varying=true))
    /** Database column reference_uuid SqlType(VARCHAR), Length(36,true) */
    val referenceUuid: Rep[String] = column[String]("reference_uuid", O.Length(36,varying=true))
    /** Database column value SqlType(TEXT), Default(None) */
    val value: Rep[Option[String]] = column[Option[String]]("value", O.Default(None))
    /** Database column timestamp SqlType(TIMESTAMP) */
    val timestamp: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("timestamp")
  }
  /** Collection-like TableQuery object for table FieldData */
  lazy val FieldData = new TableQuery(tag => new FieldData(tag))

  /** Entity class storing rows of table FieldDataDeleted
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param fkFieldDataId Database column fk_field_data_id SqlType(BIGINT)
   *  @param timestamp Database column timestamp SqlType(TIMESTAMP) */
  case class FieldDataDeletedRow(id: Long, fkFieldDataId: Long, timestamp: java.sql.Timestamp)
  /** GetResult implicit for fetching FieldDataDeletedRow objects using plain SQL queries */
  implicit def GetResultFieldDataDeletedRow(implicit e0: GR[Long], e1: GR[java.sql.Timestamp]): GR[FieldDataDeletedRow] = GR{
    prs => import prs._
    FieldDataDeletedRow.tupled((<<[Long], <<[Long], <<[java.sql.Timestamp]))
  }
  /** Table description of table field_data_deleted. Objects of this class serve as prototypes for rows in queries. */
  class FieldDataDeleted(_tableTag: Tag) extends profile.api.Table[FieldDataDeletedRow](_tableTag, Some("chaman"), "field_data_deleted") {
    def * = (id, fkFieldDataId, timestamp) <> (FieldDataDeletedRow.tupled, FieldDataDeletedRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(fkFieldDataId), Rep.Some(timestamp))).shaped.<>({r=>import r._; _1.map(_=> FieldDataDeletedRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column fk_field_data_id SqlType(BIGINT) */
    val fkFieldDataId: Rep[Long] = column[Long]("fk_field_data_id")
    /** Database column timestamp SqlType(TIMESTAMP) */
    val timestamp: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("timestamp")
  }
  /** Collection-like TableQuery object for table FieldDataDeleted */
  lazy val FieldDataDeleted = new TableQuery(tag => new FieldDataDeleted(tag))

  /** Entity class storing rows of table FieldDeleted
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param fkFieldId Database column fk_field_id SqlType(BIGINT)
   *  @param timestamp Database column timestamp SqlType(TIMESTAMP) */
  case class FieldDeletedRow(id: Long, fkFieldId: Long, timestamp: java.sql.Timestamp)
  /** GetResult implicit for fetching FieldDeletedRow objects using plain SQL queries */
  implicit def GetResultFieldDeletedRow(implicit e0: GR[Long], e1: GR[java.sql.Timestamp]): GR[FieldDeletedRow] = GR{
    prs => import prs._
    FieldDeletedRow.tupled((<<[Long], <<[Long], <<[java.sql.Timestamp]))
  }
  /** Table description of table field_deleted. Objects of this class serve as prototypes for rows in queries. */
  class FieldDeleted(_tableTag: Tag) extends profile.api.Table[FieldDeletedRow](_tableTag, Some("chaman"), "field_deleted") {
    def * = (id, fkFieldId, timestamp) <> (FieldDeletedRow.tupled, FieldDeletedRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(fkFieldId), Rep.Some(timestamp))).shaped.<>({r=>import r._; _1.map(_=> FieldDeletedRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column fk_field_id SqlType(BIGINT) */
    val fkFieldId: Rep[Long] = column[Long]("fk_field_id")
    /** Database column timestamp SqlType(TIMESTAMP) */
    val timestamp: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("timestamp")
  }
  /** Collection-like TableQuery object for table FieldDeleted */
  lazy val FieldDeleted = new TableQuery(tag => new FieldDeleted(tag))

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

  /** Entity class storing rows of table Template
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(36,true)
   *  @param reference Database column reference SqlType(VARCHAR), Length(255,true)
   *  @param label Database column label SqlType(VARCHAR), Length(255,true)
   *  @param timestamp Database column timestamp SqlType(TIMESTAMP) */
  case class TemplateRow(id: Long, uuid: String, reference: String, label: String, timestamp: java.sql.Timestamp)
  /** GetResult implicit for fetching TemplateRow objects using plain SQL queries */
  implicit def GetResultTemplateRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[TemplateRow] = GR{
    prs => import prs._
    TemplateRow.tupled((<<[Long], <<[String], <<[String], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table template. Objects of this class serve as prototypes for rows in queries. */
  class Template(_tableTag: Tag) extends profile.api.Table[TemplateRow](_tableTag, Some("chaman"), "template") {
    def * = (id, uuid, reference, label, timestamp) <> (TemplateRow.tupled, TemplateRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(uuid), Rep.Some(reference), Rep.Some(label), Rep.Some(timestamp))).shaped.<>({r=>import r._; _1.map(_=> TemplateRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(36,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(36,varying=true))
    /** Database column reference SqlType(VARCHAR), Length(255,true) */
    val reference: Rep[String] = column[String]("reference", O.Length(255,varying=true))
    /** Database column label SqlType(VARCHAR), Length(255,true) */
    val label: Rep[String] = column[String]("label", O.Length(255,varying=true))
    /** Database column timestamp SqlType(TIMESTAMP) */
    val timestamp: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("timestamp")
  }
  /** Collection-like TableQuery object for table Template */
  lazy val Template = new TableQuery(tag => new Template(tag))

  /** Entity class storing rows of table TemplateDeleted
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param fkTemplateId Database column fk_template_id SqlType(BIGINT)
   *  @param timestamp Database column timestamp SqlType(TIMESTAMP) */
  case class TemplateDeletedRow(id: Long, fkTemplateId: Long, timestamp: java.sql.Timestamp)
  /** GetResult implicit for fetching TemplateDeletedRow objects using plain SQL queries */
  implicit def GetResultTemplateDeletedRow(implicit e0: GR[Long], e1: GR[java.sql.Timestamp]): GR[TemplateDeletedRow] = GR{
    prs => import prs._
    TemplateDeletedRow.tupled((<<[Long], <<[Long], <<[java.sql.Timestamp]))
  }
  /** Table description of table template_deleted. Objects of this class serve as prototypes for rows in queries. */
  class TemplateDeleted(_tableTag: Tag) extends profile.api.Table[TemplateDeletedRow](_tableTag, Some("chaman"), "template_deleted") {
    def * = (id, fkTemplateId, timestamp) <> (TemplateDeletedRow.tupled, TemplateDeletedRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(fkTemplateId), Rep.Some(timestamp))).shaped.<>({r=>import r._; _1.map(_=> TemplateDeletedRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column fk_template_id SqlType(BIGINT) */
    val fkTemplateId: Rep[Long] = column[Long]("fk_template_id")
    /** Database column timestamp SqlType(TIMESTAMP) */
    val timestamp: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("timestamp")
  }
  /** Collection-like TableQuery object for table TemplateDeleted */
  lazy val TemplateDeleted = new TableQuery(tag => new TemplateDeleted(tag))

  /** Entity class storing rows of table TemplateParent
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param parentReference Database column parent_reference SqlType(VARCHAR), Length(255,true)
   *  @param childReference Database column child_reference SqlType(VARCHAR), Length(255,true)
   *  @param timestamp Database column timestamp SqlType(TIMESTAMP) */
  case class TemplateParentRow(id: Long, parentReference: String, childReference: String, timestamp: java.sql.Timestamp)
  /** GetResult implicit for fetching TemplateParentRow objects using plain SQL queries */
  implicit def GetResultTemplateParentRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[TemplateParentRow] = GR{
    prs => import prs._
    TemplateParentRow.tupled((<<[Long], <<[String], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table template_parent. Objects of this class serve as prototypes for rows in queries. */
  class TemplateParent(_tableTag: Tag) extends profile.api.Table[TemplateParentRow](_tableTag, Some("chaman"), "template_parent") {
    def * = (id, parentReference, childReference, timestamp) <> (TemplateParentRow.tupled, TemplateParentRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(parentReference), Rep.Some(childReference), Rep.Some(timestamp))).shaped.<>({r=>import r._; _1.map(_=> TemplateParentRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column parent_reference SqlType(VARCHAR), Length(255,true) */
    val parentReference: Rep[String] = column[String]("parent_reference", O.Length(255,varying=true))
    /** Database column child_reference SqlType(VARCHAR), Length(255,true) */
    val childReference: Rep[String] = column[String]("child_reference", O.Length(255,varying=true))
    /** Database column timestamp SqlType(TIMESTAMP) */
    val timestamp: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("timestamp")
  }
  /** Collection-like TableQuery object for table TemplateParent */
  lazy val TemplateParent = new TableQuery(tag => new TemplateParent(tag))

  /** Entity class storing rows of table TemplateParentDeleted
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param fkTemplateParentId Database column fk_template_parent_id SqlType(BIGINT)
   *  @param timestamp Database column timestamp SqlType(TIMESTAMP) */
  case class TemplateParentDeletedRow(id: Long, fkTemplateParentId: Long, timestamp: java.sql.Timestamp)
  /** GetResult implicit for fetching TemplateParentDeletedRow objects using plain SQL queries */
  implicit def GetResultTemplateParentDeletedRow(implicit e0: GR[Long], e1: GR[java.sql.Timestamp]): GR[TemplateParentDeletedRow] = GR{
    prs => import prs._
    TemplateParentDeletedRow.tupled((<<[Long], <<[Long], <<[java.sql.Timestamp]))
  }
  /** Table description of table template_parent_deleted. Objects of this class serve as prototypes for rows in queries. */
  class TemplateParentDeleted(_tableTag: Tag) extends profile.api.Table[TemplateParentDeletedRow](_tableTag, Some("chaman"), "template_parent_deleted") {
    def * = (id, fkTemplateParentId, timestamp) <> (TemplateParentDeletedRow.tupled, TemplateParentDeletedRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(fkTemplateParentId), Rep.Some(timestamp))).shaped.<>({r=>import r._; _1.map(_=> TemplateParentDeletedRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column fk_template_parent_id SqlType(BIGINT) */
    val fkTemplateParentId: Rep[Long] = column[Long]("fk_template_parent_id")
    /** Database column timestamp SqlType(TIMESTAMP) */
    val timestamp: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("timestamp")
  }
  /** Collection-like TableQuery object for table TemplateParentDeleted */
  lazy val TemplateParentDeleted = new TableQuery(tag => new TemplateParentDeleted(tag))

  /** Entity class storing rows of table User
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(36,true)
   *  @param firstname Database column firstname SqlType(VARCHAR), Length(255,true)
   *  @param lastname Database column lastname SqlType(VARCHAR), Length(255,true)
   *  @param reference Database column reference SqlType(VARCHAR), Length(255,true)
   *  @param timestamp Database column timestamp SqlType(TIMESTAMP) */
  case class UserRow(id: Long, uuid: String, firstname: String, lastname: String, reference: String, timestamp: java.sql.Timestamp)
  /** GetResult implicit for fetching UserRow objects using plain SQL queries */
  implicit def GetResultUserRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[UserRow] = GR{
    prs => import prs._
    UserRow.tupled((<<[Long], <<[String], <<[String], <<[String], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table user. Objects of this class serve as prototypes for rows in queries. */
  class User(_tableTag: Tag) extends profile.api.Table[UserRow](_tableTag, Some("chaman"), "user") {
    def * = (id, uuid, firstname, lastname, reference, timestamp) <> (UserRow.tupled, UserRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(uuid), Rep.Some(firstname), Rep.Some(lastname), Rep.Some(reference), Rep.Some(timestamp))).shaped.<>({r=>import r._; _1.map(_=> UserRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(36,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(36,varying=true))
    /** Database column firstname SqlType(VARCHAR), Length(255,true) */
    val firstname: Rep[String] = column[String]("firstname", O.Length(255,varying=true))
    /** Database column lastname SqlType(VARCHAR), Length(255,true) */
    val lastname: Rep[String] = column[String]("lastname", O.Length(255,varying=true))
    /** Database column reference SqlType(VARCHAR), Length(255,true) */
    val reference: Rep[String] = column[String]("reference", O.Length(255,varying=true))
    /** Database column timestamp SqlType(TIMESTAMP) */
    val timestamp: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("timestamp")
  }
  /** Collection-like TableQuery object for table User */
  lazy val User = new TableQuery(tag => new User(tag))
}
