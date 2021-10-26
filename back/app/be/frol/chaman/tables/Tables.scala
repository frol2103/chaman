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
  import slick.collection.heterogeneous._
  import slick.collection.heterogeneous.syntax._
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Array(AdminEventEntity.schema, Annex.schema, AnnexRemoved.schema, AssociatedPolicy.schema, AuthenticationExecution.schema, AuthenticationFlow.schema, AuthenticatorConfig.schema, AuthenticatorConfigEntry.schema, BrokerLink.schema, Client.schema, ClientAttributes.schema, ClientAuthFlowBindings.schema, ClientInitialAccess.schema, ClientNodeRegistrations.schema, ClientScope.schema, ClientScopeAttributes.schema, ClientScopeClient.schema, ClientScopeRoleMapping.schema, ClientSession.schema, ClientSessionAuthStatus.schema, ClientSessionNote.schema, ClientSessionProtMapper.schema, ClientSessionRole.schema, ClientUserSessionNote.schema, Component.schema, ComponentConfig.schema, CompositeRole.schema, Credential.schema, Data.schema, Databasechangelog.schema, Databasechangeloglock.schema, DataDeleted.schema, DefaultClientScope.schema, EventEntity.schema, FederatedIdentity.schema, FederatedUser.schema, FedUserAttribute.schema, FedUserConsent.schema, FedUserConsentClScope.schema, FedUserCredential.schema, FedUserGroupMembership.schema, FedUserRequiredAction.schema, FedUserRoleMapping.schema, Field.schema, FieldDeleted.schema, FieldTag.schema, GroupAttribute.schema, GroupRoleMapping.schema, IdentityProvider.schema, IdentityProviderConfig.schema, IdentityProviderMapper.schema, IdpMapperConfig.schema, Item.schema, ItemDeleted.schema, ItemThumbnail.schema, KeycloakGroup.schema, KeycloakRole.schema, Link.schema, LinkRemoved.schema, MigrationModel.schema, OfflineClientSession.schema, OfflineUserSession.schema, PlayEvolutions.schema, PolicyConfig.schema, ProtocolMapper.schema, ProtocolMapperConfig.schema, Realm.schema, RealmAttribute.schema, RealmDefaultGroups.schema, RealmEnabledEventTypes.schema, RealmEventsListeners.schema, RealmLocalizations.schema, RealmRequiredCredential.schema, RealmSmtpConfig.schema, RealmSupportedLocales.schema, RedirectUris.schema, RequiredActionConfig.schema, RequiredActionProvider.schema, ResourceAttribute.schema, ResourcePolicy.schema, ResourceScope.schema, ResourceServer.schema, ResourceServerPermTicket.schema, ResourceServerPolicy.schema, ResourceServerResource.schema, ResourceServerScope.schema, ResourceUris.schema, RoleAttribute.schema, ScopeMapping.schema, ScopePolicy.schema, User.schema, UserAttribute.schema, UserConsent.schema, UserConsentClientScope.schema, UserEntity.schema, UserFederationConfig.schema, UserFederationMapper.schema, UserFederationMapperConfig.schema, UserFederationProvider.schema, UserGroupMembership.schema, UsernameLoginFailure.schema, UserRequiredAction.schema, UserRoleMapping.schema, UserSession.schema, UserSessionNote.schema, WebOrigins.schema).reduceLeft(_ ++ _)
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table AdminEventEntity
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param adminEventTime Database column ADMIN_EVENT_TIME SqlType(BIGINT), Default(None)
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param operationType Database column OPERATION_TYPE SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param authRealmId Database column AUTH_REALM_ID SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param authClientId Database column AUTH_CLIENT_ID SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param authUserId Database column AUTH_USER_ID SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param ipAddress Database column IP_ADDRESS SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param resourcePath Database column RESOURCE_PATH SqlType(TEXT), Default(None)
   *  @param representation Database column REPRESENTATION SqlType(TEXT), Default(None)
   *  @param error Database column ERROR SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param resourceType Database column RESOURCE_TYPE SqlType(VARCHAR), Length(64,true), Default(None) */
  case class AdminEventEntityRow(id: String, adminEventTime: Option[Long] = None, realmId: Option[String] = None, operationType: Option[String] = None, authRealmId: Option[String] = None, authClientId: Option[String] = None, authUserId: Option[String] = None, ipAddress: Option[String] = None, resourcePath: Option[String] = None, representation: Option[String] = None, error: Option[String] = None, resourceType: Option[String] = None)
  /** GetResult implicit for fetching AdminEventEntityRow objects using plain SQL queries */
  implicit def GetResultAdminEventEntityRow(implicit e0: GR[String], e1: GR[Option[Long]], e2: GR[Option[String]]): GR[AdminEventEntityRow] = GR{
    prs => import prs._
    AdminEventEntityRow.tupled((<<[String], <<?[Long], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table ADMIN_EVENT_ENTITY. Objects of this class serve as prototypes for rows in queries. */
  class AdminEventEntity(_tableTag: Tag) extends profile.api.Table[AdminEventEntityRow](_tableTag, Some("chaman"), "ADMIN_EVENT_ENTITY") {
    def * = (id, adminEventTime, realmId, operationType, authRealmId, authClientId, authUserId, ipAddress, resourcePath, representation, error, resourceType) <> (AdminEventEntityRow.tupled, AdminEventEntityRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), adminEventTime, realmId, operationType, authRealmId, authClientId, authUserId, ipAddress, resourcePath, representation, error, resourceType)).shaped.<>({r=>import r._; _1.map(_=> AdminEventEntityRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column ADMIN_EVENT_TIME SqlType(BIGINT), Default(None) */
    val adminEventTime: Rep[Option[Long]] = column[Option[Long]]("ADMIN_EVENT_TIME", O.Default(None))
    /** Database column REALM_ID SqlType(VARCHAR), Length(255,true), Default(None) */
    val realmId: Rep[Option[String]] = column[Option[String]]("REALM_ID", O.Length(255,varying=true), O.Default(None))
    /** Database column OPERATION_TYPE SqlType(VARCHAR), Length(255,true), Default(None) */
    val operationType: Rep[Option[String]] = column[Option[String]]("OPERATION_TYPE", O.Length(255,varying=true), O.Default(None))
    /** Database column AUTH_REALM_ID SqlType(VARCHAR), Length(255,true), Default(None) */
    val authRealmId: Rep[Option[String]] = column[Option[String]]("AUTH_REALM_ID", O.Length(255,varying=true), O.Default(None))
    /** Database column AUTH_CLIENT_ID SqlType(VARCHAR), Length(255,true), Default(None) */
    val authClientId: Rep[Option[String]] = column[Option[String]]("AUTH_CLIENT_ID", O.Length(255,varying=true), O.Default(None))
    /** Database column AUTH_USER_ID SqlType(VARCHAR), Length(255,true), Default(None) */
    val authUserId: Rep[Option[String]] = column[Option[String]]("AUTH_USER_ID", O.Length(255,varying=true), O.Default(None))
    /** Database column IP_ADDRESS SqlType(VARCHAR), Length(255,true), Default(None) */
    val ipAddress: Rep[Option[String]] = column[Option[String]]("IP_ADDRESS", O.Length(255,varying=true), O.Default(None))
    /** Database column RESOURCE_PATH SqlType(TEXT), Default(None) */
    val resourcePath: Rep[Option[String]] = column[Option[String]]("RESOURCE_PATH", O.Default(None))
    /** Database column REPRESENTATION SqlType(TEXT), Default(None) */
    val representation: Rep[Option[String]] = column[Option[String]]("REPRESENTATION", O.Default(None))
    /** Database column ERROR SqlType(VARCHAR), Length(255,true), Default(None) */
    val error: Rep[Option[String]] = column[Option[String]]("ERROR", O.Length(255,varying=true), O.Default(None))
    /** Database column RESOURCE_TYPE SqlType(VARCHAR), Length(64,true), Default(None) */
    val resourceType: Rep[Option[String]] = column[Option[String]]("RESOURCE_TYPE", O.Length(64,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table AdminEventEntity */
  lazy val AdminEventEntity = new TableQuery(tag => new AdminEventEntity(tag))

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

  /** Entity class storing rows of table AssociatedPolicy
   *  @param policyId Database column POLICY_ID SqlType(VARCHAR), Length(36,true)
   *  @param associatedPolicyId Database column ASSOCIATED_POLICY_ID SqlType(VARCHAR), Length(36,true) */
  case class AssociatedPolicyRow(policyId: String, associatedPolicyId: String)
  /** GetResult implicit for fetching AssociatedPolicyRow objects using plain SQL queries */
  implicit def GetResultAssociatedPolicyRow(implicit e0: GR[String]): GR[AssociatedPolicyRow] = GR{
    prs => import prs._
    AssociatedPolicyRow.tupled((<<[String], <<[String]))
  }
  /** Table description of table ASSOCIATED_POLICY. Objects of this class serve as prototypes for rows in queries. */
  class AssociatedPolicy(_tableTag: Tag) extends profile.api.Table[AssociatedPolicyRow](_tableTag, Some("chaman"), "ASSOCIATED_POLICY") {
    def * = (policyId, associatedPolicyId) <> (AssociatedPolicyRow.tupled, AssociatedPolicyRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(policyId), Rep.Some(associatedPolicyId))).shaped.<>({r=>import r._; _1.map(_=> AssociatedPolicyRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column POLICY_ID SqlType(VARCHAR), Length(36,true) */
    val policyId: Rep[String] = column[String]("POLICY_ID", O.Length(36,varying=true))
    /** Database column ASSOCIATED_POLICY_ID SqlType(VARCHAR), Length(36,true) */
    val associatedPolicyId: Rep[String] = column[String]("ASSOCIATED_POLICY_ID", O.Length(36,varying=true))

    /** Primary key of AssociatedPolicy (database name ASSOCIATED_POLICY_PK) */
    val pk = primaryKey("ASSOCIATED_POLICY_PK", (policyId, associatedPolicyId))

    /** Foreign key referencing ResourceServerPolicy (database name FK_FRSR5S213XCX4WNKOG82SSRFY) */
    lazy val resourceServerPolicyFk1 = foreignKey("FK_FRSR5S213XCX4WNKOG82SSRFY", associatedPolicyId, ResourceServerPolicy)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing ResourceServerPolicy (database name FK_FRSRPAS14XCX4WNKOG82SSRFY) */
    lazy val resourceServerPolicyFk2 = foreignKey("FK_FRSRPAS14XCX4WNKOG82SSRFY", policyId, ResourceServerPolicy)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table AssociatedPolicy */
  lazy val AssociatedPolicy = new TableQuery(tag => new AssociatedPolicy(tag))

  /** Entity class storing rows of table AuthenticationExecution
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param alias Database column ALIAS SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param authenticator Database column AUTHENTICATOR SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param flowId Database column FLOW_ID SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param requirement Database column REQUIREMENT SqlType(INT), Default(None)
   *  @param priority Database column PRIORITY SqlType(INT), Default(None)
   *  @param authenticatorFlow Database column AUTHENTICATOR_FLOW SqlType(BIT), Default(false)
   *  @param authFlowId Database column AUTH_FLOW_ID SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param authConfig Database column AUTH_CONFIG SqlType(VARCHAR), Length(36,true), Default(None) */
  case class AuthenticationExecutionRow(id: String, alias: Option[String] = None, authenticator: Option[String] = None, realmId: Option[String] = None, flowId: Option[String] = None, requirement: Option[Int] = None, priority: Option[Int] = None, authenticatorFlow: Boolean = false, authFlowId: Option[String] = None, authConfig: Option[String] = None)
  /** GetResult implicit for fetching AuthenticationExecutionRow objects using plain SQL queries */
  implicit def GetResultAuthenticationExecutionRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[Boolean]): GR[AuthenticationExecutionRow] = GR{
    prs => import prs._
    AuthenticationExecutionRow.tupled((<<[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Int], <<?[Int], <<[Boolean], <<?[String], <<?[String]))
  }
  /** Table description of table AUTHENTICATION_EXECUTION. Objects of this class serve as prototypes for rows in queries. */
  class AuthenticationExecution(_tableTag: Tag) extends profile.api.Table[AuthenticationExecutionRow](_tableTag, Some("chaman"), "AUTHENTICATION_EXECUTION") {
    def * = (id, alias, authenticator, realmId, flowId, requirement, priority, authenticatorFlow, authFlowId, authConfig) <> (AuthenticationExecutionRow.tupled, AuthenticationExecutionRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), alias, authenticator, realmId, flowId, requirement, priority, Rep.Some(authenticatorFlow), authFlowId, authConfig)).shaped.<>({r=>import r._; _1.map(_=> AuthenticationExecutionRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8.get, _9, _10)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column ALIAS SqlType(VARCHAR), Length(255,true), Default(None) */
    val alias: Rep[Option[String]] = column[Option[String]]("ALIAS", O.Length(255,varying=true), O.Default(None))
    /** Database column AUTHENTICATOR SqlType(VARCHAR), Length(36,true), Default(None) */
    val authenticator: Rep[Option[String]] = column[Option[String]]("AUTHENTICATOR", O.Length(36,varying=true), O.Default(None))
    /** Database column REALM_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val realmId: Rep[Option[String]] = column[Option[String]]("REALM_ID", O.Length(36,varying=true), O.Default(None))
    /** Database column FLOW_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val flowId: Rep[Option[String]] = column[Option[String]]("FLOW_ID", O.Length(36,varying=true), O.Default(None))
    /** Database column REQUIREMENT SqlType(INT), Default(None) */
    val requirement: Rep[Option[Int]] = column[Option[Int]]("REQUIREMENT", O.Default(None))
    /** Database column PRIORITY SqlType(INT), Default(None) */
    val priority: Rep[Option[Int]] = column[Option[Int]]("PRIORITY", O.Default(None))
    /** Database column AUTHENTICATOR_FLOW SqlType(BIT), Default(false) */
    val authenticatorFlow: Rep[Boolean] = column[Boolean]("AUTHENTICATOR_FLOW", O.Default(false))
    /** Database column AUTH_FLOW_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val authFlowId: Rep[Option[String]] = column[Option[String]]("AUTH_FLOW_ID", O.Length(36,varying=true), O.Default(None))
    /** Database column AUTH_CONFIG SqlType(VARCHAR), Length(36,true), Default(None) */
    val authConfig: Rep[Option[String]] = column[Option[String]]("AUTH_CONFIG", O.Length(36,varying=true), O.Default(None))

    /** Foreign key referencing AuthenticationFlow (database name FK_AUTH_EXEC_FLOW) */
    lazy val authenticationFlowFk = foreignKey("FK_AUTH_EXEC_FLOW", flowId, AuthenticationFlow)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Realm (database name FK_AUTH_EXEC_REALM) */
    lazy val realmFk = foreignKey("FK_AUTH_EXEC_REALM", realmId, Realm)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Index over (realmId,flowId) (database name IDX_AUTH_EXEC_REALM_FLOW) */
    val index1 = index("IDX_AUTH_EXEC_REALM_FLOW", (realmId, flowId))
  }
  /** Collection-like TableQuery object for table AuthenticationExecution */
  lazy val AuthenticationExecution = new TableQuery(tag => new AuthenticationExecution(tag))

  /** Entity class storing rows of table AuthenticationFlow
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param alias Database column ALIAS SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param description Database column DESCRIPTION SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param providerId Database column PROVIDER_ID SqlType(VARCHAR), Length(36,true), Default(basic-flow)
   *  @param topLevel Database column TOP_LEVEL SqlType(BIT), Default(false)
   *  @param builtIn Database column BUILT_IN SqlType(BIT), Default(false) */
  case class AuthenticationFlowRow(id: String, alias: Option[String] = None, description: Option[String] = None, realmId: Option[String] = None, providerId: String = "basic-flow", topLevel: Boolean = false, builtIn: Boolean = false)
  /** GetResult implicit for fetching AuthenticationFlowRow objects using plain SQL queries */
  implicit def GetResultAuthenticationFlowRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Boolean]): GR[AuthenticationFlowRow] = GR{
    prs => import prs._
    AuthenticationFlowRow.tupled((<<[String], <<?[String], <<?[String], <<?[String], <<[String], <<[Boolean], <<[Boolean]))
  }
  /** Table description of table AUTHENTICATION_FLOW. Objects of this class serve as prototypes for rows in queries. */
  class AuthenticationFlow(_tableTag: Tag) extends profile.api.Table[AuthenticationFlowRow](_tableTag, Some("chaman"), "AUTHENTICATION_FLOW") {
    def * = (id, alias, description, realmId, providerId, topLevel, builtIn) <> (AuthenticationFlowRow.tupled, AuthenticationFlowRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), alias, description, realmId, Rep.Some(providerId), Rep.Some(topLevel), Rep.Some(builtIn))).shaped.<>({r=>import r._; _1.map(_=> AuthenticationFlowRow.tupled((_1.get, _2, _3, _4, _5.get, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column ALIAS SqlType(VARCHAR), Length(255,true), Default(None) */
    val alias: Rep[Option[String]] = column[Option[String]]("ALIAS", O.Length(255,varying=true), O.Default(None))
    /** Database column DESCRIPTION SqlType(VARCHAR), Length(255,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("DESCRIPTION", O.Length(255,varying=true), O.Default(None))
    /** Database column REALM_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val realmId: Rep[Option[String]] = column[Option[String]]("REALM_ID", O.Length(36,varying=true), O.Default(None))
    /** Database column PROVIDER_ID SqlType(VARCHAR), Length(36,true), Default(basic-flow) */
    val providerId: Rep[String] = column[String]("PROVIDER_ID", O.Length(36,varying=true), O.Default("basic-flow"))
    /** Database column TOP_LEVEL SqlType(BIT), Default(false) */
    val topLevel: Rep[Boolean] = column[Boolean]("TOP_LEVEL", O.Default(false))
    /** Database column BUILT_IN SqlType(BIT), Default(false) */
    val builtIn: Rep[Boolean] = column[Boolean]("BUILT_IN", O.Default(false))

    /** Foreign key referencing Realm (database name FK_AUTH_FLOW_REALM) */
    lazy val realmFk = foreignKey("FK_AUTH_FLOW_REALM", realmId, Realm)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table AuthenticationFlow */
  lazy val AuthenticationFlow = new TableQuery(tag => new AuthenticationFlow(tag))

  /** Entity class storing rows of table AuthenticatorConfig
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param alias Database column ALIAS SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(36,true), Default(None) */
  case class AuthenticatorConfigRow(id: String, alias: Option[String] = None, realmId: Option[String] = None)
  /** GetResult implicit for fetching AuthenticatorConfigRow objects using plain SQL queries */
  implicit def GetResultAuthenticatorConfigRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[AuthenticatorConfigRow] = GR{
    prs => import prs._
    AuthenticatorConfigRow.tupled((<<[String], <<?[String], <<?[String]))
  }
  /** Table description of table AUTHENTICATOR_CONFIG. Objects of this class serve as prototypes for rows in queries. */
  class AuthenticatorConfig(_tableTag: Tag) extends profile.api.Table[AuthenticatorConfigRow](_tableTag, Some("chaman"), "AUTHENTICATOR_CONFIG") {
    def * = (id, alias, realmId) <> (AuthenticatorConfigRow.tupled, AuthenticatorConfigRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), alias, realmId)).shaped.<>({r=>import r._; _1.map(_=> AuthenticatorConfigRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column ALIAS SqlType(VARCHAR), Length(255,true), Default(None) */
    val alias: Rep[Option[String]] = column[Option[String]]("ALIAS", O.Length(255,varying=true), O.Default(None))
    /** Database column REALM_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val realmId: Rep[Option[String]] = column[Option[String]]("REALM_ID", O.Length(36,varying=true), O.Default(None))

    /** Foreign key referencing Realm (database name FK_AUTH_REALM) */
    lazy val realmFk = foreignKey("FK_AUTH_REALM", realmId, Realm)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table AuthenticatorConfig */
  lazy val AuthenticatorConfig = new TableQuery(tag => new AuthenticatorConfig(tag))

  /** Entity class storing rows of table AuthenticatorConfigEntry
   *  @param authenticatorId Database column AUTHENTICATOR_ID SqlType(VARCHAR), Length(36,true)
   *  @param value Database column VALUE SqlType(LONGTEXT), Length(2147483647,true), Default(None)
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true) */
  case class AuthenticatorConfigEntryRow(authenticatorId: String, value: Option[String] = None, name: String)
  /** GetResult implicit for fetching AuthenticatorConfigEntryRow objects using plain SQL queries */
  implicit def GetResultAuthenticatorConfigEntryRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[AuthenticatorConfigEntryRow] = GR{
    prs => import prs._
    AuthenticatorConfigEntryRow.tupled((<<[String], <<?[String], <<[String]))
  }
  /** Table description of table AUTHENTICATOR_CONFIG_ENTRY. Objects of this class serve as prototypes for rows in queries. */
  class AuthenticatorConfigEntry(_tableTag: Tag) extends profile.api.Table[AuthenticatorConfigEntryRow](_tableTag, Some("chaman"), "AUTHENTICATOR_CONFIG_ENTRY") {
    def * = (authenticatorId, value, name) <> (AuthenticatorConfigEntryRow.tupled, AuthenticatorConfigEntryRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(authenticatorId), value, Rep.Some(name))).shaped.<>({r=>import r._; _1.map(_=> AuthenticatorConfigEntryRow.tupled((_1.get, _2, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AUTHENTICATOR_ID SqlType(VARCHAR), Length(36,true) */
    val authenticatorId: Rep[String] = column[String]("AUTHENTICATOR_ID", O.Length(36,varying=true))
    /** Database column VALUE SqlType(LONGTEXT), Length(2147483647,true), Default(None) */
    val value: Rep[Option[String]] = column[Option[String]]("VALUE", O.Length(2147483647,varying=true), O.Default(None))
    /** Database column NAME SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("NAME", O.Length(255,varying=true))

    /** Primary key of AuthenticatorConfigEntry (database name AUTHENTICATOR_CONFIG_ENTRY_PK) */
    val pk = primaryKey("AUTHENTICATOR_CONFIG_ENTRY_PK", (authenticatorId, name))
  }
  /** Collection-like TableQuery object for table AuthenticatorConfigEntry */
  lazy val AuthenticatorConfigEntry = new TableQuery(tag => new AuthenticatorConfigEntry(tag))

  /** Entity class storing rows of table BrokerLink
   *  @param identityProvider Database column IDENTITY_PROVIDER SqlType(VARCHAR), Length(255,true)
   *  @param storageProviderId Database column STORAGE_PROVIDER_ID SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(36,true)
   *  @param brokerUserId Database column BROKER_USER_ID SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param brokerUsername Database column BROKER_USERNAME SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param token Database column TOKEN SqlType(TEXT), Default(None)
   *  @param userId Database column USER_ID SqlType(VARCHAR), Length(255,true) */
  case class BrokerLinkRow(identityProvider: String, storageProviderId: Option[String] = None, realmId: String, brokerUserId: Option[String] = None, brokerUsername: Option[String] = None, token: Option[String] = None, userId: String)
  /** GetResult implicit for fetching BrokerLinkRow objects using plain SQL queries */
  implicit def GetResultBrokerLinkRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[BrokerLinkRow] = GR{
    prs => import prs._
    BrokerLinkRow.tupled((<<[String], <<?[String], <<[String], <<?[String], <<?[String], <<?[String], <<[String]))
  }
  /** Table description of table BROKER_LINK. Objects of this class serve as prototypes for rows in queries. */
  class BrokerLink(_tableTag: Tag) extends profile.api.Table[BrokerLinkRow](_tableTag, Some("chaman"), "BROKER_LINK") {
    def * = (identityProvider, storageProviderId, realmId, brokerUserId, brokerUsername, token, userId) <> (BrokerLinkRow.tupled, BrokerLinkRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(identityProvider), storageProviderId, Rep.Some(realmId), brokerUserId, brokerUsername, token, Rep.Some(userId))).shaped.<>({r=>import r._; _1.map(_=> BrokerLinkRow.tupled((_1.get, _2, _3.get, _4, _5, _6, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column IDENTITY_PROVIDER SqlType(VARCHAR), Length(255,true) */
    val identityProvider: Rep[String] = column[String]("IDENTITY_PROVIDER", O.Length(255,varying=true))
    /** Database column STORAGE_PROVIDER_ID SqlType(VARCHAR), Length(255,true), Default(None) */
    val storageProviderId: Rep[Option[String]] = column[Option[String]]("STORAGE_PROVIDER_ID", O.Length(255,varying=true), O.Default(None))
    /** Database column REALM_ID SqlType(VARCHAR), Length(36,true) */
    val realmId: Rep[String] = column[String]("REALM_ID", O.Length(36,varying=true))
    /** Database column BROKER_USER_ID SqlType(VARCHAR), Length(255,true), Default(None) */
    val brokerUserId: Rep[Option[String]] = column[Option[String]]("BROKER_USER_ID", O.Length(255,varying=true), O.Default(None))
    /** Database column BROKER_USERNAME SqlType(VARCHAR), Length(255,true), Default(None) */
    val brokerUsername: Rep[Option[String]] = column[Option[String]]("BROKER_USERNAME", O.Length(255,varying=true), O.Default(None))
    /** Database column TOKEN SqlType(TEXT), Default(None) */
    val token: Rep[Option[String]] = column[Option[String]]("TOKEN", O.Default(None))
    /** Database column USER_ID SqlType(VARCHAR), Length(255,true) */
    val userId: Rep[String] = column[String]("USER_ID", O.Length(255,varying=true))

    /** Primary key of BrokerLink (database name BROKER_LINK_PK) */
    val pk = primaryKey("BROKER_LINK_PK", (identityProvider, userId))
  }
  /** Collection-like TableQuery object for table BrokerLink */
  lazy val BrokerLink = new TableQuery(tag => new BrokerLink(tag))

  /** Entity class storing rows of table Client
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param enabled Database column ENABLED SqlType(BIT), Default(false)
   *  @param fullScopeAllowed Database column FULL_SCOPE_ALLOWED SqlType(BIT), Default(false)
   *  @param clientId Database column CLIENT_ID SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param notBefore Database column NOT_BEFORE SqlType(INT), Default(None)
   *  @param publicClient Database column PUBLIC_CLIENT SqlType(BIT), Default(false)
   *  @param secret Database column SECRET SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param baseUrl Database column BASE_URL SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param bearerOnly Database column BEARER_ONLY SqlType(BIT), Default(false)
   *  @param managementUrl Database column MANAGEMENT_URL SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param surrogateAuthRequired Database column SURROGATE_AUTH_REQUIRED SqlType(BIT), Default(false)
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param protocol Database column PROTOCOL SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param nodeReregTimeout Database column NODE_REREG_TIMEOUT SqlType(INT), Default(Some(0))
   *  @param frontchannelLogout Database column FRONTCHANNEL_LOGOUT SqlType(BIT), Default(false)
   *  @param consentRequired Database column CONSENT_REQUIRED SqlType(BIT), Default(false)
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param serviceAccountsEnabled Database column SERVICE_ACCOUNTS_ENABLED SqlType(BIT), Default(false)
   *  @param clientAuthenticatorType Database column CLIENT_AUTHENTICATOR_TYPE SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param rootUrl Database column ROOT_URL SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param description Database column DESCRIPTION SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param registrationToken Database column REGISTRATION_TOKEN SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param standardFlowEnabled Database column STANDARD_FLOW_ENABLED SqlType(BIT), Default(true)
   *  @param implicitFlowEnabled Database column IMPLICIT_FLOW_ENABLED SqlType(BIT), Default(false)
   *  @param directAccessGrantsEnabled Database column DIRECT_ACCESS_GRANTS_ENABLED SqlType(BIT), Default(false)
   *  @param alwaysDisplayInConsole Database column ALWAYS_DISPLAY_IN_CONSOLE SqlType(BIT), Default(false) */
  case class ClientRow(id: String, enabled: Boolean = false, fullScopeAllowed: Boolean = false, clientId: Option[String] = None, notBefore: Option[Int] = None, publicClient: Boolean = false, secret: Option[String] = None, baseUrl: Option[String] = None, bearerOnly: Boolean = false, managementUrl: Option[String] = None, surrogateAuthRequired: Boolean = false, realmId: Option[String] = None, protocol: Option[String] = None, nodeReregTimeout: Option[Int] = Some(0), frontchannelLogout: Boolean = false, consentRequired: Boolean = false, name: Option[String] = None, serviceAccountsEnabled: Boolean = false, clientAuthenticatorType: Option[String] = None, rootUrl: Option[String] = None, description: Option[String] = None, registrationToken: Option[String] = None, standardFlowEnabled: Boolean = true, implicitFlowEnabled: Boolean = false, directAccessGrantsEnabled: Boolean = false, alwaysDisplayInConsole: Boolean = false)
  /** GetResult implicit for fetching ClientRow objects using plain SQL queries */
  implicit def GetResultClientRow(implicit e0: GR[String], e1: GR[Boolean], e2: GR[Option[String]], e3: GR[Option[Int]]): GR[ClientRow] = GR{
    prs => import prs._
    ClientRow(<<[String], <<[Boolean], <<[Boolean], <<?[String], <<?[Int], <<[Boolean], <<?[String], <<?[String], <<[Boolean], <<?[String], <<[Boolean], <<?[String], <<?[String], <<?[Int], <<[Boolean], <<[Boolean], <<?[String], <<[Boolean], <<?[String], <<?[String], <<?[String], <<?[String], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean])
  }
  /** Table description of table CLIENT. Objects of this class serve as prototypes for rows in queries. */
  class Client(_tableTag: Tag) extends profile.api.Table[ClientRow](_tableTag, Some("chaman"), "CLIENT") {
    def * = (id :: enabled :: fullScopeAllowed :: clientId :: notBefore :: publicClient :: secret :: baseUrl :: bearerOnly :: managementUrl :: surrogateAuthRequired :: realmId :: protocol :: nodeReregTimeout :: frontchannelLogout :: consentRequired :: name :: serviceAccountsEnabled :: clientAuthenticatorType :: rootUrl :: description :: registrationToken :: standardFlowEnabled :: implicitFlowEnabled :: directAccessGrantsEnabled :: alwaysDisplayInConsole :: HNil).mapTo[ClientRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id) :: Rep.Some(enabled) :: Rep.Some(fullScopeAllowed) :: clientId :: notBefore :: Rep.Some(publicClient) :: secret :: baseUrl :: Rep.Some(bearerOnly) :: managementUrl :: Rep.Some(surrogateAuthRequired) :: realmId :: protocol :: nodeReregTimeout :: Rep.Some(frontchannelLogout) :: Rep.Some(consentRequired) :: name :: Rep.Some(serviceAccountsEnabled) :: clientAuthenticatorType :: rootUrl :: description :: registrationToken :: Rep.Some(standardFlowEnabled) :: Rep.Some(implicitFlowEnabled) :: Rep.Some(directAccessGrantsEnabled) :: Rep.Some(alwaysDisplayInConsole) :: HNil).shaped.<>(r => ClientRow(r(0).asInstanceOf[Option[String]].get, r(1).asInstanceOf[Option[Boolean]].get, r(2).asInstanceOf[Option[Boolean]].get, r(3).asInstanceOf[Option[String]], r(4).asInstanceOf[Option[Int]], r(5).asInstanceOf[Option[Boolean]].get, r(6).asInstanceOf[Option[String]], r(7).asInstanceOf[Option[String]], r(8).asInstanceOf[Option[Boolean]].get, r(9).asInstanceOf[Option[String]], r(10).asInstanceOf[Option[Boolean]].get, r(11).asInstanceOf[Option[String]], r(12).asInstanceOf[Option[String]], r(13).asInstanceOf[Option[Int]], r(14).asInstanceOf[Option[Boolean]].get, r(15).asInstanceOf[Option[Boolean]].get, r(16).asInstanceOf[Option[String]], r(17).asInstanceOf[Option[Boolean]].get, r(18).asInstanceOf[Option[String]], r(19).asInstanceOf[Option[String]], r(20).asInstanceOf[Option[String]], r(21).asInstanceOf[Option[String]], r(22).asInstanceOf[Option[Boolean]].get, r(23).asInstanceOf[Option[Boolean]].get, r(24).asInstanceOf[Option[Boolean]].get, r(25).asInstanceOf[Option[Boolean]].get), (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column ENABLED SqlType(BIT), Default(false) */
    val enabled: Rep[Boolean] = column[Boolean]("ENABLED", O.Default(false))
    /** Database column FULL_SCOPE_ALLOWED SqlType(BIT), Default(false) */
    val fullScopeAllowed: Rep[Boolean] = column[Boolean]("FULL_SCOPE_ALLOWED", O.Default(false))
    /** Database column CLIENT_ID SqlType(VARCHAR), Length(255,true), Default(None) */
    val clientId: Rep[Option[String]] = column[Option[String]]("CLIENT_ID", O.Length(255,varying=true), O.Default(None))
    /** Database column NOT_BEFORE SqlType(INT), Default(None) */
    val notBefore: Rep[Option[Int]] = column[Option[Int]]("NOT_BEFORE", O.Default(None))
    /** Database column PUBLIC_CLIENT SqlType(BIT), Default(false) */
    val publicClient: Rep[Boolean] = column[Boolean]("PUBLIC_CLIENT", O.Default(false))
    /** Database column SECRET SqlType(VARCHAR), Length(255,true), Default(None) */
    val secret: Rep[Option[String]] = column[Option[String]]("SECRET", O.Length(255,varying=true), O.Default(None))
    /** Database column BASE_URL SqlType(VARCHAR), Length(255,true), Default(None) */
    val baseUrl: Rep[Option[String]] = column[Option[String]]("BASE_URL", O.Length(255,varying=true), O.Default(None))
    /** Database column BEARER_ONLY SqlType(BIT), Default(false) */
    val bearerOnly: Rep[Boolean] = column[Boolean]("BEARER_ONLY", O.Default(false))
    /** Database column MANAGEMENT_URL SqlType(VARCHAR), Length(255,true), Default(None) */
    val managementUrl: Rep[Option[String]] = column[Option[String]]("MANAGEMENT_URL", O.Length(255,varying=true), O.Default(None))
    /** Database column SURROGATE_AUTH_REQUIRED SqlType(BIT), Default(false) */
    val surrogateAuthRequired: Rep[Boolean] = column[Boolean]("SURROGATE_AUTH_REQUIRED", O.Default(false))
    /** Database column REALM_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val realmId: Rep[Option[String]] = column[Option[String]]("REALM_ID", O.Length(36,varying=true), O.Default(None))
    /** Database column PROTOCOL SqlType(VARCHAR), Length(255,true), Default(None) */
    val protocol: Rep[Option[String]] = column[Option[String]]("PROTOCOL", O.Length(255,varying=true), O.Default(None))
    /** Database column NODE_REREG_TIMEOUT SqlType(INT), Default(Some(0)) */
    val nodeReregTimeout: Rep[Option[Int]] = column[Option[Int]]("NODE_REREG_TIMEOUT", O.Default(Some(0)))
    /** Database column FRONTCHANNEL_LOGOUT SqlType(BIT), Default(false) */
    val frontchannelLogout: Rep[Boolean] = column[Boolean]("FRONTCHANNEL_LOGOUT", O.Default(false))
    /** Database column CONSENT_REQUIRED SqlType(BIT), Default(false) */
    val consentRequired: Rep[Boolean] = column[Boolean]("CONSENT_REQUIRED", O.Default(false))
    /** Database column NAME SqlType(VARCHAR), Length(255,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("NAME", O.Length(255,varying=true), O.Default(None))
    /** Database column SERVICE_ACCOUNTS_ENABLED SqlType(BIT), Default(false) */
    val serviceAccountsEnabled: Rep[Boolean] = column[Boolean]("SERVICE_ACCOUNTS_ENABLED", O.Default(false))
    /** Database column CLIENT_AUTHENTICATOR_TYPE SqlType(VARCHAR), Length(255,true), Default(None) */
    val clientAuthenticatorType: Rep[Option[String]] = column[Option[String]]("CLIENT_AUTHENTICATOR_TYPE", O.Length(255,varying=true), O.Default(None))
    /** Database column ROOT_URL SqlType(VARCHAR), Length(255,true), Default(None) */
    val rootUrl: Rep[Option[String]] = column[Option[String]]("ROOT_URL", O.Length(255,varying=true), O.Default(None))
    /** Database column DESCRIPTION SqlType(VARCHAR), Length(255,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("DESCRIPTION", O.Length(255,varying=true), O.Default(None))
    /** Database column REGISTRATION_TOKEN SqlType(VARCHAR), Length(255,true), Default(None) */
    val registrationToken: Rep[Option[String]] = column[Option[String]]("REGISTRATION_TOKEN", O.Length(255,varying=true), O.Default(None))
    /** Database column STANDARD_FLOW_ENABLED SqlType(BIT), Default(true) */
    val standardFlowEnabled: Rep[Boolean] = column[Boolean]("STANDARD_FLOW_ENABLED", O.Default(true))
    /** Database column IMPLICIT_FLOW_ENABLED SqlType(BIT), Default(false) */
    val implicitFlowEnabled: Rep[Boolean] = column[Boolean]("IMPLICIT_FLOW_ENABLED", O.Default(false))
    /** Database column DIRECT_ACCESS_GRANTS_ENABLED SqlType(BIT), Default(false) */
    val directAccessGrantsEnabled: Rep[Boolean] = column[Boolean]("DIRECT_ACCESS_GRANTS_ENABLED", O.Default(false))
    /** Database column ALWAYS_DISPLAY_IN_CONSOLE SqlType(BIT), Default(false) */
    val alwaysDisplayInConsole: Rep[Boolean] = column[Boolean]("ALWAYS_DISPLAY_IN_CONSOLE", O.Default(false))

    /** Index over (clientId) (database name IDX_CLIENT_ID) */
    val index1 = index("IDX_CLIENT_ID", clientId :: HNil)
    /** Uniqueness Index over (realmId,clientId) (database name UK_B71CJLBENV945RB6GCON438AT) */
    val index2 = index("UK_B71CJLBENV945RB6GCON438AT", realmId :: clientId :: HNil, unique=true)
  }
  /** Collection-like TableQuery object for table Client */
  lazy val Client = new TableQuery(tag => new Client(tag))

  /** Entity class storing rows of table ClientAttributes
   *  @param clientId Database column CLIENT_ID SqlType(VARCHAR), Length(36,true)
   *  @param value Database column VALUE SqlType(TEXT), Default(None)
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true) */
  case class ClientAttributesRow(clientId: String, value: Option[String] = None, name: String)
  /** GetResult implicit for fetching ClientAttributesRow objects using plain SQL queries */
  implicit def GetResultClientAttributesRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[ClientAttributesRow] = GR{
    prs => import prs._
    ClientAttributesRow.tupled((<<[String], <<?[String], <<[String]))
  }
  /** Table description of table CLIENT_ATTRIBUTES. Objects of this class serve as prototypes for rows in queries. */
  class ClientAttributes(_tableTag: Tag) extends profile.api.Table[ClientAttributesRow](_tableTag, Some("chaman"), "CLIENT_ATTRIBUTES") {
    def * = (clientId, value, name) <> (ClientAttributesRow.tupled, ClientAttributesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(clientId), value, Rep.Some(name))).shaped.<>({r=>import r._; _1.map(_=> ClientAttributesRow.tupled((_1.get, _2, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column CLIENT_ID SqlType(VARCHAR), Length(36,true) */
    val clientId: Rep[String] = column[String]("CLIENT_ID", O.Length(36,varying=true))
    /** Database column VALUE SqlType(TEXT), Default(None) */
    val value: Rep[Option[String]] = column[Option[String]]("VALUE", O.Default(None))
    /** Database column NAME SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("NAME", O.Length(255,varying=true))

    /** Primary key of ClientAttributes (database name CLIENT_ATTRIBUTES_PK) */
    val pk = primaryKey("CLIENT_ATTRIBUTES_PK", (clientId, name))

    /** Foreign key referencing Client (database name FK3C47C64BEACCA966) */
    lazy val clientFk = foreignKey("FK3C47C64BEACCA966", clientId, Client)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Index over (name,value) (database name IDX_CLIENT_ATT_BY_NAME_VALUE) */
    val index1 = index("IDX_CLIENT_ATT_BY_NAME_VALUE", (name, value))
  }
  /** Collection-like TableQuery object for table ClientAttributes */
  lazy val ClientAttributes = new TableQuery(tag => new ClientAttributes(tag))

  /** Entity class storing rows of table ClientAuthFlowBindings
   *  @param clientId Database column CLIENT_ID SqlType(VARCHAR), Length(36,true)
   *  @param flowId Database column FLOW_ID SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param bindingName Database column BINDING_NAME SqlType(VARCHAR), Length(255,true) */
  case class ClientAuthFlowBindingsRow(clientId: String, flowId: Option[String] = None, bindingName: String)
  /** GetResult implicit for fetching ClientAuthFlowBindingsRow objects using plain SQL queries */
  implicit def GetResultClientAuthFlowBindingsRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[ClientAuthFlowBindingsRow] = GR{
    prs => import prs._
    ClientAuthFlowBindingsRow.tupled((<<[String], <<?[String], <<[String]))
  }
  /** Table description of table CLIENT_AUTH_FLOW_BINDINGS. Objects of this class serve as prototypes for rows in queries. */
  class ClientAuthFlowBindings(_tableTag: Tag) extends profile.api.Table[ClientAuthFlowBindingsRow](_tableTag, Some("chaman"), "CLIENT_AUTH_FLOW_BINDINGS") {
    def * = (clientId, flowId, bindingName) <> (ClientAuthFlowBindingsRow.tupled, ClientAuthFlowBindingsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(clientId), flowId, Rep.Some(bindingName))).shaped.<>({r=>import r._; _1.map(_=> ClientAuthFlowBindingsRow.tupled((_1.get, _2, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column CLIENT_ID SqlType(VARCHAR), Length(36,true) */
    val clientId: Rep[String] = column[String]("CLIENT_ID", O.Length(36,varying=true))
    /** Database column FLOW_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val flowId: Rep[Option[String]] = column[Option[String]]("FLOW_ID", O.Length(36,varying=true), O.Default(None))
    /** Database column BINDING_NAME SqlType(VARCHAR), Length(255,true) */
    val bindingName: Rep[String] = column[String]("BINDING_NAME", O.Length(255,varying=true))

    /** Primary key of ClientAuthFlowBindings (database name CLIENT_AUTH_FLOW_BINDINGS_PK) */
    val pk = primaryKey("CLIENT_AUTH_FLOW_BINDINGS_PK", (clientId, bindingName))
  }
  /** Collection-like TableQuery object for table ClientAuthFlowBindings */
  lazy val ClientAuthFlowBindings = new TableQuery(tag => new ClientAuthFlowBindings(tag))

  /** Entity class storing rows of table ClientInitialAccess
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(36,true)
   *  @param timestamp Database column TIMESTAMP SqlType(INT), Default(None)
   *  @param expiration Database column EXPIRATION SqlType(INT), Default(None)
   *  @param count Database column COUNT SqlType(INT), Default(None)
   *  @param remainingCount Database column REMAINING_COUNT SqlType(INT), Default(None) */
  case class ClientInitialAccessRow(id: String, realmId: String, timestamp: Option[Int] = None, expiration: Option[Int] = None, count: Option[Int] = None, remainingCount: Option[Int] = None)
  /** GetResult implicit for fetching ClientInitialAccessRow objects using plain SQL queries */
  implicit def GetResultClientInitialAccessRow(implicit e0: GR[String], e1: GR[Option[Int]]): GR[ClientInitialAccessRow] = GR{
    prs => import prs._
    ClientInitialAccessRow.tupled((<<[String], <<[String], <<?[Int], <<?[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table CLIENT_INITIAL_ACCESS. Objects of this class serve as prototypes for rows in queries. */
  class ClientInitialAccess(_tableTag: Tag) extends profile.api.Table[ClientInitialAccessRow](_tableTag, Some("chaman"), "CLIENT_INITIAL_ACCESS") {
    def * = (id, realmId, timestamp, expiration, count, remainingCount) <> (ClientInitialAccessRow.tupled, ClientInitialAccessRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(realmId), timestamp, expiration, count, remainingCount)).shaped.<>({r=>import r._; _1.map(_=> ClientInitialAccessRow.tupled((_1.get, _2.get, _3, _4, _5, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column REALM_ID SqlType(VARCHAR), Length(36,true) */
    val realmId: Rep[String] = column[String]("REALM_ID", O.Length(36,varying=true))
    /** Database column TIMESTAMP SqlType(INT), Default(None) */
    val timestamp: Rep[Option[Int]] = column[Option[Int]]("TIMESTAMP", O.Default(None))
    /** Database column EXPIRATION SqlType(INT), Default(None) */
    val expiration: Rep[Option[Int]] = column[Option[Int]]("EXPIRATION", O.Default(None))
    /** Database column COUNT SqlType(INT), Default(None) */
    val count: Rep[Option[Int]] = column[Option[Int]]("COUNT", O.Default(None))
    /** Database column REMAINING_COUNT SqlType(INT), Default(None) */
    val remainingCount: Rep[Option[Int]] = column[Option[Int]]("REMAINING_COUNT", O.Default(None))

    /** Foreign key referencing Realm (database name FK_CLIENT_INIT_ACC_REALM) */
    lazy val realmFk = foreignKey("FK_CLIENT_INIT_ACC_REALM", realmId, Realm)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table ClientInitialAccess */
  lazy val ClientInitialAccess = new TableQuery(tag => new ClientInitialAccess(tag))

  /** Entity class storing rows of table ClientNodeRegistrations
   *  @param clientId Database column CLIENT_ID SqlType(VARCHAR), Length(36,true)
   *  @param value Database column VALUE SqlType(INT), Default(None)
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true) */
  case class ClientNodeRegistrationsRow(clientId: String, value: Option[Int] = None, name: String)
  /** GetResult implicit for fetching ClientNodeRegistrationsRow objects using plain SQL queries */
  implicit def GetResultClientNodeRegistrationsRow(implicit e0: GR[String], e1: GR[Option[Int]]): GR[ClientNodeRegistrationsRow] = GR{
    prs => import prs._
    ClientNodeRegistrationsRow.tupled((<<[String], <<?[Int], <<[String]))
  }
  /** Table description of table CLIENT_NODE_REGISTRATIONS. Objects of this class serve as prototypes for rows in queries. */
  class ClientNodeRegistrations(_tableTag: Tag) extends profile.api.Table[ClientNodeRegistrationsRow](_tableTag, Some("chaman"), "CLIENT_NODE_REGISTRATIONS") {
    def * = (clientId, value, name) <> (ClientNodeRegistrationsRow.tupled, ClientNodeRegistrationsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(clientId), value, Rep.Some(name))).shaped.<>({r=>import r._; _1.map(_=> ClientNodeRegistrationsRow.tupled((_1.get, _2, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column CLIENT_ID SqlType(VARCHAR), Length(36,true) */
    val clientId: Rep[String] = column[String]("CLIENT_ID", O.Length(36,varying=true))
    /** Database column VALUE SqlType(INT), Default(None) */
    val value: Rep[Option[Int]] = column[Option[Int]]("VALUE", O.Default(None))
    /** Database column NAME SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("NAME", O.Length(255,varying=true))

    /** Primary key of ClientNodeRegistrations (database name CLIENT_NODE_REGISTRATIONS_PK) */
    val pk = primaryKey("CLIENT_NODE_REGISTRATIONS_PK", (clientId, name))

    /** Foreign key referencing Client (database name FK4129723BA992F594) */
    lazy val clientFk = foreignKey("FK4129723BA992F594", clientId, Client)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table ClientNodeRegistrations */
  lazy val ClientNodeRegistrations = new TableQuery(tag => new ClientNodeRegistrations(tag))

  /** Entity class storing rows of table ClientScope
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param description Database column DESCRIPTION SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param protocol Database column PROTOCOL SqlType(VARCHAR), Length(255,true), Default(None) */
  case class ClientScopeRow(id: String, name: Option[String] = None, realmId: Option[String] = None, description: Option[String] = None, protocol: Option[String] = None)
  /** GetResult implicit for fetching ClientScopeRow objects using plain SQL queries */
  implicit def GetResultClientScopeRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[ClientScopeRow] = GR{
    prs => import prs._
    ClientScopeRow.tupled((<<[String], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table CLIENT_SCOPE. Objects of this class serve as prototypes for rows in queries. */
  class ClientScope(_tableTag: Tag) extends profile.api.Table[ClientScopeRow](_tableTag, Some("chaman"), "CLIENT_SCOPE") {
    def * = (id, name, realmId, description, protocol) <> (ClientScopeRow.tupled, ClientScopeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), name, realmId, description, protocol)).shaped.<>({r=>import r._; _1.map(_=> ClientScopeRow.tupled((_1.get, _2, _3, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column NAME SqlType(VARCHAR), Length(255,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("NAME", O.Length(255,varying=true), O.Default(None))
    /** Database column REALM_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val realmId: Rep[Option[String]] = column[Option[String]]("REALM_ID", O.Length(36,varying=true), O.Default(None))
    /** Database column DESCRIPTION SqlType(VARCHAR), Length(255,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("DESCRIPTION", O.Length(255,varying=true), O.Default(None))
    /** Database column PROTOCOL SqlType(VARCHAR), Length(255,true), Default(None) */
    val protocol: Rep[Option[String]] = column[Option[String]]("PROTOCOL", O.Length(255,varying=true), O.Default(None))

    /** Index over (realmId) (database name IDX_REALM_CLSCOPE) */
    val index1 = index("IDX_REALM_CLSCOPE", realmId)
    /** Uniqueness Index over (realmId,name) (database name UK_CLI_SCOPE) */
    val index2 = index("UK_CLI_SCOPE", (realmId, name), unique=true)
  }
  /** Collection-like TableQuery object for table ClientScope */
  lazy val ClientScope = new TableQuery(tag => new ClientScope(tag))

  /** Entity class storing rows of table ClientScopeAttributes
   *  @param scopeId Database column SCOPE_ID SqlType(VARCHAR), Length(36,true)
   *  @param value Database column VALUE SqlType(TEXT), Default(None)
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true) */
  case class ClientScopeAttributesRow(scopeId: String, value: Option[String] = None, name: String)
  /** GetResult implicit for fetching ClientScopeAttributesRow objects using plain SQL queries */
  implicit def GetResultClientScopeAttributesRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[ClientScopeAttributesRow] = GR{
    prs => import prs._
    ClientScopeAttributesRow.tupled((<<[String], <<?[String], <<[String]))
  }
  /** Table description of table CLIENT_SCOPE_ATTRIBUTES. Objects of this class serve as prototypes for rows in queries. */
  class ClientScopeAttributes(_tableTag: Tag) extends profile.api.Table[ClientScopeAttributesRow](_tableTag, Some("chaman"), "CLIENT_SCOPE_ATTRIBUTES") {
    def * = (scopeId, value, name) <> (ClientScopeAttributesRow.tupled, ClientScopeAttributesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(scopeId), value, Rep.Some(name))).shaped.<>({r=>import r._; _1.map(_=> ClientScopeAttributesRow.tupled((_1.get, _2, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column SCOPE_ID SqlType(VARCHAR), Length(36,true) */
    val scopeId: Rep[String] = column[String]("SCOPE_ID", O.Length(36,varying=true))
    /** Database column VALUE SqlType(TEXT), Default(None) */
    val value: Rep[Option[String]] = column[Option[String]]("VALUE", O.Default(None))
    /** Database column NAME SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("NAME", O.Length(255,varying=true))

    /** Primary key of ClientScopeAttributes (database name CLIENT_SCOPE_ATTRIBUTES_PK) */
    val pk = primaryKey("CLIENT_SCOPE_ATTRIBUTES_PK", (scopeId, name))

    /** Foreign key referencing ClientScope (database name FK_CL_SCOPE_ATTR_SCOPE) */
    lazy val clientScopeFk = foreignKey("FK_CL_SCOPE_ATTR_SCOPE", scopeId, ClientScope)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table ClientScopeAttributes */
  lazy val ClientScopeAttributes = new TableQuery(tag => new ClientScopeAttributes(tag))

  /** Entity class storing rows of table ClientScopeClient
   *  @param clientId Database column CLIENT_ID SqlType(VARCHAR), Length(255,true)
   *  @param scopeId Database column SCOPE_ID SqlType(VARCHAR), Length(255,true)
   *  @param defaultScope Database column DEFAULT_SCOPE SqlType(BIT), Default(false) */
  case class ClientScopeClientRow(clientId: String, scopeId: String, defaultScope: Boolean = false)
  /** GetResult implicit for fetching ClientScopeClientRow objects using plain SQL queries */
  implicit def GetResultClientScopeClientRow(implicit e0: GR[String], e1: GR[Boolean]): GR[ClientScopeClientRow] = GR{
    prs => import prs._
    ClientScopeClientRow.tupled((<<[String], <<[String], <<[Boolean]))
  }
  /** Table description of table CLIENT_SCOPE_CLIENT. Objects of this class serve as prototypes for rows in queries. */
  class ClientScopeClient(_tableTag: Tag) extends profile.api.Table[ClientScopeClientRow](_tableTag, Some("chaman"), "CLIENT_SCOPE_CLIENT") {
    def * = (clientId, scopeId, defaultScope) <> (ClientScopeClientRow.tupled, ClientScopeClientRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(clientId), Rep.Some(scopeId), Rep.Some(defaultScope))).shaped.<>({r=>import r._; _1.map(_=> ClientScopeClientRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column CLIENT_ID SqlType(VARCHAR), Length(255,true) */
    val clientId: Rep[String] = column[String]("CLIENT_ID", O.Length(255,varying=true))
    /** Database column SCOPE_ID SqlType(VARCHAR), Length(255,true) */
    val scopeId: Rep[String] = column[String]("SCOPE_ID", O.Length(255,varying=true))
    /** Database column DEFAULT_SCOPE SqlType(BIT), Default(false) */
    val defaultScope: Rep[Boolean] = column[Boolean]("DEFAULT_SCOPE", O.Default(false))

    /** Primary key of ClientScopeClient (database name CLIENT_SCOPE_CLIENT_PK) */
    val pk = primaryKey("CLIENT_SCOPE_CLIENT_PK", (clientId, scopeId))

    /** Index over (clientId) (database name IDX_CLSCOPE_CL) */
    val index1 = index("IDX_CLSCOPE_CL", clientId)
    /** Index over (scopeId) (database name IDX_CL_CLSCOPE) */
    val index2 = index("IDX_CL_CLSCOPE", scopeId)
  }
  /** Collection-like TableQuery object for table ClientScopeClient */
  lazy val ClientScopeClient = new TableQuery(tag => new ClientScopeClient(tag))

  /** Entity class storing rows of table ClientScopeRoleMapping
   *  @param scopeId Database column SCOPE_ID SqlType(VARCHAR), Length(36,true)
   *  @param roleId Database column ROLE_ID SqlType(VARCHAR), Length(36,true) */
  case class ClientScopeRoleMappingRow(scopeId: String, roleId: String)
  /** GetResult implicit for fetching ClientScopeRoleMappingRow objects using plain SQL queries */
  implicit def GetResultClientScopeRoleMappingRow(implicit e0: GR[String]): GR[ClientScopeRoleMappingRow] = GR{
    prs => import prs._
    ClientScopeRoleMappingRow.tupled((<<[String], <<[String]))
  }
  /** Table description of table CLIENT_SCOPE_ROLE_MAPPING. Objects of this class serve as prototypes for rows in queries. */
  class ClientScopeRoleMapping(_tableTag: Tag) extends profile.api.Table[ClientScopeRoleMappingRow](_tableTag, Some("chaman"), "CLIENT_SCOPE_ROLE_MAPPING") {
    def * = (scopeId, roleId) <> (ClientScopeRoleMappingRow.tupled, ClientScopeRoleMappingRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(scopeId), Rep.Some(roleId))).shaped.<>({r=>import r._; _1.map(_=> ClientScopeRoleMappingRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column SCOPE_ID SqlType(VARCHAR), Length(36,true) */
    val scopeId: Rep[String] = column[String]("SCOPE_ID", O.Length(36,varying=true))
    /** Database column ROLE_ID SqlType(VARCHAR), Length(36,true) */
    val roleId: Rep[String] = column[String]("ROLE_ID", O.Length(36,varying=true))

    /** Primary key of ClientScopeRoleMapping (database name CLIENT_SCOPE_ROLE_MAPPING_PK) */
    val pk = primaryKey("CLIENT_SCOPE_ROLE_MAPPING_PK", (scopeId, roleId))

    /** Foreign key referencing ClientScope (database name FK_CL_SCOPE_RM_SCOPE) */
    lazy val clientScopeFk = foreignKey("FK_CL_SCOPE_RM_SCOPE", scopeId, ClientScope)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Index over (roleId) (database name IDX_ROLE_CLSCOPE) */
    val index1 = index("IDX_ROLE_CLSCOPE", roleId)
  }
  /** Collection-like TableQuery object for table ClientScopeRoleMapping */
  lazy val ClientScopeRoleMapping = new TableQuery(tag => new ClientScopeRoleMapping(tag))

  /** Entity class storing rows of table ClientSession
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param clientId Database column CLIENT_ID SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param redirectUri Database column REDIRECT_URI SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param state Database column STATE SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param timestamp Database column TIMESTAMP SqlType(INT), Default(None)
   *  @param sessionId Database column SESSION_ID SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param authMethod Database column AUTH_METHOD SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param authUserId Database column AUTH_USER_ID SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param currentAction Database column CURRENT_ACTION SqlType(VARCHAR), Length(36,true), Default(None) */
  case class ClientSessionRow(id: String, clientId: Option[String] = None, redirectUri: Option[String] = None, state: Option[String] = None, timestamp: Option[Int] = None, sessionId: Option[String] = None, authMethod: Option[String] = None, realmId: Option[String] = None, authUserId: Option[String] = None, currentAction: Option[String] = None)
  /** GetResult implicit for fetching ClientSessionRow objects using plain SQL queries */
  implicit def GetResultClientSessionRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Option[Int]]): GR[ClientSessionRow] = GR{
    prs => import prs._
    ClientSessionRow.tupled((<<[String], <<?[String], <<?[String], <<?[String], <<?[Int], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table CLIENT_SESSION. Objects of this class serve as prototypes for rows in queries. */
  class ClientSession(_tableTag: Tag) extends profile.api.Table[ClientSessionRow](_tableTag, Some("chaman"), "CLIENT_SESSION") {
    def * = (id, clientId, redirectUri, state, timestamp, sessionId, authMethod, realmId, authUserId, currentAction) <> (ClientSessionRow.tupled, ClientSessionRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), clientId, redirectUri, state, timestamp, sessionId, authMethod, realmId, authUserId, currentAction)).shaped.<>({r=>import r._; _1.map(_=> ClientSessionRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column CLIENT_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val clientId: Rep[Option[String]] = column[Option[String]]("CLIENT_ID", O.Length(36,varying=true), O.Default(None))
    /** Database column REDIRECT_URI SqlType(VARCHAR), Length(255,true), Default(None) */
    val redirectUri: Rep[Option[String]] = column[Option[String]]("REDIRECT_URI", O.Length(255,varying=true), O.Default(None))
    /** Database column STATE SqlType(VARCHAR), Length(255,true), Default(None) */
    val state: Rep[Option[String]] = column[Option[String]]("STATE", O.Length(255,varying=true), O.Default(None))
    /** Database column TIMESTAMP SqlType(INT), Default(None) */
    val timestamp: Rep[Option[Int]] = column[Option[Int]]("TIMESTAMP", O.Default(None))
    /** Database column SESSION_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val sessionId: Rep[Option[String]] = column[Option[String]]("SESSION_ID", O.Length(36,varying=true), O.Default(None))
    /** Database column AUTH_METHOD SqlType(VARCHAR), Length(255,true), Default(None) */
    val authMethod: Rep[Option[String]] = column[Option[String]]("AUTH_METHOD", O.Length(255,varying=true), O.Default(None))
    /** Database column REALM_ID SqlType(VARCHAR), Length(255,true), Default(None) */
    val realmId: Rep[Option[String]] = column[Option[String]]("REALM_ID", O.Length(255,varying=true), O.Default(None))
    /** Database column AUTH_USER_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val authUserId: Rep[Option[String]] = column[Option[String]]("AUTH_USER_ID", O.Length(36,varying=true), O.Default(None))
    /** Database column CURRENT_ACTION SqlType(VARCHAR), Length(36,true), Default(None) */
    val currentAction: Rep[Option[String]] = column[Option[String]]("CURRENT_ACTION", O.Length(36,varying=true), O.Default(None))

    /** Foreign key referencing UserSession (database name FK_B4AO2VCVAT6UKAU74WBWTFQO1) */
    lazy val userSessionFk = foreignKey("FK_B4AO2VCVAT6UKAU74WBWTFQO1", sessionId, UserSession)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table ClientSession */
  lazy val ClientSession = new TableQuery(tag => new ClientSession(tag))

  /** Entity class storing rows of table ClientSessionAuthStatus
   *  @param authenticator Database column AUTHENTICATOR SqlType(VARCHAR), Length(36,true)
   *  @param status Database column STATUS SqlType(INT), Default(None)
   *  @param clientSession Database column CLIENT_SESSION SqlType(VARCHAR), Length(36,true) */
  case class ClientSessionAuthStatusRow(authenticator: String, status: Option[Int] = None, clientSession: String)
  /** GetResult implicit for fetching ClientSessionAuthStatusRow objects using plain SQL queries */
  implicit def GetResultClientSessionAuthStatusRow(implicit e0: GR[String], e1: GR[Option[Int]]): GR[ClientSessionAuthStatusRow] = GR{
    prs => import prs._
    ClientSessionAuthStatusRow.tupled((<<[String], <<?[Int], <<[String]))
  }
  /** Table description of table CLIENT_SESSION_AUTH_STATUS. Objects of this class serve as prototypes for rows in queries. */
  class ClientSessionAuthStatus(_tableTag: Tag) extends profile.api.Table[ClientSessionAuthStatusRow](_tableTag, Some("chaman"), "CLIENT_SESSION_AUTH_STATUS") {
    def * = (authenticator, status, clientSession) <> (ClientSessionAuthStatusRow.tupled, ClientSessionAuthStatusRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(authenticator), status, Rep.Some(clientSession))).shaped.<>({r=>import r._; _1.map(_=> ClientSessionAuthStatusRow.tupled((_1.get, _2, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AUTHENTICATOR SqlType(VARCHAR), Length(36,true) */
    val authenticator: Rep[String] = column[String]("AUTHENTICATOR", O.Length(36,varying=true))
    /** Database column STATUS SqlType(INT), Default(None) */
    val status: Rep[Option[Int]] = column[Option[Int]]("STATUS", O.Default(None))
    /** Database column CLIENT_SESSION SqlType(VARCHAR), Length(36,true) */
    val clientSession: Rep[String] = column[String]("CLIENT_SESSION", O.Length(36,varying=true))

    /** Primary key of ClientSessionAuthStatus (database name CLIENT_SESSION_AUTH_STATUS_PK) */
    val pk = primaryKey("CLIENT_SESSION_AUTH_STATUS_PK", (clientSession, authenticator))

    /** Foreign key referencing ClientSession (database name AUTH_STATUS_CONSTRAINT) */
    lazy val clientSessionFk = foreignKey("AUTH_STATUS_CONSTRAINT", clientSession, ClientSession)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table ClientSessionAuthStatus */
  lazy val ClientSessionAuthStatus = new TableQuery(tag => new ClientSessionAuthStatus(tag))

  /** Entity class storing rows of table ClientSessionNote
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true)
   *  @param value Database column VALUE SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param clientSession Database column CLIENT_SESSION SqlType(VARCHAR), Length(36,true) */
  case class ClientSessionNoteRow(name: String, value: Option[String] = None, clientSession: String)
  /** GetResult implicit for fetching ClientSessionNoteRow objects using plain SQL queries */
  implicit def GetResultClientSessionNoteRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[ClientSessionNoteRow] = GR{
    prs => import prs._
    ClientSessionNoteRow.tupled((<<[String], <<?[String], <<[String]))
  }
  /** Table description of table CLIENT_SESSION_NOTE. Objects of this class serve as prototypes for rows in queries. */
  class ClientSessionNote(_tableTag: Tag) extends profile.api.Table[ClientSessionNoteRow](_tableTag, Some("chaman"), "CLIENT_SESSION_NOTE") {
    def * = (name, value, clientSession) <> (ClientSessionNoteRow.tupled, ClientSessionNoteRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(name), value, Rep.Some(clientSession))).shaped.<>({r=>import r._; _1.map(_=> ClientSessionNoteRow.tupled((_1.get, _2, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column NAME SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("NAME", O.Length(255,varying=true))
    /** Database column VALUE SqlType(VARCHAR), Length(255,true), Default(None) */
    val value: Rep[Option[String]] = column[Option[String]]("VALUE", O.Length(255,varying=true), O.Default(None))
    /** Database column CLIENT_SESSION SqlType(VARCHAR), Length(36,true) */
    val clientSession: Rep[String] = column[String]("CLIENT_SESSION", O.Length(36,varying=true))

    /** Primary key of ClientSessionNote (database name CLIENT_SESSION_NOTE_PK) */
    val pk = primaryKey("CLIENT_SESSION_NOTE_PK", (clientSession, name))

    /** Foreign key referencing ClientSession (database name FK5EDFB00FF51C2736) */
    lazy val clientSessionFk = foreignKey("FK5EDFB00FF51C2736", clientSession, ClientSession)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table ClientSessionNote */
  lazy val ClientSessionNote = new TableQuery(tag => new ClientSessionNote(tag))

  /** Entity class storing rows of table ClientSessionProtMapper
   *  @param protocolMapperId Database column PROTOCOL_MAPPER_ID SqlType(VARCHAR), Length(36,true)
   *  @param clientSession Database column CLIENT_SESSION SqlType(VARCHAR), Length(36,true) */
  case class ClientSessionProtMapperRow(protocolMapperId: String, clientSession: String)
  /** GetResult implicit for fetching ClientSessionProtMapperRow objects using plain SQL queries */
  implicit def GetResultClientSessionProtMapperRow(implicit e0: GR[String]): GR[ClientSessionProtMapperRow] = GR{
    prs => import prs._
    ClientSessionProtMapperRow.tupled((<<[String], <<[String]))
  }
  /** Table description of table CLIENT_SESSION_PROT_MAPPER. Objects of this class serve as prototypes for rows in queries. */
  class ClientSessionProtMapper(_tableTag: Tag) extends profile.api.Table[ClientSessionProtMapperRow](_tableTag, Some("chaman"), "CLIENT_SESSION_PROT_MAPPER") {
    def * = (protocolMapperId, clientSession) <> (ClientSessionProtMapperRow.tupled, ClientSessionProtMapperRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(protocolMapperId), Rep.Some(clientSession))).shaped.<>({r=>import r._; _1.map(_=> ClientSessionProtMapperRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column PROTOCOL_MAPPER_ID SqlType(VARCHAR), Length(36,true) */
    val protocolMapperId: Rep[String] = column[String]("PROTOCOL_MAPPER_ID", O.Length(36,varying=true))
    /** Database column CLIENT_SESSION SqlType(VARCHAR), Length(36,true) */
    val clientSession: Rep[String] = column[String]("CLIENT_SESSION", O.Length(36,varying=true))

    /** Primary key of ClientSessionProtMapper (database name CLIENT_SESSION_PROT_MAPPER_PK) */
    val pk = primaryKey("CLIENT_SESSION_PROT_MAPPER_PK", (clientSession, protocolMapperId))

    /** Foreign key referencing ClientSession (database name FK_33A8SGQW18I532811V7O2DK89) */
    lazy val clientSessionFk = foreignKey("FK_33A8SGQW18I532811V7O2DK89", clientSession, ClientSession)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table ClientSessionProtMapper */
  lazy val ClientSessionProtMapper = new TableQuery(tag => new ClientSessionProtMapper(tag))

  /** Entity class storing rows of table ClientSessionRole
   *  @param roleId Database column ROLE_ID SqlType(VARCHAR), Length(255,true)
   *  @param clientSession Database column CLIENT_SESSION SqlType(VARCHAR), Length(36,true) */
  case class ClientSessionRoleRow(roleId: String, clientSession: String)
  /** GetResult implicit for fetching ClientSessionRoleRow objects using plain SQL queries */
  implicit def GetResultClientSessionRoleRow(implicit e0: GR[String]): GR[ClientSessionRoleRow] = GR{
    prs => import prs._
    ClientSessionRoleRow.tupled((<<[String], <<[String]))
  }
  /** Table description of table CLIENT_SESSION_ROLE. Objects of this class serve as prototypes for rows in queries. */
  class ClientSessionRole(_tableTag: Tag) extends profile.api.Table[ClientSessionRoleRow](_tableTag, Some("chaman"), "CLIENT_SESSION_ROLE") {
    def * = (roleId, clientSession) <> (ClientSessionRoleRow.tupled, ClientSessionRoleRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(roleId), Rep.Some(clientSession))).shaped.<>({r=>import r._; _1.map(_=> ClientSessionRoleRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ROLE_ID SqlType(VARCHAR), Length(255,true) */
    val roleId: Rep[String] = column[String]("ROLE_ID", O.Length(255,varying=true))
    /** Database column CLIENT_SESSION SqlType(VARCHAR), Length(36,true) */
    val clientSession: Rep[String] = column[String]("CLIENT_SESSION", O.Length(36,varying=true))

    /** Primary key of ClientSessionRole (database name CLIENT_SESSION_ROLE_PK) */
    val pk = primaryKey("CLIENT_SESSION_ROLE_PK", (clientSession, roleId))

    /** Foreign key referencing ClientSession (database name FK_11B7SGQW18I532811V7O2DV76) */
    lazy val clientSessionFk = foreignKey("FK_11B7SGQW18I532811V7O2DV76", clientSession, ClientSession)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table ClientSessionRole */
  lazy val ClientSessionRole = new TableQuery(tag => new ClientSessionRole(tag))

  /** Entity class storing rows of table ClientUserSessionNote
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true)
   *  @param value Database column VALUE SqlType(TEXT), Default(None)
   *  @param clientSession Database column CLIENT_SESSION SqlType(VARCHAR), Length(36,true) */
  case class ClientUserSessionNoteRow(name: String, value: Option[String] = None, clientSession: String)
  /** GetResult implicit for fetching ClientUserSessionNoteRow objects using plain SQL queries */
  implicit def GetResultClientUserSessionNoteRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[ClientUserSessionNoteRow] = GR{
    prs => import prs._
    ClientUserSessionNoteRow.tupled((<<[String], <<?[String], <<[String]))
  }
  /** Table description of table CLIENT_USER_SESSION_NOTE. Objects of this class serve as prototypes for rows in queries. */
  class ClientUserSessionNote(_tableTag: Tag) extends profile.api.Table[ClientUserSessionNoteRow](_tableTag, Some("chaman"), "CLIENT_USER_SESSION_NOTE") {
    def * = (name, value, clientSession) <> (ClientUserSessionNoteRow.tupled, ClientUserSessionNoteRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(name), value, Rep.Some(clientSession))).shaped.<>({r=>import r._; _1.map(_=> ClientUserSessionNoteRow.tupled((_1.get, _2, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column NAME SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("NAME", O.Length(255,varying=true))
    /** Database column VALUE SqlType(TEXT), Default(None) */
    val value: Rep[Option[String]] = column[Option[String]]("VALUE", O.Default(None))
    /** Database column CLIENT_SESSION SqlType(VARCHAR), Length(36,true) */
    val clientSession: Rep[String] = column[String]("CLIENT_SESSION", O.Length(36,varying=true))

    /** Primary key of ClientUserSessionNote (database name CLIENT_USER_SESSION_NOTE_PK) */
    val pk = primaryKey("CLIENT_USER_SESSION_NOTE_PK", (clientSession, name))

    /** Foreign key referencing ClientSession (database name FK_CL_USR_SES_NOTE) */
    lazy val clientSessionFk = foreignKey("FK_CL_USR_SES_NOTE", clientSession, ClientSession)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table ClientUserSessionNote */
  lazy val ClientUserSessionNote = new TableQuery(tag => new ClientUserSessionNote(tag))

  /** Entity class storing rows of table Component
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param parentId Database column PARENT_ID SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param providerId Database column PROVIDER_ID SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param providerType Database column PROVIDER_TYPE SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param subType Database column SUB_TYPE SqlType(VARCHAR), Length(255,true), Default(None) */
  case class ComponentRow(id: String, name: Option[String] = None, parentId: Option[String] = None, providerId: Option[String] = None, providerType: Option[String] = None, realmId: Option[String] = None, subType: Option[String] = None)
  /** GetResult implicit for fetching ComponentRow objects using plain SQL queries */
  implicit def GetResultComponentRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[ComponentRow] = GR{
    prs => import prs._
    ComponentRow.tupled((<<[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table COMPONENT. Objects of this class serve as prototypes for rows in queries. */
  class Component(_tableTag: Tag) extends profile.api.Table[ComponentRow](_tableTag, Some("chaman"), "COMPONENT") {
    def * = (id, name, parentId, providerId, providerType, realmId, subType) <> (ComponentRow.tupled, ComponentRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), name, parentId, providerId, providerType, realmId, subType)).shaped.<>({r=>import r._; _1.map(_=> ComponentRow.tupled((_1.get, _2, _3, _4, _5, _6, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column NAME SqlType(VARCHAR), Length(255,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("NAME", O.Length(255,varying=true), O.Default(None))
    /** Database column PARENT_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val parentId: Rep[Option[String]] = column[Option[String]]("PARENT_ID", O.Length(36,varying=true), O.Default(None))
    /** Database column PROVIDER_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val providerId: Rep[Option[String]] = column[Option[String]]("PROVIDER_ID", O.Length(36,varying=true), O.Default(None))
    /** Database column PROVIDER_TYPE SqlType(VARCHAR), Length(255,true), Default(None) */
    val providerType: Rep[Option[String]] = column[Option[String]]("PROVIDER_TYPE", O.Length(255,varying=true), O.Default(None))
    /** Database column REALM_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val realmId: Rep[Option[String]] = column[Option[String]]("REALM_ID", O.Length(36,varying=true), O.Default(None))
    /** Database column SUB_TYPE SqlType(VARCHAR), Length(255,true), Default(None) */
    val subType: Rep[Option[String]] = column[Option[String]]("SUB_TYPE", O.Length(255,varying=true), O.Default(None))

    /** Foreign key referencing Realm (database name FK_COMPONENT_REALM) */
    lazy val realmFk = foreignKey("FK_COMPONENT_REALM", realmId, Realm)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Index over (providerType) (database name IDX_COMPONENT_PROVIDER_TYPE) */
    val index1 = index("IDX_COMPONENT_PROVIDER_TYPE", providerType)
  }
  /** Collection-like TableQuery object for table Component */
  lazy val Component = new TableQuery(tag => new Component(tag))

  /** Entity class storing rows of table ComponentConfig
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param componentId Database column COMPONENT_ID SqlType(VARCHAR), Length(36,true)
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true)
   *  @param value Database column VALUE SqlType(VARCHAR), Length(4000,true), Default(None) */
  case class ComponentConfigRow(id: String, componentId: String, name: String, value: Option[String] = None)
  /** GetResult implicit for fetching ComponentConfigRow objects using plain SQL queries */
  implicit def GetResultComponentConfigRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[ComponentConfigRow] = GR{
    prs => import prs._
    ComponentConfigRow.tupled((<<[String], <<[String], <<[String], <<?[String]))
  }
  /** Table description of table COMPONENT_CONFIG. Objects of this class serve as prototypes for rows in queries. */
  class ComponentConfig(_tableTag: Tag) extends profile.api.Table[ComponentConfigRow](_tableTag, Some("chaman"), "COMPONENT_CONFIG") {
    def * = (id, componentId, name, value) <> (ComponentConfigRow.tupled, ComponentConfigRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(componentId), Rep.Some(name), value)).shaped.<>({r=>import r._; _1.map(_=> ComponentConfigRow.tupled((_1.get, _2.get, _3.get, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column COMPONENT_ID SqlType(VARCHAR), Length(36,true) */
    val componentId: Rep[String] = column[String]("COMPONENT_ID", O.Length(36,varying=true))
    /** Database column NAME SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("NAME", O.Length(255,varying=true))
    /** Database column VALUE SqlType(VARCHAR), Length(4000,true), Default(None) */
    val value: Rep[Option[String]] = column[Option[String]]("VALUE", O.Length(4000,varying=true), O.Default(None))

    /** Foreign key referencing Component (database name FK_COMPONENT_CONFIG) */
    lazy val componentFk = foreignKey("FK_COMPONENT_CONFIG", componentId, Component)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table ComponentConfig */
  lazy val ComponentConfig = new TableQuery(tag => new ComponentConfig(tag))

  /** Entity class storing rows of table CompositeRole
   *  @param composite Database column COMPOSITE SqlType(VARCHAR), Length(36,true)
   *  @param childRole Database column CHILD_ROLE SqlType(VARCHAR), Length(36,true) */
  case class CompositeRoleRow(composite: String, childRole: String)
  /** GetResult implicit for fetching CompositeRoleRow objects using plain SQL queries */
  implicit def GetResultCompositeRoleRow(implicit e0: GR[String]): GR[CompositeRoleRow] = GR{
    prs => import prs._
    CompositeRoleRow.tupled((<<[String], <<[String]))
  }
  /** Table description of table COMPOSITE_ROLE. Objects of this class serve as prototypes for rows in queries. */
  class CompositeRole(_tableTag: Tag) extends profile.api.Table[CompositeRoleRow](_tableTag, Some("chaman"), "COMPOSITE_ROLE") {
    def * = (composite, childRole) <> (CompositeRoleRow.tupled, CompositeRoleRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(composite), Rep.Some(childRole))).shaped.<>({r=>import r._; _1.map(_=> CompositeRoleRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column COMPOSITE SqlType(VARCHAR), Length(36,true) */
    val composite: Rep[String] = column[String]("COMPOSITE", O.Length(36,varying=true))
    /** Database column CHILD_ROLE SqlType(VARCHAR), Length(36,true) */
    val childRole: Rep[String] = column[String]("CHILD_ROLE", O.Length(36,varying=true))

    /** Primary key of CompositeRole (database name COMPOSITE_ROLE_PK) */
    val pk = primaryKey("COMPOSITE_ROLE_PK", (composite, childRole))

    /** Foreign key referencing KeycloakRole (database name FK_A63WVEKFTU8JO1PNJ81E7MCE2) */
    lazy val keycloakRoleFk1 = foreignKey("FK_A63WVEKFTU8JO1PNJ81E7MCE2", composite, KeycloakRole)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing KeycloakRole (database name FK_GR7THLLB9LU8Q4VQA4524JJY8) */
    lazy val keycloakRoleFk2 = foreignKey("FK_GR7THLLB9LU8Q4VQA4524JJY8", childRole, KeycloakRole)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table CompositeRole */
  lazy val CompositeRole = new TableQuery(tag => new CompositeRole(tag))

  /** Entity class storing rows of table Credential
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param salt Database column SALT SqlType(TINYBLOB), Default(None)
   *  @param `type` Database column TYPE SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param userId Database column USER_ID SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param createdDate Database column CREATED_DATE SqlType(BIGINT), Default(None)
   *  @param userLabel Database column USER_LABEL SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param secretData Database column SECRET_DATA SqlType(LONGTEXT), Length(2147483647,true), Default(None)
   *  @param credentialData Database column CREDENTIAL_DATA SqlType(LONGTEXT), Length(2147483647,true), Default(None)
   *  @param priority Database column PRIORITY SqlType(INT), Default(None) */
  case class CredentialRow(id: String, salt: Option[java.sql.Blob] = None, `type`: Option[String] = None, userId: Option[String] = None, createdDate: Option[Long] = None, userLabel: Option[String] = None, secretData: Option[String] = None, credentialData: Option[String] = None, priority: Option[Int] = None)
  /** GetResult implicit for fetching CredentialRow objects using plain SQL queries */
  implicit def GetResultCredentialRow(implicit e0: GR[String], e1: GR[Option[java.sql.Blob]], e2: GR[Option[String]], e3: GR[Option[Long]], e4: GR[Option[Int]]): GR[CredentialRow] = GR{
    prs => import prs._
    CredentialRow.tupled((<<[String], <<?[java.sql.Blob], <<?[String], <<?[String], <<?[Long], <<?[String], <<?[String], <<?[String], <<?[Int]))
  }
  /** Table description of table CREDENTIAL. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class Credential(_tableTag: Tag) extends profile.api.Table[CredentialRow](_tableTag, Some("chaman"), "CREDENTIAL") {
    def * = (id, salt, `type`, userId, createdDate, userLabel, secretData, credentialData, priority) <> (CredentialRow.tupled, CredentialRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), salt, `type`, userId, createdDate, userLabel, secretData, credentialData, priority)).shaped.<>({r=>import r._; _1.map(_=> CredentialRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column SALT SqlType(TINYBLOB), Default(None) */
    val salt: Rep[Option[java.sql.Blob]] = column[Option[java.sql.Blob]]("SALT", O.Default(None))
    /** Database column TYPE SqlType(VARCHAR), Length(255,true), Default(None)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[Option[String]] = column[Option[String]]("TYPE", O.Length(255,varying=true), O.Default(None))
    /** Database column USER_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val userId: Rep[Option[String]] = column[Option[String]]("USER_ID", O.Length(36,varying=true), O.Default(None))
    /** Database column CREATED_DATE SqlType(BIGINT), Default(None) */
    val createdDate: Rep[Option[Long]] = column[Option[Long]]("CREATED_DATE", O.Default(None))
    /** Database column USER_LABEL SqlType(VARCHAR), Length(255,true), Default(None) */
    val userLabel: Rep[Option[String]] = column[Option[String]]("USER_LABEL", O.Length(255,varying=true), O.Default(None))
    /** Database column SECRET_DATA SqlType(LONGTEXT), Length(2147483647,true), Default(None) */
    val secretData: Rep[Option[String]] = column[Option[String]]("SECRET_DATA", O.Length(2147483647,varying=true), O.Default(None))
    /** Database column CREDENTIAL_DATA SqlType(LONGTEXT), Length(2147483647,true), Default(None) */
    val credentialData: Rep[Option[String]] = column[Option[String]]("CREDENTIAL_DATA", O.Length(2147483647,varying=true), O.Default(None))
    /** Database column PRIORITY SqlType(INT), Default(None) */
    val priority: Rep[Option[Int]] = column[Option[Int]]("PRIORITY", O.Default(None))

    /** Foreign key referencing UserEntity (database name FK_PFYR0GLASQYL0DEI3KL69R6V0) */
    lazy val userEntityFk = foreignKey("FK_PFYR0GLASQYL0DEI3KL69R6V0", userId, UserEntity)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Credential */
  lazy val Credential = new TableQuery(tag => new Credential(tag))

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

  /** Entity class storing rows of table Databasechangelog
   *  @param id Database column ID SqlType(VARCHAR), Length(255,true)
   *  @param author Database column AUTHOR SqlType(VARCHAR), Length(255,true)
   *  @param filename Database column FILENAME SqlType(VARCHAR), Length(255,true)
   *  @param dateexecuted Database column DATEEXECUTED SqlType(DATETIME)
   *  @param orderexecuted Database column ORDEREXECUTED SqlType(INT)
   *  @param exectype Database column EXECTYPE SqlType(VARCHAR), Length(10,true)
   *  @param md5sum Database column MD5SUM SqlType(VARCHAR), Length(35,true), Default(None)
   *  @param description Database column DESCRIPTION SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param comments Database column COMMENTS SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param tag Database column TAG SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param liquibase Database column LIQUIBASE SqlType(VARCHAR), Length(20,true), Default(None)
   *  @param contexts Database column CONTEXTS SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param labels Database column LABELS SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param deploymentId Database column DEPLOYMENT_ID SqlType(VARCHAR), Length(10,true), Default(None) */
  case class DatabasechangelogRow(id: String, author: String, filename: String, dateexecuted: java.sql.Timestamp, orderexecuted: Int, exectype: String, md5sum: Option[String] = None, description: Option[String] = None, comments: Option[String] = None, tag: Option[String] = None, liquibase: Option[String] = None, contexts: Option[String] = None, labels: Option[String] = None, deploymentId: Option[String] = None)
  /** GetResult implicit for fetching DatabasechangelogRow objects using plain SQL queries */
  implicit def GetResultDatabasechangelogRow(implicit e0: GR[String], e1: GR[java.sql.Timestamp], e2: GR[Int], e3: GR[Option[String]]): GR[DatabasechangelogRow] = GR{
    prs => import prs._
    DatabasechangelogRow.tupled((<<[String], <<[String], <<[String], <<[java.sql.Timestamp], <<[Int], <<[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table DATABASECHANGELOG. Objects of this class serve as prototypes for rows in queries. */
  class Databasechangelog(_tableTag: Tag) extends profile.api.Table[DatabasechangelogRow](_tableTag, Some("chaman"), "DATABASECHANGELOG") {
    def * = (id, author, filename, dateexecuted, orderexecuted, exectype, md5sum, description, comments, tag, liquibase, contexts, labels, deploymentId) <> (DatabasechangelogRow.tupled, DatabasechangelogRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(author), Rep.Some(filename), Rep.Some(dateexecuted), Rep.Some(orderexecuted), Rep.Some(exectype), md5sum, description, comments, tag, liquibase, contexts, labels, deploymentId)).shaped.<>({r=>import r._; _1.map(_=> DatabasechangelogRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7, _8, _9, _10, _11, _12, _13, _14)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), Length(255,true) */
    val id: Rep[String] = column[String]("ID", O.Length(255,varying=true))
    /** Database column AUTHOR SqlType(VARCHAR), Length(255,true) */
    val author: Rep[String] = column[String]("AUTHOR", O.Length(255,varying=true))
    /** Database column FILENAME SqlType(VARCHAR), Length(255,true) */
    val filename: Rep[String] = column[String]("FILENAME", O.Length(255,varying=true))
    /** Database column DATEEXECUTED SqlType(DATETIME) */
    val dateexecuted: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("DATEEXECUTED")
    /** Database column ORDEREXECUTED SqlType(INT) */
    val orderexecuted: Rep[Int] = column[Int]("ORDEREXECUTED")
    /** Database column EXECTYPE SqlType(VARCHAR), Length(10,true) */
    val exectype: Rep[String] = column[String]("EXECTYPE", O.Length(10,varying=true))
    /** Database column MD5SUM SqlType(VARCHAR), Length(35,true), Default(None) */
    val md5sum: Rep[Option[String]] = column[Option[String]]("MD5SUM", O.Length(35,varying=true), O.Default(None))
    /** Database column DESCRIPTION SqlType(VARCHAR), Length(255,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("DESCRIPTION", O.Length(255,varying=true), O.Default(None))
    /** Database column COMMENTS SqlType(VARCHAR), Length(255,true), Default(None) */
    val comments: Rep[Option[String]] = column[Option[String]]("COMMENTS", O.Length(255,varying=true), O.Default(None))
    /** Database column TAG SqlType(VARCHAR), Length(255,true), Default(None) */
    val tag: Rep[Option[String]] = column[Option[String]]("TAG", O.Length(255,varying=true), O.Default(None))
    /** Database column LIQUIBASE SqlType(VARCHAR), Length(20,true), Default(None) */
    val liquibase: Rep[Option[String]] = column[Option[String]]("LIQUIBASE", O.Length(20,varying=true), O.Default(None))
    /** Database column CONTEXTS SqlType(VARCHAR), Length(255,true), Default(None) */
    val contexts: Rep[Option[String]] = column[Option[String]]("CONTEXTS", O.Length(255,varying=true), O.Default(None))
    /** Database column LABELS SqlType(VARCHAR), Length(255,true), Default(None) */
    val labels: Rep[Option[String]] = column[Option[String]]("LABELS", O.Length(255,varying=true), O.Default(None))
    /** Database column DEPLOYMENT_ID SqlType(VARCHAR), Length(10,true), Default(None) */
    val deploymentId: Rep[Option[String]] = column[Option[String]]("DEPLOYMENT_ID", O.Length(10,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Databasechangelog */
  lazy val Databasechangelog = new TableQuery(tag => new Databasechangelog(tag))

  /** Entity class storing rows of table Databasechangeloglock
   *  @param id Database column ID SqlType(INT), PrimaryKey
   *  @param locked Database column LOCKED SqlType(BIT)
   *  @param lockgranted Database column LOCKGRANTED SqlType(DATETIME), Default(None)
   *  @param lockedby Database column LOCKEDBY SqlType(VARCHAR), Length(255,true), Default(None) */
  case class DatabasechangeloglockRow(id: Int, locked: Boolean, lockgranted: Option[java.sql.Timestamp] = None, lockedby: Option[String] = None)
  /** GetResult implicit for fetching DatabasechangeloglockRow objects using plain SQL queries */
  implicit def GetResultDatabasechangeloglockRow(implicit e0: GR[Int], e1: GR[Boolean], e2: GR[Option[java.sql.Timestamp]], e3: GR[Option[String]]): GR[DatabasechangeloglockRow] = GR{
    prs => import prs._
    DatabasechangeloglockRow.tupled((<<[Int], <<[Boolean], <<?[java.sql.Timestamp], <<?[String]))
  }
  /** Table description of table DATABASECHANGELOGLOCK. Objects of this class serve as prototypes for rows in queries. */
  class Databasechangeloglock(_tableTag: Tag) extends profile.api.Table[DatabasechangeloglockRow](_tableTag, Some("chaman"), "DATABASECHANGELOGLOCK") {
    def * = (id, locked, lockgranted, lockedby) <> (DatabasechangeloglockRow.tupled, DatabasechangeloglockRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(locked), lockgranted, lockedby)).shaped.<>({r=>import r._; _1.map(_=> DatabasechangeloglockRow.tupled((_1.get, _2.get, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(INT), PrimaryKey */
    val id: Rep[Int] = column[Int]("ID", O.PrimaryKey)
    /** Database column LOCKED SqlType(BIT) */
    val locked: Rep[Boolean] = column[Boolean]("LOCKED")
    /** Database column LOCKGRANTED SqlType(DATETIME), Default(None) */
    val lockgranted: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("LOCKGRANTED", O.Default(None))
    /** Database column LOCKEDBY SqlType(VARCHAR), Length(255,true), Default(None) */
    val lockedby: Rep[Option[String]] = column[Option[String]]("LOCKEDBY", O.Length(255,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Databasechangeloglock */
  lazy val Databasechangeloglock = new TableQuery(tag => new Databasechangeloglock(tag))

  /** Entity class storing rows of table DataDeleted
   *  @param fkFieldDataId Database column fk_field_data_id SqlType(BIGINT), PrimaryKey
   *  @param author Database column author SqlType(VARCHAR), Length(36,true)
   *  @param timestamp Database column timestamp SqlType(TIMESTAMP) */
  case class DataDeletedRow(fkFieldDataId: Long, author: String, timestamp: java.sql.Timestamp)
  /** GetResult implicit for fetching DataDeletedRow objects using plain SQL queries */
  implicit def GetResultDataDeletedRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[DataDeletedRow] = GR{
    prs => import prs._
    DataDeletedRow.tupled((<<[Long], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table data_deleted. Objects of this class serve as prototypes for rows in queries. */
  class DataDeleted(_tableTag: Tag) extends profile.api.Table[DataDeletedRow](_tableTag, Some("chaman"), "data_deleted") {
    def * = (fkFieldDataId, author, timestamp) <> (DataDeletedRow.tupled, DataDeletedRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(fkFieldDataId), Rep.Some(author), Rep.Some(timestamp))).shaped.<>({r=>import r._; _1.map(_=> DataDeletedRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column fk_field_data_id SqlType(BIGINT), PrimaryKey */
    val fkFieldDataId: Rep[Long] = column[Long]("fk_field_data_id", O.PrimaryKey)
    /** Database column author SqlType(VARCHAR), Length(36,true) */
    val author: Rep[String] = column[String]("author", O.Length(36,varying=true))
    /** Database column timestamp SqlType(TIMESTAMP) */
    val timestamp: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("timestamp")
  }
  /** Collection-like TableQuery object for table DataDeleted */
  lazy val DataDeleted = new TableQuery(tag => new DataDeleted(tag))

  /** Entity class storing rows of table DefaultClientScope
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(36,true)
   *  @param scopeId Database column SCOPE_ID SqlType(VARCHAR), Length(36,true)
   *  @param defaultScope Database column DEFAULT_SCOPE SqlType(BIT), Default(false) */
  case class DefaultClientScopeRow(realmId: String, scopeId: String, defaultScope: Boolean = false)
  /** GetResult implicit for fetching DefaultClientScopeRow objects using plain SQL queries */
  implicit def GetResultDefaultClientScopeRow(implicit e0: GR[String], e1: GR[Boolean]): GR[DefaultClientScopeRow] = GR{
    prs => import prs._
    DefaultClientScopeRow.tupled((<<[String], <<[String], <<[Boolean]))
  }
  /** Table description of table DEFAULT_CLIENT_SCOPE. Objects of this class serve as prototypes for rows in queries. */
  class DefaultClientScope(_tableTag: Tag) extends profile.api.Table[DefaultClientScopeRow](_tableTag, Some("chaman"), "DEFAULT_CLIENT_SCOPE") {
    def * = (realmId, scopeId, defaultScope) <> (DefaultClientScopeRow.tupled, DefaultClientScopeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(realmId), Rep.Some(scopeId), Rep.Some(defaultScope))).shaped.<>({r=>import r._; _1.map(_=> DefaultClientScopeRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column REALM_ID SqlType(VARCHAR), Length(36,true) */
    val realmId: Rep[String] = column[String]("REALM_ID", O.Length(36,varying=true))
    /** Database column SCOPE_ID SqlType(VARCHAR), Length(36,true) */
    val scopeId: Rep[String] = column[String]("SCOPE_ID", O.Length(36,varying=true))
    /** Database column DEFAULT_SCOPE SqlType(BIT), Default(false) */
    val defaultScope: Rep[Boolean] = column[Boolean]("DEFAULT_SCOPE", O.Default(false))

    /** Primary key of DefaultClientScope (database name DEFAULT_CLIENT_SCOPE_PK) */
    val pk = primaryKey("DEFAULT_CLIENT_SCOPE_PK", (realmId, scopeId))

    /** Foreign key referencing Realm (database name FK_R_DEF_CLI_SCOPE_REALM) */
    lazy val realmFk = foreignKey("FK_R_DEF_CLI_SCOPE_REALM", realmId, Realm)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Index over (scopeId) (database name IDX_DEFCLS_SCOPE) */
    val index1 = index("IDX_DEFCLS_SCOPE", scopeId)
  }
  /** Collection-like TableQuery object for table DefaultClientScope */
  lazy val DefaultClientScope = new TableQuery(tag => new DefaultClientScope(tag))

  /** Entity class storing rows of table EventEntity
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param clientId Database column CLIENT_ID SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param detailsJson Database column DETAILS_JSON SqlType(TEXT), Default(None)
   *  @param error Database column ERROR SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param ipAddress Database column IP_ADDRESS SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param sessionId Database column SESSION_ID SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param eventTime Database column EVENT_TIME SqlType(BIGINT), Default(None)
   *  @param `type` Database column TYPE SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param userId Database column USER_ID SqlType(VARCHAR), Length(255,true), Default(None) */
  case class EventEntityRow(id: String, clientId: Option[String] = None, detailsJson: Option[String] = None, error: Option[String] = None, ipAddress: Option[String] = None, realmId: Option[String] = None, sessionId: Option[String] = None, eventTime: Option[Long] = None, `type`: Option[String] = None, userId: Option[String] = None)
  /** GetResult implicit for fetching EventEntityRow objects using plain SQL queries */
  implicit def GetResultEventEntityRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Option[Long]]): GR[EventEntityRow] = GR{
    prs => import prs._
    EventEntityRow.tupled((<<[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Long], <<?[String], <<?[String]))
  }
  /** Table description of table EVENT_ENTITY. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class EventEntity(_tableTag: Tag) extends profile.api.Table[EventEntityRow](_tableTag, Some("chaman"), "EVENT_ENTITY") {
    def * = (id, clientId, detailsJson, error, ipAddress, realmId, sessionId, eventTime, `type`, userId) <> (EventEntityRow.tupled, EventEntityRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), clientId, detailsJson, error, ipAddress, realmId, sessionId, eventTime, `type`, userId)).shaped.<>({r=>import r._; _1.map(_=> EventEntityRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column CLIENT_ID SqlType(VARCHAR), Length(255,true), Default(None) */
    val clientId: Rep[Option[String]] = column[Option[String]]("CLIENT_ID", O.Length(255,varying=true), O.Default(None))
    /** Database column DETAILS_JSON SqlType(TEXT), Default(None) */
    val detailsJson: Rep[Option[String]] = column[Option[String]]("DETAILS_JSON", O.Default(None))
    /** Database column ERROR SqlType(VARCHAR), Length(255,true), Default(None) */
    val error: Rep[Option[String]] = column[Option[String]]("ERROR", O.Length(255,varying=true), O.Default(None))
    /** Database column IP_ADDRESS SqlType(VARCHAR), Length(255,true), Default(None) */
    val ipAddress: Rep[Option[String]] = column[Option[String]]("IP_ADDRESS", O.Length(255,varying=true), O.Default(None))
    /** Database column REALM_ID SqlType(VARCHAR), Length(255,true), Default(None) */
    val realmId: Rep[Option[String]] = column[Option[String]]("REALM_ID", O.Length(255,varying=true), O.Default(None))
    /** Database column SESSION_ID SqlType(VARCHAR), Length(255,true), Default(None) */
    val sessionId: Rep[Option[String]] = column[Option[String]]("SESSION_ID", O.Length(255,varying=true), O.Default(None))
    /** Database column EVENT_TIME SqlType(BIGINT), Default(None) */
    val eventTime: Rep[Option[Long]] = column[Option[Long]]("EVENT_TIME", O.Default(None))
    /** Database column TYPE SqlType(VARCHAR), Length(255,true), Default(None)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[Option[String]] = column[Option[String]]("TYPE", O.Length(255,varying=true), O.Default(None))
    /** Database column USER_ID SqlType(VARCHAR), Length(255,true), Default(None) */
    val userId: Rep[Option[String]] = column[Option[String]]("USER_ID", O.Length(255,varying=true), O.Default(None))

    /** Index over (realmId,eventTime) (database name IDX_EVENT_TIME) */
    val index1 = index("IDX_EVENT_TIME", (realmId, eventTime))
  }
  /** Collection-like TableQuery object for table EventEntity */
  lazy val EventEntity = new TableQuery(tag => new EventEntity(tag))

  /** Entity class storing rows of table FederatedIdentity
   *  @param identityProvider Database column IDENTITY_PROVIDER SqlType(VARCHAR), Length(255,true)
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param federatedUserId Database column FEDERATED_USER_ID SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param federatedUsername Database column FEDERATED_USERNAME SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param token Database column TOKEN SqlType(TEXT), Default(None)
   *  @param userId Database column USER_ID SqlType(VARCHAR), Length(36,true) */
  case class FederatedIdentityRow(identityProvider: String, realmId: Option[String] = None, federatedUserId: Option[String] = None, federatedUsername: Option[String] = None, token: Option[String] = None, userId: String)
  /** GetResult implicit for fetching FederatedIdentityRow objects using plain SQL queries */
  implicit def GetResultFederatedIdentityRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[FederatedIdentityRow] = GR{
    prs => import prs._
    FederatedIdentityRow.tupled((<<[String], <<?[String], <<?[String], <<?[String], <<?[String], <<[String]))
  }
  /** Table description of table FEDERATED_IDENTITY. Objects of this class serve as prototypes for rows in queries. */
  class FederatedIdentity(_tableTag: Tag) extends profile.api.Table[FederatedIdentityRow](_tableTag, Some("chaman"), "FEDERATED_IDENTITY") {
    def * = (identityProvider, realmId, federatedUserId, federatedUsername, token, userId) <> (FederatedIdentityRow.tupled, FederatedIdentityRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(identityProvider), realmId, federatedUserId, federatedUsername, token, Rep.Some(userId))).shaped.<>({r=>import r._; _1.map(_=> FederatedIdentityRow.tupled((_1.get, _2, _3, _4, _5, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column IDENTITY_PROVIDER SqlType(VARCHAR), Length(255,true) */
    val identityProvider: Rep[String] = column[String]("IDENTITY_PROVIDER", O.Length(255,varying=true))
    /** Database column REALM_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val realmId: Rep[Option[String]] = column[Option[String]]("REALM_ID", O.Length(36,varying=true), O.Default(None))
    /** Database column FEDERATED_USER_ID SqlType(VARCHAR), Length(255,true), Default(None) */
    val federatedUserId: Rep[Option[String]] = column[Option[String]]("FEDERATED_USER_ID", O.Length(255,varying=true), O.Default(None))
    /** Database column FEDERATED_USERNAME SqlType(VARCHAR), Length(255,true), Default(None) */
    val federatedUsername: Rep[Option[String]] = column[Option[String]]("FEDERATED_USERNAME", O.Length(255,varying=true), O.Default(None))
    /** Database column TOKEN SqlType(TEXT), Default(None) */
    val token: Rep[Option[String]] = column[Option[String]]("TOKEN", O.Default(None))
    /** Database column USER_ID SqlType(VARCHAR), Length(36,true) */
    val userId: Rep[String] = column[String]("USER_ID", O.Length(36,varying=true))

    /** Primary key of FederatedIdentity (database name FEDERATED_IDENTITY_PK) */
    val pk = primaryKey("FEDERATED_IDENTITY_PK", (identityProvider, userId))

    /** Foreign key referencing UserEntity (database name FK404288B92EF007A6) */
    lazy val userEntityFk = foreignKey("FK404288B92EF007A6", userId, UserEntity)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Index over (federatedUserId) (database name IDX_FEDIDENTITY_FEDUSER) */
    val index1 = index("IDX_FEDIDENTITY_FEDUSER", federatedUserId)
  }
  /** Collection-like TableQuery object for table FederatedIdentity */
  lazy val FederatedIdentity = new TableQuery(tag => new FederatedIdentity(tag))

  /** Entity class storing rows of table FederatedUser
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(255,true)
   *  @param storageProviderId Database column STORAGE_PROVIDER_ID SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(36,true) */
  case class FederatedUserRow(id: String, storageProviderId: Option[String] = None, realmId: String)
  /** GetResult implicit for fetching FederatedUserRow objects using plain SQL queries */
  implicit def GetResultFederatedUserRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[FederatedUserRow] = GR{
    prs => import prs._
    FederatedUserRow.tupled((<<[String], <<?[String], <<[String]))
  }
  /** Table description of table FEDERATED_USER. Objects of this class serve as prototypes for rows in queries. */
  class FederatedUser(_tableTag: Tag) extends profile.api.Table[FederatedUserRow](_tableTag, Some("chaman"), "FEDERATED_USER") {
    def * = (id, storageProviderId, realmId) <> (FederatedUserRow.tupled, FederatedUserRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), storageProviderId, Rep.Some(realmId))).shaped.<>({r=>import r._; _1.map(_=> FederatedUserRow.tupled((_1.get, _2, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(255,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(255,varying=true))
    /** Database column STORAGE_PROVIDER_ID SqlType(VARCHAR), Length(255,true), Default(None) */
    val storageProviderId: Rep[Option[String]] = column[Option[String]]("STORAGE_PROVIDER_ID", O.Length(255,varying=true), O.Default(None))
    /** Database column REALM_ID SqlType(VARCHAR), Length(36,true) */
    val realmId: Rep[String] = column[String]("REALM_ID", O.Length(36,varying=true))
  }
  /** Collection-like TableQuery object for table FederatedUser */
  lazy val FederatedUser = new TableQuery(tag => new FederatedUser(tag))

  /** Entity class storing rows of table FedUserAttribute
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true)
   *  @param userId Database column USER_ID SqlType(VARCHAR), Length(255,true)
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(36,true)
   *  @param storageProviderId Database column STORAGE_PROVIDER_ID SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param value Database column VALUE SqlType(TEXT), Default(None) */
  case class FedUserAttributeRow(id: String, name: String, userId: String, realmId: String, storageProviderId: Option[String] = None, value: Option[String] = None)
  /** GetResult implicit for fetching FedUserAttributeRow objects using plain SQL queries */
  implicit def GetResultFedUserAttributeRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[FedUserAttributeRow] = GR{
    prs => import prs._
    FedUserAttributeRow.tupled((<<[String], <<[String], <<[String], <<[String], <<?[String], <<?[String]))
  }
  /** Table description of table FED_USER_ATTRIBUTE. Objects of this class serve as prototypes for rows in queries. */
  class FedUserAttribute(_tableTag: Tag) extends profile.api.Table[FedUserAttributeRow](_tableTag, Some("chaman"), "FED_USER_ATTRIBUTE") {
    def * = (id, name, userId, realmId, storageProviderId, value) <> (FedUserAttributeRow.tupled, FedUserAttributeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(name), Rep.Some(userId), Rep.Some(realmId), storageProviderId, value)).shaped.<>({r=>import r._; _1.map(_=> FedUserAttributeRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column NAME SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("NAME", O.Length(255,varying=true))
    /** Database column USER_ID SqlType(VARCHAR), Length(255,true) */
    val userId: Rep[String] = column[String]("USER_ID", O.Length(255,varying=true))
    /** Database column REALM_ID SqlType(VARCHAR), Length(36,true) */
    val realmId: Rep[String] = column[String]("REALM_ID", O.Length(36,varying=true))
    /** Database column STORAGE_PROVIDER_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val storageProviderId: Rep[Option[String]] = column[Option[String]]("STORAGE_PROVIDER_ID", O.Length(36,varying=true), O.Default(None))
    /** Database column VALUE SqlType(TEXT), Default(None) */
    val value: Rep[Option[String]] = column[Option[String]]("VALUE", O.Default(None))

    /** Index over (userId,realmId,name) (database name IDX_FU_ATTRIBUTE) */
    val index1 = index("IDX_FU_ATTRIBUTE", (userId, realmId, name))
  }
  /** Collection-like TableQuery object for table FedUserAttribute */
  lazy val FedUserAttribute = new TableQuery(tag => new FedUserAttribute(tag))

  /** Entity class storing rows of table FedUserConsent
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param clientId Database column CLIENT_ID SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param userId Database column USER_ID SqlType(VARCHAR), Length(255,true)
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(36,true)
   *  @param storageProviderId Database column STORAGE_PROVIDER_ID SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param createdDate Database column CREATED_DATE SqlType(BIGINT), Default(None)
   *  @param lastUpdatedDate Database column LAST_UPDATED_DATE SqlType(BIGINT), Default(None)
   *  @param clientStorageProvider Database column CLIENT_STORAGE_PROVIDER SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param externalClientId Database column EXTERNAL_CLIENT_ID SqlType(VARCHAR), Length(255,true), Default(None) */
  case class FedUserConsentRow(id: String, clientId: Option[String] = None, userId: String, realmId: String, storageProviderId: Option[String] = None, createdDate: Option[Long] = None, lastUpdatedDate: Option[Long] = None, clientStorageProvider: Option[String] = None, externalClientId: Option[String] = None)
  /** GetResult implicit for fetching FedUserConsentRow objects using plain SQL queries */
  implicit def GetResultFedUserConsentRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Option[Long]]): GR[FedUserConsentRow] = GR{
    prs => import prs._
    FedUserConsentRow.tupled((<<[String], <<?[String], <<[String], <<[String], <<?[String], <<?[Long], <<?[Long], <<?[String], <<?[String]))
  }
  /** Table description of table FED_USER_CONSENT. Objects of this class serve as prototypes for rows in queries. */
  class FedUserConsent(_tableTag: Tag) extends profile.api.Table[FedUserConsentRow](_tableTag, Some("chaman"), "FED_USER_CONSENT") {
    def * = (id, clientId, userId, realmId, storageProviderId, createdDate, lastUpdatedDate, clientStorageProvider, externalClientId) <> (FedUserConsentRow.tupled, FedUserConsentRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), clientId, Rep.Some(userId), Rep.Some(realmId), storageProviderId, createdDate, lastUpdatedDate, clientStorageProvider, externalClientId)).shaped.<>({r=>import r._; _1.map(_=> FedUserConsentRow.tupled((_1.get, _2, _3.get, _4.get, _5, _6, _7, _8, _9)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column CLIENT_ID SqlType(VARCHAR), Length(255,true), Default(None) */
    val clientId: Rep[Option[String]] = column[Option[String]]("CLIENT_ID", O.Length(255,varying=true), O.Default(None))
    /** Database column USER_ID SqlType(VARCHAR), Length(255,true) */
    val userId: Rep[String] = column[String]("USER_ID", O.Length(255,varying=true))
    /** Database column REALM_ID SqlType(VARCHAR), Length(36,true) */
    val realmId: Rep[String] = column[String]("REALM_ID", O.Length(36,varying=true))
    /** Database column STORAGE_PROVIDER_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val storageProviderId: Rep[Option[String]] = column[Option[String]]("STORAGE_PROVIDER_ID", O.Length(36,varying=true), O.Default(None))
    /** Database column CREATED_DATE SqlType(BIGINT), Default(None) */
    val createdDate: Rep[Option[Long]] = column[Option[Long]]("CREATED_DATE", O.Default(None))
    /** Database column LAST_UPDATED_DATE SqlType(BIGINT), Default(None) */
    val lastUpdatedDate: Rep[Option[Long]] = column[Option[Long]]("LAST_UPDATED_DATE", O.Default(None))
    /** Database column CLIENT_STORAGE_PROVIDER SqlType(VARCHAR), Length(36,true), Default(None) */
    val clientStorageProvider: Rep[Option[String]] = column[Option[String]]("CLIENT_STORAGE_PROVIDER", O.Length(36,varying=true), O.Default(None))
    /** Database column EXTERNAL_CLIENT_ID SqlType(VARCHAR), Length(255,true), Default(None) */
    val externalClientId: Rep[Option[String]] = column[Option[String]]("EXTERNAL_CLIENT_ID", O.Length(255,varying=true), O.Default(None))

    /** Index over (userId,clientStorageProvider,externalClientId) (database name IDX_FU_CNSNT_EXT) */
    val index1 = index("IDX_FU_CNSNT_EXT", (userId, clientStorageProvider, externalClientId))
    /** Index over (userId,clientId) (database name IDX_FU_CONSENT) */
    val index2 = index("IDX_FU_CONSENT", (userId, clientId))
    /** Index over (realmId,userId) (database name IDX_FU_CONSENT_RU) */
    val index3 = index("IDX_FU_CONSENT_RU", (realmId, userId))
  }
  /** Collection-like TableQuery object for table FedUserConsent */
  lazy val FedUserConsent = new TableQuery(tag => new FedUserConsent(tag))

  /** Entity class storing rows of table FedUserConsentClScope
   *  @param userConsentId Database column USER_CONSENT_ID SqlType(VARCHAR), Length(36,true)
   *  @param scopeId Database column SCOPE_ID SqlType(VARCHAR), Length(36,true) */
  case class FedUserConsentClScopeRow(userConsentId: String, scopeId: String)
  /** GetResult implicit for fetching FedUserConsentClScopeRow objects using plain SQL queries */
  implicit def GetResultFedUserConsentClScopeRow(implicit e0: GR[String]): GR[FedUserConsentClScopeRow] = GR{
    prs => import prs._
    FedUserConsentClScopeRow.tupled((<<[String], <<[String]))
  }
  /** Table description of table FED_USER_CONSENT_CL_SCOPE. Objects of this class serve as prototypes for rows in queries. */
  class FedUserConsentClScope(_tableTag: Tag) extends profile.api.Table[FedUserConsentClScopeRow](_tableTag, Some("chaman"), "FED_USER_CONSENT_CL_SCOPE") {
    def * = (userConsentId, scopeId) <> (FedUserConsentClScopeRow.tupled, FedUserConsentClScopeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(userConsentId), Rep.Some(scopeId))).shaped.<>({r=>import r._; _1.map(_=> FedUserConsentClScopeRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column USER_CONSENT_ID SqlType(VARCHAR), Length(36,true) */
    val userConsentId: Rep[String] = column[String]("USER_CONSENT_ID", O.Length(36,varying=true))
    /** Database column SCOPE_ID SqlType(VARCHAR), Length(36,true) */
    val scopeId: Rep[String] = column[String]("SCOPE_ID", O.Length(36,varying=true))

    /** Primary key of FedUserConsentClScope (database name FED_USER_CONSENT_CL_SCOPE_PK) */
    val pk = primaryKey("FED_USER_CONSENT_CL_SCOPE_PK", (userConsentId, scopeId))
  }
  /** Collection-like TableQuery object for table FedUserConsentClScope */
  lazy val FedUserConsentClScope = new TableQuery(tag => new FedUserConsentClScope(tag))

  /** Entity class storing rows of table FedUserCredential
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param salt Database column SALT SqlType(TINYBLOB), Default(None)
   *  @param `type` Database column TYPE SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param createdDate Database column CREATED_DATE SqlType(BIGINT), Default(None)
   *  @param userId Database column USER_ID SqlType(VARCHAR), Length(255,true)
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(36,true)
   *  @param storageProviderId Database column STORAGE_PROVIDER_ID SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param userLabel Database column USER_LABEL SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param secretData Database column SECRET_DATA SqlType(LONGTEXT), Length(2147483647,true), Default(None)
   *  @param credentialData Database column CREDENTIAL_DATA SqlType(LONGTEXT), Length(2147483647,true), Default(None)
   *  @param priority Database column PRIORITY SqlType(INT), Default(None) */
  case class FedUserCredentialRow(id: String, salt: Option[java.sql.Blob] = None, `type`: Option[String] = None, createdDate: Option[Long] = None, userId: String, realmId: String, storageProviderId: Option[String] = None, userLabel: Option[String] = None, secretData: Option[String] = None, credentialData: Option[String] = None, priority: Option[Int] = None)
  /** GetResult implicit for fetching FedUserCredentialRow objects using plain SQL queries */
  implicit def GetResultFedUserCredentialRow(implicit e0: GR[String], e1: GR[Option[java.sql.Blob]], e2: GR[Option[String]], e3: GR[Option[Long]], e4: GR[Option[Int]]): GR[FedUserCredentialRow] = GR{
    prs => import prs._
    FedUserCredentialRow.tupled((<<[String], <<?[java.sql.Blob], <<?[String], <<?[Long], <<[String], <<[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Int]))
  }
  /** Table description of table FED_USER_CREDENTIAL. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class FedUserCredential(_tableTag: Tag) extends profile.api.Table[FedUserCredentialRow](_tableTag, Some("chaman"), "FED_USER_CREDENTIAL") {
    def * = (id, salt, `type`, createdDate, userId, realmId, storageProviderId, userLabel, secretData, credentialData, priority) <> (FedUserCredentialRow.tupled, FedUserCredentialRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), salt, `type`, createdDate, Rep.Some(userId), Rep.Some(realmId), storageProviderId, userLabel, secretData, credentialData, priority)).shaped.<>({r=>import r._; _1.map(_=> FedUserCredentialRow.tupled((_1.get, _2, _3, _4, _5.get, _6.get, _7, _8, _9, _10, _11)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column SALT SqlType(TINYBLOB), Default(None) */
    val salt: Rep[Option[java.sql.Blob]] = column[Option[java.sql.Blob]]("SALT", O.Default(None))
    /** Database column TYPE SqlType(VARCHAR), Length(255,true), Default(None)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[Option[String]] = column[Option[String]]("TYPE", O.Length(255,varying=true), O.Default(None))
    /** Database column CREATED_DATE SqlType(BIGINT), Default(None) */
    val createdDate: Rep[Option[Long]] = column[Option[Long]]("CREATED_DATE", O.Default(None))
    /** Database column USER_ID SqlType(VARCHAR), Length(255,true) */
    val userId: Rep[String] = column[String]("USER_ID", O.Length(255,varying=true))
    /** Database column REALM_ID SqlType(VARCHAR), Length(36,true) */
    val realmId: Rep[String] = column[String]("REALM_ID", O.Length(36,varying=true))
    /** Database column STORAGE_PROVIDER_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val storageProviderId: Rep[Option[String]] = column[Option[String]]("STORAGE_PROVIDER_ID", O.Length(36,varying=true), O.Default(None))
    /** Database column USER_LABEL SqlType(VARCHAR), Length(255,true), Default(None) */
    val userLabel: Rep[Option[String]] = column[Option[String]]("USER_LABEL", O.Length(255,varying=true), O.Default(None))
    /** Database column SECRET_DATA SqlType(LONGTEXT), Length(2147483647,true), Default(None) */
    val secretData: Rep[Option[String]] = column[Option[String]]("SECRET_DATA", O.Length(2147483647,varying=true), O.Default(None))
    /** Database column CREDENTIAL_DATA SqlType(LONGTEXT), Length(2147483647,true), Default(None) */
    val credentialData: Rep[Option[String]] = column[Option[String]]("CREDENTIAL_DATA", O.Length(2147483647,varying=true), O.Default(None))
    /** Database column PRIORITY SqlType(INT), Default(None) */
    val priority: Rep[Option[Int]] = column[Option[Int]]("PRIORITY", O.Default(None))

    /** Index over (userId,`type`) (database name IDX_FU_CREDENTIAL) */
    val index1 = index("IDX_FU_CREDENTIAL", (userId, `type`))
    /** Index over (realmId,userId) (database name IDX_FU_CREDENTIAL_RU) */
    val index2 = index("IDX_FU_CREDENTIAL_RU", (realmId, userId))
  }
  /** Collection-like TableQuery object for table FedUserCredential */
  lazy val FedUserCredential = new TableQuery(tag => new FedUserCredential(tag))

  /** Entity class storing rows of table FedUserGroupMembership
   *  @param groupId Database column GROUP_ID SqlType(VARCHAR), Length(36,true)
   *  @param userId Database column USER_ID SqlType(VARCHAR), Length(255,true)
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(36,true)
   *  @param storageProviderId Database column STORAGE_PROVIDER_ID SqlType(VARCHAR), Length(36,true), Default(None) */
  case class FedUserGroupMembershipRow(groupId: String, userId: String, realmId: String, storageProviderId: Option[String] = None)
  /** GetResult implicit for fetching FedUserGroupMembershipRow objects using plain SQL queries */
  implicit def GetResultFedUserGroupMembershipRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[FedUserGroupMembershipRow] = GR{
    prs => import prs._
    FedUserGroupMembershipRow.tupled((<<[String], <<[String], <<[String], <<?[String]))
  }
  /** Table description of table FED_USER_GROUP_MEMBERSHIP. Objects of this class serve as prototypes for rows in queries. */
  class FedUserGroupMembership(_tableTag: Tag) extends profile.api.Table[FedUserGroupMembershipRow](_tableTag, Some("chaman"), "FED_USER_GROUP_MEMBERSHIP") {
    def * = (groupId, userId, realmId, storageProviderId) <> (FedUserGroupMembershipRow.tupled, FedUserGroupMembershipRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(groupId), Rep.Some(userId), Rep.Some(realmId), storageProviderId)).shaped.<>({r=>import r._; _1.map(_=> FedUserGroupMembershipRow.tupled((_1.get, _2.get, _3.get, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column GROUP_ID SqlType(VARCHAR), Length(36,true) */
    val groupId: Rep[String] = column[String]("GROUP_ID", O.Length(36,varying=true))
    /** Database column USER_ID SqlType(VARCHAR), Length(255,true) */
    val userId: Rep[String] = column[String]("USER_ID", O.Length(255,varying=true))
    /** Database column REALM_ID SqlType(VARCHAR), Length(36,true) */
    val realmId: Rep[String] = column[String]("REALM_ID", O.Length(36,varying=true))
    /** Database column STORAGE_PROVIDER_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val storageProviderId: Rep[Option[String]] = column[Option[String]]("STORAGE_PROVIDER_ID", O.Length(36,varying=true), O.Default(None))

    /** Primary key of FedUserGroupMembership (database name FED_USER_GROUP_MEMBERSHIP_PK) */
    val pk = primaryKey("FED_USER_GROUP_MEMBERSHIP_PK", (groupId, userId))

    /** Index over (realmId,userId) (database name IDX_FU_GROUP_MEMBERSHIP_RU) */
    val index1 = index("IDX_FU_GROUP_MEMBERSHIP_RU", (realmId, userId))
  }
  /** Collection-like TableQuery object for table FedUserGroupMembership */
  lazy val FedUserGroupMembership = new TableQuery(tag => new FedUserGroupMembership(tag))

  /** Entity class storing rows of table FedUserRequiredAction
   *  @param requiredAction Database column REQUIRED_ACTION SqlType(VARCHAR), Length(255,true), Default( )
   *  @param userId Database column USER_ID SqlType(VARCHAR), Length(255,true)
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(36,true)
   *  @param storageProviderId Database column STORAGE_PROVIDER_ID SqlType(VARCHAR), Length(36,true), Default(None) */
  case class FedUserRequiredActionRow(requiredAction: String = " ", userId: String, realmId: String, storageProviderId: Option[String] = None)
  /** GetResult implicit for fetching FedUserRequiredActionRow objects using plain SQL queries */
  implicit def GetResultFedUserRequiredActionRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[FedUserRequiredActionRow] = GR{
    prs => import prs._
    FedUserRequiredActionRow.tupled((<<[String], <<[String], <<[String], <<?[String]))
  }
  /** Table description of table FED_USER_REQUIRED_ACTION. Objects of this class serve as prototypes for rows in queries. */
  class FedUserRequiredAction(_tableTag: Tag) extends profile.api.Table[FedUserRequiredActionRow](_tableTag, Some("chaman"), "FED_USER_REQUIRED_ACTION") {
    def * = (requiredAction, userId, realmId, storageProviderId) <> (FedUserRequiredActionRow.tupled, FedUserRequiredActionRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(requiredAction), Rep.Some(userId), Rep.Some(realmId), storageProviderId)).shaped.<>({r=>import r._; _1.map(_=> FedUserRequiredActionRow.tupled((_1.get, _2.get, _3.get, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column REQUIRED_ACTION SqlType(VARCHAR), Length(255,true), Default( ) */
    val requiredAction: Rep[String] = column[String]("REQUIRED_ACTION", O.Length(255,varying=true), O.Default(" "))
    /** Database column USER_ID SqlType(VARCHAR), Length(255,true) */
    val userId: Rep[String] = column[String]("USER_ID", O.Length(255,varying=true))
    /** Database column REALM_ID SqlType(VARCHAR), Length(36,true) */
    val realmId: Rep[String] = column[String]("REALM_ID", O.Length(36,varying=true))
    /** Database column STORAGE_PROVIDER_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val storageProviderId: Rep[Option[String]] = column[Option[String]]("STORAGE_PROVIDER_ID", O.Length(36,varying=true), O.Default(None))

    /** Primary key of FedUserRequiredAction (database name FED_USER_REQUIRED_ACTION_PK) */
    val pk = primaryKey("FED_USER_REQUIRED_ACTION_PK", (requiredAction, userId))

    /** Index over (realmId,userId) (database name IDX_FU_REQUIRED_ACTION_RU) */
    val index1 = index("IDX_FU_REQUIRED_ACTION_RU", (realmId, userId))
  }
  /** Collection-like TableQuery object for table FedUserRequiredAction */
  lazy val FedUserRequiredAction = new TableQuery(tag => new FedUserRequiredAction(tag))

  /** Entity class storing rows of table FedUserRoleMapping
   *  @param roleId Database column ROLE_ID SqlType(VARCHAR), Length(36,true)
   *  @param userId Database column USER_ID SqlType(VARCHAR), Length(255,true)
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(36,true)
   *  @param storageProviderId Database column STORAGE_PROVIDER_ID SqlType(VARCHAR), Length(36,true), Default(None) */
  case class FedUserRoleMappingRow(roleId: String, userId: String, realmId: String, storageProviderId: Option[String] = None)
  /** GetResult implicit for fetching FedUserRoleMappingRow objects using plain SQL queries */
  implicit def GetResultFedUserRoleMappingRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[FedUserRoleMappingRow] = GR{
    prs => import prs._
    FedUserRoleMappingRow.tupled((<<[String], <<[String], <<[String], <<?[String]))
  }
  /** Table description of table FED_USER_ROLE_MAPPING. Objects of this class serve as prototypes for rows in queries. */
  class FedUserRoleMapping(_tableTag: Tag) extends profile.api.Table[FedUserRoleMappingRow](_tableTag, Some("chaman"), "FED_USER_ROLE_MAPPING") {
    def * = (roleId, userId, realmId, storageProviderId) <> (FedUserRoleMappingRow.tupled, FedUserRoleMappingRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(roleId), Rep.Some(userId), Rep.Some(realmId), storageProviderId)).shaped.<>({r=>import r._; _1.map(_=> FedUserRoleMappingRow.tupled((_1.get, _2.get, _3.get, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ROLE_ID SqlType(VARCHAR), Length(36,true) */
    val roleId: Rep[String] = column[String]("ROLE_ID", O.Length(36,varying=true))
    /** Database column USER_ID SqlType(VARCHAR), Length(255,true) */
    val userId: Rep[String] = column[String]("USER_ID", O.Length(255,varying=true))
    /** Database column REALM_ID SqlType(VARCHAR), Length(36,true) */
    val realmId: Rep[String] = column[String]("REALM_ID", O.Length(36,varying=true))
    /** Database column STORAGE_PROVIDER_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val storageProviderId: Rep[Option[String]] = column[Option[String]]("STORAGE_PROVIDER_ID", O.Length(36,varying=true), O.Default(None))

    /** Primary key of FedUserRoleMapping (database name FED_USER_ROLE_MAPPING_PK) */
    val pk = primaryKey("FED_USER_ROLE_MAPPING_PK", (roleId, userId))

    /** Index over (realmId,userId) (database name IDX_FU_ROLE_MAPPING_RU) */
    val index1 = index("IDX_FU_ROLE_MAPPING_RU", (realmId, userId))
  }
  /** Collection-like TableQuery object for table FedUserRoleMapping */
  lazy val FedUserRoleMapping = new TableQuery(tag => new FedUserRoleMapping(tag))

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

  /** Entity class storing rows of table FieldTag
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param fieldUuid Database column field_uuid SqlType(VARCHAR), Length(36,true)
   *  @param value Database column value SqlType(VARCHAR), Length(1000,true)
   *  @param author Database column author SqlType(VARCHAR), Length(36,true)
   *  @param timestamp Database column timestamp SqlType(TIMESTAMP) */
  case class FieldTagRow(id: Long, fieldUuid: String, value: String, author: String, timestamp: java.sql.Timestamp)
  /** GetResult implicit for fetching FieldTagRow objects using plain SQL queries */
  implicit def GetResultFieldTagRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[FieldTagRow] = GR{
    prs => import prs._
    FieldTagRow.tupled((<<[Long], <<[String], <<[String], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table field_tag. Objects of this class serve as prototypes for rows in queries. */
  class FieldTag(_tableTag: Tag) extends profile.api.Table[FieldTagRow](_tableTag, Some("chaman"), "field_tag") {
    def * = (id, fieldUuid, value, author, timestamp) <> (FieldTagRow.tupled, FieldTagRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(fieldUuid), Rep.Some(value), Rep.Some(author), Rep.Some(timestamp))).shaped.<>({r=>import r._; _1.map(_=> FieldTagRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column field_uuid SqlType(VARCHAR), Length(36,true) */
    val fieldUuid: Rep[String] = column[String]("field_uuid", O.Length(36,varying=true))
    /** Database column value SqlType(VARCHAR), Length(1000,true) */
    val value: Rep[String] = column[String]("value", O.Length(1000,varying=true))
    /** Database column author SqlType(VARCHAR), Length(36,true) */
    val author: Rep[String] = column[String]("author", O.Length(36,varying=true))
    /** Database column timestamp SqlType(TIMESTAMP) */
    val timestamp: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("timestamp")

    /** Index over (fieldUuid) (database name field_uuid) */
    val index1 = index("field_uuid", fieldUuid)
  }
  /** Collection-like TableQuery object for table FieldTag */
  lazy val FieldTag = new TableQuery(tag => new FieldTag(tag))

  /** Entity class storing rows of table GroupAttribute
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true), Default(sybase-needs-something-here)
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true)
   *  @param value Database column VALUE SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param groupId Database column GROUP_ID SqlType(VARCHAR), Length(36,true) */
  case class GroupAttributeRow(id: String = "sybase-needs-something-here", name: String, value: Option[String] = None, groupId: String)
  /** GetResult implicit for fetching GroupAttributeRow objects using plain SQL queries */
  implicit def GetResultGroupAttributeRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[GroupAttributeRow] = GR{
    prs => import prs._
    GroupAttributeRow.tupled((<<[String], <<[String], <<?[String], <<[String]))
  }
  /** Table description of table GROUP_ATTRIBUTE. Objects of this class serve as prototypes for rows in queries. */
  class GroupAttribute(_tableTag: Tag) extends profile.api.Table[GroupAttributeRow](_tableTag, Some("chaman"), "GROUP_ATTRIBUTE") {
    def * = (id, name, value, groupId) <> (GroupAttributeRow.tupled, GroupAttributeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(name), value, Rep.Some(groupId))).shaped.<>({r=>import r._; _1.map(_=> GroupAttributeRow.tupled((_1.get, _2.get, _3, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true), Default(sybase-needs-something-here) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true), O.Default("sybase-needs-something-here"))
    /** Database column NAME SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("NAME", O.Length(255,varying=true))
    /** Database column VALUE SqlType(VARCHAR), Length(255,true), Default(None) */
    val value: Rep[Option[String]] = column[Option[String]]("VALUE", O.Length(255,varying=true), O.Default(None))
    /** Database column GROUP_ID SqlType(VARCHAR), Length(36,true) */
    val groupId: Rep[String] = column[String]("GROUP_ID", O.Length(36,varying=true))

    /** Foreign key referencing KeycloakGroup (database name FK_GROUP_ATTRIBUTE_GROUP) */
    lazy val keycloakGroupFk = foreignKey("FK_GROUP_ATTRIBUTE_GROUP", groupId, KeycloakGroup)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table GroupAttribute */
  lazy val GroupAttribute = new TableQuery(tag => new GroupAttribute(tag))

  /** Entity class storing rows of table GroupRoleMapping
   *  @param roleId Database column ROLE_ID SqlType(VARCHAR), Length(36,true)
   *  @param groupId Database column GROUP_ID SqlType(VARCHAR), Length(36,true) */
  case class GroupRoleMappingRow(roleId: String, groupId: String)
  /** GetResult implicit for fetching GroupRoleMappingRow objects using plain SQL queries */
  implicit def GetResultGroupRoleMappingRow(implicit e0: GR[String]): GR[GroupRoleMappingRow] = GR{
    prs => import prs._
    GroupRoleMappingRow.tupled((<<[String], <<[String]))
  }
  /** Table description of table GROUP_ROLE_MAPPING. Objects of this class serve as prototypes for rows in queries. */
  class GroupRoleMapping(_tableTag: Tag) extends profile.api.Table[GroupRoleMappingRow](_tableTag, Some("chaman"), "GROUP_ROLE_MAPPING") {
    def * = (roleId, groupId) <> (GroupRoleMappingRow.tupled, GroupRoleMappingRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(roleId), Rep.Some(groupId))).shaped.<>({r=>import r._; _1.map(_=> GroupRoleMappingRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ROLE_ID SqlType(VARCHAR), Length(36,true) */
    val roleId: Rep[String] = column[String]("ROLE_ID", O.Length(36,varying=true))
    /** Database column GROUP_ID SqlType(VARCHAR), Length(36,true) */
    val groupId: Rep[String] = column[String]("GROUP_ID", O.Length(36,varying=true))

    /** Primary key of GroupRoleMapping (database name GROUP_ROLE_MAPPING_PK) */
    val pk = primaryKey("GROUP_ROLE_MAPPING_PK", (roleId, groupId))

    /** Foreign key referencing KeycloakGroup (database name FK_GROUP_ROLE_GROUP) */
    lazy val keycloakGroupFk = foreignKey("FK_GROUP_ROLE_GROUP", groupId, KeycloakGroup)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table GroupRoleMapping */
  lazy val GroupRoleMapping = new TableQuery(tag => new GroupRoleMapping(tag))

  /** Entity class storing rows of table IdentityProvider
   *  @param internalId Database column INTERNAL_ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param enabled Database column ENABLED SqlType(BIT), Default(false)
   *  @param providerAlias Database column PROVIDER_ALIAS SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param providerId Database column PROVIDER_ID SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param storeToken Database column STORE_TOKEN SqlType(BIT), Default(false)
   *  @param authenticateByDefault Database column AUTHENTICATE_BY_DEFAULT SqlType(BIT), Default(false)
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param addTokenRole Database column ADD_TOKEN_ROLE SqlType(BIT), Default(true)
   *  @param trustEmail Database column TRUST_EMAIL SqlType(BIT), Default(false)
   *  @param firstBrokerLoginFlowId Database column FIRST_BROKER_LOGIN_FLOW_ID SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param postBrokerLoginFlowId Database column POST_BROKER_LOGIN_FLOW_ID SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param providerDisplayName Database column PROVIDER_DISPLAY_NAME SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param linkOnly Database column LINK_ONLY SqlType(BIT), Default(false) */
  case class IdentityProviderRow(internalId: String, enabled: Boolean = false, providerAlias: Option[String] = None, providerId: Option[String] = None, storeToken: Boolean = false, authenticateByDefault: Boolean = false, realmId: Option[String] = None, addTokenRole: Boolean = true, trustEmail: Boolean = false, firstBrokerLoginFlowId: Option[String] = None, postBrokerLoginFlowId: Option[String] = None, providerDisplayName: Option[String] = None, linkOnly: Boolean = false)
  /** GetResult implicit for fetching IdentityProviderRow objects using plain SQL queries */
  implicit def GetResultIdentityProviderRow(implicit e0: GR[String], e1: GR[Boolean], e2: GR[Option[String]]): GR[IdentityProviderRow] = GR{
    prs => import prs._
    IdentityProviderRow.tupled((<<[String], <<[Boolean], <<?[String], <<?[String], <<[Boolean], <<[Boolean], <<?[String], <<[Boolean], <<[Boolean], <<?[String], <<?[String], <<?[String], <<[Boolean]))
  }
  /** Table description of table IDENTITY_PROVIDER. Objects of this class serve as prototypes for rows in queries. */
  class IdentityProvider(_tableTag: Tag) extends profile.api.Table[IdentityProviderRow](_tableTag, Some("chaman"), "IDENTITY_PROVIDER") {
    def * = (internalId, enabled, providerAlias, providerId, storeToken, authenticateByDefault, realmId, addTokenRole, trustEmail, firstBrokerLoginFlowId, postBrokerLoginFlowId, providerDisplayName, linkOnly) <> (IdentityProviderRow.tupled, IdentityProviderRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(internalId), Rep.Some(enabled), providerAlias, providerId, Rep.Some(storeToken), Rep.Some(authenticateByDefault), realmId, Rep.Some(addTokenRole), Rep.Some(trustEmail), firstBrokerLoginFlowId, postBrokerLoginFlowId, providerDisplayName, Rep.Some(linkOnly))).shaped.<>({r=>import r._; _1.map(_=> IdentityProviderRow.tupled((_1.get, _2.get, _3, _4, _5.get, _6.get, _7, _8.get, _9.get, _10, _11, _12, _13.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column INTERNAL_ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val internalId: Rep[String] = column[String]("INTERNAL_ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column ENABLED SqlType(BIT), Default(false) */
    val enabled: Rep[Boolean] = column[Boolean]("ENABLED", O.Default(false))
    /** Database column PROVIDER_ALIAS SqlType(VARCHAR), Length(255,true), Default(None) */
    val providerAlias: Rep[Option[String]] = column[Option[String]]("PROVIDER_ALIAS", O.Length(255,varying=true), O.Default(None))
    /** Database column PROVIDER_ID SqlType(VARCHAR), Length(255,true), Default(None) */
    val providerId: Rep[Option[String]] = column[Option[String]]("PROVIDER_ID", O.Length(255,varying=true), O.Default(None))
    /** Database column STORE_TOKEN SqlType(BIT), Default(false) */
    val storeToken: Rep[Boolean] = column[Boolean]("STORE_TOKEN", O.Default(false))
    /** Database column AUTHENTICATE_BY_DEFAULT SqlType(BIT), Default(false) */
    val authenticateByDefault: Rep[Boolean] = column[Boolean]("AUTHENTICATE_BY_DEFAULT", O.Default(false))
    /** Database column REALM_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val realmId: Rep[Option[String]] = column[Option[String]]("REALM_ID", O.Length(36,varying=true), O.Default(None))
    /** Database column ADD_TOKEN_ROLE SqlType(BIT), Default(true) */
    val addTokenRole: Rep[Boolean] = column[Boolean]("ADD_TOKEN_ROLE", O.Default(true))
    /** Database column TRUST_EMAIL SqlType(BIT), Default(false) */
    val trustEmail: Rep[Boolean] = column[Boolean]("TRUST_EMAIL", O.Default(false))
    /** Database column FIRST_BROKER_LOGIN_FLOW_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val firstBrokerLoginFlowId: Rep[Option[String]] = column[Option[String]]("FIRST_BROKER_LOGIN_FLOW_ID", O.Length(36,varying=true), O.Default(None))
    /** Database column POST_BROKER_LOGIN_FLOW_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val postBrokerLoginFlowId: Rep[Option[String]] = column[Option[String]]("POST_BROKER_LOGIN_FLOW_ID", O.Length(36,varying=true), O.Default(None))
    /** Database column PROVIDER_DISPLAY_NAME SqlType(VARCHAR), Length(255,true), Default(None) */
    val providerDisplayName: Rep[Option[String]] = column[Option[String]]("PROVIDER_DISPLAY_NAME", O.Length(255,varying=true), O.Default(None))
    /** Database column LINK_ONLY SqlType(BIT), Default(false) */
    val linkOnly: Rep[Boolean] = column[Boolean]("LINK_ONLY", O.Default(false))

    /** Foreign key referencing Realm (database name FK2B4EBC52AE5C3B34) */
    lazy val realmFk = foreignKey("FK2B4EBC52AE5C3B34", realmId, Realm)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Uniqueness Index over (providerAlias,realmId) (database name UK_2DAELWNIBJI49AVXSRTUF6XJ33) */
    val index1 = index("UK_2DAELWNIBJI49AVXSRTUF6XJ33", (providerAlias, realmId), unique=true)
  }
  /** Collection-like TableQuery object for table IdentityProvider */
  lazy val IdentityProvider = new TableQuery(tag => new IdentityProvider(tag))

  /** Entity class storing rows of table IdentityProviderConfig
   *  @param identityProviderId Database column IDENTITY_PROVIDER_ID SqlType(VARCHAR), Length(36,true)
   *  @param value Database column VALUE SqlType(LONGTEXT), Length(2147483647,true), Default(None)
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true) */
  case class IdentityProviderConfigRow(identityProviderId: String, value: Option[String] = None, name: String)
  /** GetResult implicit for fetching IdentityProviderConfigRow objects using plain SQL queries */
  implicit def GetResultIdentityProviderConfigRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[IdentityProviderConfigRow] = GR{
    prs => import prs._
    IdentityProviderConfigRow.tupled((<<[String], <<?[String], <<[String]))
  }
  /** Table description of table IDENTITY_PROVIDER_CONFIG. Objects of this class serve as prototypes for rows in queries. */
  class IdentityProviderConfig(_tableTag: Tag) extends profile.api.Table[IdentityProviderConfigRow](_tableTag, Some("chaman"), "IDENTITY_PROVIDER_CONFIG") {
    def * = (identityProviderId, value, name) <> (IdentityProviderConfigRow.tupled, IdentityProviderConfigRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(identityProviderId), value, Rep.Some(name))).shaped.<>({r=>import r._; _1.map(_=> IdentityProviderConfigRow.tupled((_1.get, _2, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column IDENTITY_PROVIDER_ID SqlType(VARCHAR), Length(36,true) */
    val identityProviderId: Rep[String] = column[String]("IDENTITY_PROVIDER_ID", O.Length(36,varying=true))
    /** Database column VALUE SqlType(LONGTEXT), Length(2147483647,true), Default(None) */
    val value: Rep[Option[String]] = column[Option[String]]("VALUE", O.Length(2147483647,varying=true), O.Default(None))
    /** Database column NAME SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("NAME", O.Length(255,varying=true))

    /** Primary key of IdentityProviderConfig (database name IDENTITY_PROVIDER_CONFIG_PK) */
    val pk = primaryKey("IDENTITY_PROVIDER_CONFIG_PK", (identityProviderId, name))

    /** Foreign key referencing IdentityProvider (database name FKDC4897CF864C4E43) */
    lazy val identityProviderFk = foreignKey("FKDC4897CF864C4E43", identityProviderId, IdentityProvider)(r => r.internalId, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table IdentityProviderConfig */
  lazy val IdentityProviderConfig = new TableQuery(tag => new IdentityProviderConfig(tag))

  /** Entity class storing rows of table IdentityProviderMapper
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true)
   *  @param idpAlias Database column IDP_ALIAS SqlType(VARCHAR), Length(255,true)
   *  @param idpMapperName Database column IDP_MAPPER_NAME SqlType(VARCHAR), Length(255,true)
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(36,true) */
  case class IdentityProviderMapperRow(id: String, name: String, idpAlias: String, idpMapperName: String, realmId: String)
  /** GetResult implicit for fetching IdentityProviderMapperRow objects using plain SQL queries */
  implicit def GetResultIdentityProviderMapperRow(implicit e0: GR[String]): GR[IdentityProviderMapperRow] = GR{
    prs => import prs._
    IdentityProviderMapperRow.tupled((<<[String], <<[String], <<[String], <<[String], <<[String]))
  }
  /** Table description of table IDENTITY_PROVIDER_MAPPER. Objects of this class serve as prototypes for rows in queries. */
  class IdentityProviderMapper(_tableTag: Tag) extends profile.api.Table[IdentityProviderMapperRow](_tableTag, Some("chaman"), "IDENTITY_PROVIDER_MAPPER") {
    def * = (id, name, idpAlias, idpMapperName, realmId) <> (IdentityProviderMapperRow.tupled, IdentityProviderMapperRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(name), Rep.Some(idpAlias), Rep.Some(idpMapperName), Rep.Some(realmId))).shaped.<>({r=>import r._; _1.map(_=> IdentityProviderMapperRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column NAME SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("NAME", O.Length(255,varying=true))
    /** Database column IDP_ALIAS SqlType(VARCHAR), Length(255,true) */
    val idpAlias: Rep[String] = column[String]("IDP_ALIAS", O.Length(255,varying=true))
    /** Database column IDP_MAPPER_NAME SqlType(VARCHAR), Length(255,true) */
    val idpMapperName: Rep[String] = column[String]("IDP_MAPPER_NAME", O.Length(255,varying=true))
    /** Database column REALM_ID SqlType(VARCHAR), Length(36,true) */
    val realmId: Rep[String] = column[String]("REALM_ID", O.Length(36,varying=true))

    /** Foreign key referencing Realm (database name FK_IDPM_REALM) */
    lazy val realmFk = foreignKey("FK_IDPM_REALM", realmId, Realm)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table IdentityProviderMapper */
  lazy val IdentityProviderMapper = new TableQuery(tag => new IdentityProviderMapper(tag))

  /** Entity class storing rows of table IdpMapperConfig
   *  @param idpMapperId Database column IDP_MAPPER_ID SqlType(VARCHAR), Length(36,true)
   *  @param value Database column VALUE SqlType(LONGTEXT), Length(2147483647,true), Default(None)
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true) */
  case class IdpMapperConfigRow(idpMapperId: String, value: Option[String] = None, name: String)
  /** GetResult implicit for fetching IdpMapperConfigRow objects using plain SQL queries */
  implicit def GetResultIdpMapperConfigRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[IdpMapperConfigRow] = GR{
    prs => import prs._
    IdpMapperConfigRow.tupled((<<[String], <<?[String], <<[String]))
  }
  /** Table description of table IDP_MAPPER_CONFIG. Objects of this class serve as prototypes for rows in queries. */
  class IdpMapperConfig(_tableTag: Tag) extends profile.api.Table[IdpMapperConfigRow](_tableTag, Some("chaman"), "IDP_MAPPER_CONFIG") {
    def * = (idpMapperId, value, name) <> (IdpMapperConfigRow.tupled, IdpMapperConfigRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(idpMapperId), value, Rep.Some(name))).shaped.<>({r=>import r._; _1.map(_=> IdpMapperConfigRow.tupled((_1.get, _2, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column IDP_MAPPER_ID SqlType(VARCHAR), Length(36,true) */
    val idpMapperId: Rep[String] = column[String]("IDP_MAPPER_ID", O.Length(36,varying=true))
    /** Database column VALUE SqlType(LONGTEXT), Length(2147483647,true), Default(None) */
    val value: Rep[Option[String]] = column[Option[String]]("VALUE", O.Length(2147483647,varying=true), O.Default(None))
    /** Database column NAME SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("NAME", O.Length(255,varying=true))

    /** Primary key of IdpMapperConfig (database name IDP_MAPPER_CONFIG_PK) */
    val pk = primaryKey("IDP_MAPPER_CONFIG_PK", (idpMapperId, name))

    /** Foreign key referencing IdentityProviderMapper (database name FK_IDPMCONFIG) */
    lazy val identityProviderMapperFk = foreignKey("FK_IDPMCONFIG", idpMapperId, IdentityProviderMapper)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table IdpMapperConfig */
  lazy val IdpMapperConfig = new TableQuery(tag => new IdpMapperConfig(tag))

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

  /** Entity class storing rows of table ItemThumbnail
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param itemUuid Database column item_uuid SqlType(VARCHAR), Length(36,true)
   *  @param annexUuid Database column annex_uuid SqlType(VARCHAR), Length(36,true)
   *  @param x Database column x SqlType(INT)
   *  @param y Database column y SqlType(INT)
   *  @param width Database column width SqlType(INT)
   *  @param author Database column author SqlType(VARCHAR), Length(36,true)
   *  @param timestamp Database column timestamp SqlType(TIMESTAMP) */
  case class ItemThumbnailRow(id: Long, itemUuid: String, annexUuid: String, x: Int, y: Int, width: Int, author: String, timestamp: java.sql.Timestamp)
  /** GetResult implicit for fetching ItemThumbnailRow objects using plain SQL queries */
  implicit def GetResultItemThumbnailRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Int], e3: GR[java.sql.Timestamp]): GR[ItemThumbnailRow] = GR{
    prs => import prs._
    ItemThumbnailRow.tupled((<<[Long], <<[String], <<[String], <<[Int], <<[Int], <<[Int], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table item_thumbnail. Objects of this class serve as prototypes for rows in queries. */
  class ItemThumbnail(_tableTag: Tag) extends profile.api.Table[ItemThumbnailRow](_tableTag, Some("chaman"), "item_thumbnail") {
    def * = (id, itemUuid, annexUuid, x, y, width, author, timestamp) <> (ItemThumbnailRow.tupled, ItemThumbnailRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(itemUuid), Rep.Some(annexUuid), Rep.Some(x), Rep.Some(y), Rep.Some(width), Rep.Some(author), Rep.Some(timestamp))).shaped.<>({r=>import r._; _1.map(_=> ItemThumbnailRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column item_uuid SqlType(VARCHAR), Length(36,true) */
    val itemUuid: Rep[String] = column[String]("item_uuid", O.Length(36,varying=true))
    /** Database column annex_uuid SqlType(VARCHAR), Length(36,true) */
    val annexUuid: Rep[String] = column[String]("annex_uuid", O.Length(36,varying=true))
    /** Database column x SqlType(INT) */
    val x: Rep[Int] = column[Int]("x")
    /** Database column y SqlType(INT) */
    val y: Rep[Int] = column[Int]("y")
    /** Database column width SqlType(INT) */
    val width: Rep[Int] = column[Int]("width")
    /** Database column author SqlType(VARCHAR), Length(36,true) */
    val author: Rep[String] = column[String]("author", O.Length(36,varying=true))
    /** Database column timestamp SqlType(TIMESTAMP) */
    val timestamp: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("timestamp")

    /** Index over (itemUuid) (database name item_uuid) */
    val index1 = index("item_uuid", itemUuid)
  }
  /** Collection-like TableQuery object for table ItemThumbnail */
  lazy val ItemThumbnail = new TableQuery(tag => new ItemThumbnail(tag))

  /** Entity class storing rows of table KeycloakGroup
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param parentGroup Database column PARENT_GROUP SqlType(VARCHAR), Length(36,true)
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(36,true), Default(None) */
  case class KeycloakGroupRow(id: String, name: Option[String] = None, parentGroup: String, realmId: Option[String] = None)
  /** GetResult implicit for fetching KeycloakGroupRow objects using plain SQL queries */
  implicit def GetResultKeycloakGroupRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[KeycloakGroupRow] = GR{
    prs => import prs._
    KeycloakGroupRow.tupled((<<[String], <<?[String], <<[String], <<?[String]))
  }
  /** Table description of table KEYCLOAK_GROUP. Objects of this class serve as prototypes for rows in queries. */
  class KeycloakGroup(_tableTag: Tag) extends profile.api.Table[KeycloakGroupRow](_tableTag, Some("chaman"), "KEYCLOAK_GROUP") {
    def * = (id, name, parentGroup, realmId) <> (KeycloakGroupRow.tupled, KeycloakGroupRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), name, Rep.Some(parentGroup), realmId)).shaped.<>({r=>import r._; _1.map(_=> KeycloakGroupRow.tupled((_1.get, _2, _3.get, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column NAME SqlType(VARCHAR), Length(255,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("NAME", O.Length(255,varying=true), O.Default(None))
    /** Database column PARENT_GROUP SqlType(VARCHAR), Length(36,true) */
    val parentGroup: Rep[String] = column[String]("PARENT_GROUP", O.Length(36,varying=true))
    /** Database column REALM_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val realmId: Rep[Option[String]] = column[Option[String]]("REALM_ID", O.Length(36,varying=true), O.Default(None))

    /** Uniqueness Index over (realmId,parentGroup,name) (database name SIBLING_NAMES) */
    val index1 = index("SIBLING_NAMES", (realmId, parentGroup, name), unique=true)
  }
  /** Collection-like TableQuery object for table KeycloakGroup */
  lazy val KeycloakGroup = new TableQuery(tag => new KeycloakGroup(tag))

  /** Entity class storing rows of table KeycloakRole
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param clientRealmConstraint Database column CLIENT_REALM_CONSTRAINT SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param clientRole Database column CLIENT_ROLE SqlType(BIT), Default(None)
   *  @param description Database column DESCRIPTION SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param client Database column CLIENT SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param realm Database column REALM SqlType(VARCHAR), Length(36,true), Default(None) */
  case class KeycloakRoleRow(id: String, clientRealmConstraint: Option[String] = None, clientRole: Option[Boolean] = None, description: Option[String] = None, name: Option[String] = None, realmId: Option[String] = None, client: Option[String] = None, realm: Option[String] = None)
  /** GetResult implicit for fetching KeycloakRoleRow objects using plain SQL queries */
  implicit def GetResultKeycloakRoleRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Option[Boolean]]): GR[KeycloakRoleRow] = GR{
    prs => import prs._
    KeycloakRoleRow.tupled((<<[String], <<?[String], <<?[Boolean], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table KEYCLOAK_ROLE. Objects of this class serve as prototypes for rows in queries. */
  class KeycloakRole(_tableTag: Tag) extends profile.api.Table[KeycloakRoleRow](_tableTag, Some("chaman"), "KEYCLOAK_ROLE") {
    def * = (id, clientRealmConstraint, clientRole, description, name, realmId, client, realm) <> (KeycloakRoleRow.tupled, KeycloakRoleRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), clientRealmConstraint, clientRole, description, name, realmId, client, realm)).shaped.<>({r=>import r._; _1.map(_=> KeycloakRoleRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column CLIENT_REALM_CONSTRAINT SqlType(VARCHAR), Length(255,true), Default(None) */
    val clientRealmConstraint: Rep[Option[String]] = column[Option[String]]("CLIENT_REALM_CONSTRAINT", O.Length(255,varying=true), O.Default(None))
    /** Database column CLIENT_ROLE SqlType(BIT), Default(None) */
    val clientRole: Rep[Option[Boolean]] = column[Option[Boolean]]("CLIENT_ROLE", O.Default(None))
    /** Database column DESCRIPTION SqlType(VARCHAR), Length(255,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("DESCRIPTION", O.Length(255,varying=true), O.Default(None))
    /** Database column NAME SqlType(VARCHAR), Length(255,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("NAME", O.Length(255,varying=true), O.Default(None))
    /** Database column REALM_ID SqlType(VARCHAR), Length(255,true), Default(None) */
    val realmId: Rep[Option[String]] = column[Option[String]]("REALM_ID", O.Length(255,varying=true), O.Default(None))
    /** Database column CLIENT SqlType(VARCHAR), Length(36,true), Default(None) */
    val client: Rep[Option[String]] = column[Option[String]]("CLIENT", O.Length(36,varying=true), O.Default(None))
    /** Database column REALM SqlType(VARCHAR), Length(36,true), Default(None) */
    val realm: Rep[Option[String]] = column[Option[String]]("REALM", O.Length(36,varying=true), O.Default(None))

    /** Foreign key referencing Realm (database name FK_6VYQFE4CN4WLQ8R6KT5VDSJ5C) */
    lazy val realmFk = foreignKey("FK_6VYQFE4CN4WLQ8R6KT5VDSJ5C", realm, Realm)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Index over (client) (database name IDX_KEYCLOAK_ROLE_CLIENT) */
    val index1 = index("IDX_KEYCLOAK_ROLE_CLIENT", client)
    /** Uniqueness Index over (name,clientRealmConstraint) (database name UK_J3RWUVD56ONTGSUHOGM184WW2-2) */
    val index2 = index("UK_J3RWUVD56ONTGSUHOGM184WW2-2", (name, clientRealmConstraint), unique=true)
  }
  /** Collection-like TableQuery object for table KeycloakRole */
  lazy val KeycloakRole = new TableQuery(tag => new KeycloakRole(tag))

  /** Entity class storing rows of table Link
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(36,true)
   *  @param itemUuid1 Database column item_uuid_1 SqlType(VARCHAR), Length(36,true)
   *  @param itemUuid2 Database column item_uuid_2 SqlType(VARCHAR), Length(36,true)
   *  @param author Database column author SqlType(VARCHAR), Length(36,true)
   *  @param timestamp Database column timestamp SqlType(TIMESTAMP) */
  case class LinkRow(id: Long, uuid: String, itemUuid1: String, itemUuid2: String, author: String, timestamp: java.sql.Timestamp)
  /** GetResult implicit for fetching LinkRow objects using plain SQL queries */
  implicit def GetResultLinkRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[LinkRow] = GR{
    prs => import prs._
    LinkRow.tupled((<<[Long], <<[String], <<[String], <<[String], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table link. Objects of this class serve as prototypes for rows in queries. */
  class Link(_tableTag: Tag) extends profile.api.Table[LinkRow](_tableTag, Some("chaman"), "link") {
    def * = (id, uuid, itemUuid1, itemUuid2, author, timestamp) <> (LinkRow.tupled, LinkRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(uuid), Rep.Some(itemUuid1), Rep.Some(itemUuid2), Rep.Some(author), Rep.Some(timestamp))).shaped.<>({r=>import r._; _1.map(_=> LinkRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(36,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(36,varying=true))
    /** Database column item_uuid_1 SqlType(VARCHAR), Length(36,true) */
    val itemUuid1: Rep[String] = column[String]("item_uuid_1", O.Length(36,varying=true))
    /** Database column item_uuid_2 SqlType(VARCHAR), Length(36,true) */
    val itemUuid2: Rep[String] = column[String]("item_uuid_2", O.Length(36,varying=true))
    /** Database column author SqlType(VARCHAR), Length(36,true) */
    val author: Rep[String] = column[String]("author", O.Length(36,varying=true))
    /** Database column timestamp SqlType(TIMESTAMP) */
    val timestamp: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("timestamp")

    /** Index over (itemUuid1,itemUuid2) (database name item_uuid_1) */
    val index1 = index("item_uuid_1", (itemUuid1, itemUuid2))
  }
  /** Collection-like TableQuery object for table Link */
  lazy val Link = new TableQuery(tag => new Link(tag))

  /** Entity class storing rows of table LinkRemoved
   *  @param fkLinkId Database column fk_link_id SqlType(BIGINT), PrimaryKey
   *  @param author Database column author SqlType(VARCHAR), Length(36,true)
   *  @param timestamp Database column timestamp SqlType(TIMESTAMP) */
  case class LinkRemovedRow(fkLinkId: Long, author: String, timestamp: java.sql.Timestamp)
  /** GetResult implicit for fetching LinkRemovedRow objects using plain SQL queries */
  implicit def GetResultLinkRemovedRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[LinkRemovedRow] = GR{
    prs => import prs._
    LinkRemovedRow.tupled((<<[Long], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table link_removed. Objects of this class serve as prototypes for rows in queries. */
  class LinkRemoved(_tableTag: Tag) extends profile.api.Table[LinkRemovedRow](_tableTag, Some("chaman"), "link_removed") {
    def * = (fkLinkId, author, timestamp) <> (LinkRemovedRow.tupled, LinkRemovedRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(fkLinkId), Rep.Some(author), Rep.Some(timestamp))).shaped.<>({r=>import r._; _1.map(_=> LinkRemovedRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column fk_link_id SqlType(BIGINT), PrimaryKey */
    val fkLinkId: Rep[Long] = column[Long]("fk_link_id", O.PrimaryKey)
    /** Database column author SqlType(VARCHAR), Length(36,true) */
    val author: Rep[String] = column[String]("author", O.Length(36,varying=true))
    /** Database column timestamp SqlType(TIMESTAMP) */
    val timestamp: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("timestamp")
  }
  /** Collection-like TableQuery object for table LinkRemoved */
  lazy val LinkRemoved = new TableQuery(tag => new LinkRemoved(tag))

  /** Entity class storing rows of table MigrationModel
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param version Database column VERSION SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param updateTime Database column UPDATE_TIME SqlType(BIGINT), Default(0) */
  case class MigrationModelRow(id: String, version: Option[String] = None, updateTime: Long = 0L)
  /** GetResult implicit for fetching MigrationModelRow objects using plain SQL queries */
  implicit def GetResultMigrationModelRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Long]): GR[MigrationModelRow] = GR{
    prs => import prs._
    MigrationModelRow.tupled((<<[String], <<?[String], <<[Long]))
  }
  /** Table description of table MIGRATION_MODEL. Objects of this class serve as prototypes for rows in queries. */
  class MigrationModel(_tableTag: Tag) extends profile.api.Table[MigrationModelRow](_tableTag, Some("chaman"), "MIGRATION_MODEL") {
    def * = (id, version, updateTime) <> (MigrationModelRow.tupled, MigrationModelRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), version, Rep.Some(updateTime))).shaped.<>({r=>import r._; _1.map(_=> MigrationModelRow.tupled((_1.get, _2, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column VERSION SqlType(VARCHAR), Length(36,true), Default(None) */
    val version: Rep[Option[String]] = column[Option[String]]("VERSION", O.Length(36,varying=true), O.Default(None))
    /** Database column UPDATE_TIME SqlType(BIGINT), Default(0) */
    val updateTime: Rep[Long] = column[Long]("UPDATE_TIME", O.Default(0L))

    /** Index over (updateTime) (database name IDX_UPDATE_TIME) */
    val index1 = index("IDX_UPDATE_TIME", updateTime)
  }
  /** Collection-like TableQuery object for table MigrationModel */
  lazy val MigrationModel = new TableQuery(tag => new MigrationModel(tag))

  /** Entity class storing rows of table OfflineClientSession
   *  @param userSessionId Database column USER_SESSION_ID SqlType(VARCHAR), Length(36,true)
   *  @param clientId Database column CLIENT_ID SqlType(VARCHAR), Length(255,true)
   *  @param offlineFlag Database column OFFLINE_FLAG SqlType(VARCHAR), Length(4,true)
   *  @param timestamp Database column TIMESTAMP SqlType(INT), Default(None)
   *  @param data Database column DATA SqlType(LONGTEXT), Length(2147483647,true), Default(None)
   *  @param clientStorageProvider Database column CLIENT_STORAGE_PROVIDER SqlType(VARCHAR), Length(36,true), Default(local)
   *  @param externalClientId Database column EXTERNAL_CLIENT_ID SqlType(VARCHAR), Length(255,true), Default(local) */
  case class OfflineClientSessionRow(userSessionId: String, clientId: String, offlineFlag: String, timestamp: Option[Int] = None, data: Option[String] = None, clientStorageProvider: String = "local", externalClientId: String = "local")
  /** GetResult implicit for fetching OfflineClientSessionRow objects using plain SQL queries */
  implicit def GetResultOfflineClientSessionRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]]): GR[OfflineClientSessionRow] = GR{
    prs => import prs._
    OfflineClientSessionRow.tupled((<<[String], <<[String], <<[String], <<?[Int], <<?[String], <<[String], <<[String]))
  }
  /** Table description of table OFFLINE_CLIENT_SESSION. Objects of this class serve as prototypes for rows in queries. */
  class OfflineClientSession(_tableTag: Tag) extends profile.api.Table[OfflineClientSessionRow](_tableTag, Some("chaman"), "OFFLINE_CLIENT_SESSION") {
    def * = (userSessionId, clientId, offlineFlag, timestamp, data, clientStorageProvider, externalClientId) <> (OfflineClientSessionRow.tupled, OfflineClientSessionRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(userSessionId), Rep.Some(clientId), Rep.Some(offlineFlag), timestamp, data, Rep.Some(clientStorageProvider), Rep.Some(externalClientId))).shaped.<>({r=>import r._; _1.map(_=> OfflineClientSessionRow.tupled((_1.get, _2.get, _3.get, _4, _5, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column USER_SESSION_ID SqlType(VARCHAR), Length(36,true) */
    val userSessionId: Rep[String] = column[String]("USER_SESSION_ID", O.Length(36,varying=true))
    /** Database column CLIENT_ID SqlType(VARCHAR), Length(255,true) */
    val clientId: Rep[String] = column[String]("CLIENT_ID", O.Length(255,varying=true))
    /** Database column OFFLINE_FLAG SqlType(VARCHAR), Length(4,true) */
    val offlineFlag: Rep[String] = column[String]("OFFLINE_FLAG", O.Length(4,varying=true))
    /** Database column TIMESTAMP SqlType(INT), Default(None) */
    val timestamp: Rep[Option[Int]] = column[Option[Int]]("TIMESTAMP", O.Default(None))
    /** Database column DATA SqlType(LONGTEXT), Length(2147483647,true), Default(None) */
    val data: Rep[Option[String]] = column[Option[String]]("DATA", O.Length(2147483647,varying=true), O.Default(None))
    /** Database column CLIENT_STORAGE_PROVIDER SqlType(VARCHAR), Length(36,true), Default(local) */
    val clientStorageProvider: Rep[String] = column[String]("CLIENT_STORAGE_PROVIDER", O.Length(36,varying=true), O.Default("local"))
    /** Database column EXTERNAL_CLIENT_ID SqlType(VARCHAR), Length(255,true), Default(local) */
    val externalClientId: Rep[String] = column[String]("EXTERNAL_CLIENT_ID", O.Length(255,varying=true), O.Default("local"))

    /** Primary key of OfflineClientSession (database name OFFLINE_CLIENT_SESSION_PK) */
    val pk = primaryKey("OFFLINE_CLIENT_SESSION_PK", (userSessionId, clientId, clientStorageProvider, externalClientId, offlineFlag))

    /** Index over (clientId,offlineFlag) (database name IDX_OFFLINE_CSS_PRELOAD) */
    val index1 = index("IDX_OFFLINE_CSS_PRELOAD", (clientId, offlineFlag))
    /** Index over (userSessionId) (database name IDX_US_SESS_ID_ON_CL_SESS) */
    val index2 = index("IDX_US_SESS_ID_ON_CL_SESS", userSessionId)
  }
  /** Collection-like TableQuery object for table OfflineClientSession */
  lazy val OfflineClientSession = new TableQuery(tag => new OfflineClientSession(tag))

  /** Entity class storing rows of table OfflineUserSession
   *  @param userSessionId Database column USER_SESSION_ID SqlType(VARCHAR), Length(36,true)
   *  @param userId Database column USER_ID SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(36,true)
   *  @param createdOn Database column CREATED_ON SqlType(INT)
   *  @param offlineFlag Database column OFFLINE_FLAG SqlType(VARCHAR), Length(4,true)
   *  @param data Database column DATA SqlType(LONGTEXT), Length(2147483647,true), Default(None)
   *  @param lastSessionRefresh Database column LAST_SESSION_REFRESH SqlType(INT), Default(0) */
  case class OfflineUserSessionRow(userSessionId: String, userId: Option[String] = None, realmId: String, createdOn: Int, offlineFlag: String, data: Option[String] = None, lastSessionRefresh: Int = 0)
  /** GetResult implicit for fetching OfflineUserSessionRow objects using plain SQL queries */
  implicit def GetResultOfflineUserSessionRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Int]): GR[OfflineUserSessionRow] = GR{
    prs => import prs._
    OfflineUserSessionRow.tupled((<<[String], <<?[String], <<[String], <<[Int], <<[String], <<?[String], <<[Int]))
  }
  /** Table description of table OFFLINE_USER_SESSION. Objects of this class serve as prototypes for rows in queries. */
  class OfflineUserSession(_tableTag: Tag) extends profile.api.Table[OfflineUserSessionRow](_tableTag, Some("chaman"), "OFFLINE_USER_SESSION") {
    def * = (userSessionId, userId, realmId, createdOn, offlineFlag, data, lastSessionRefresh) <> (OfflineUserSessionRow.tupled, OfflineUserSessionRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(userSessionId), userId, Rep.Some(realmId), Rep.Some(createdOn), Rep.Some(offlineFlag), data, Rep.Some(lastSessionRefresh))).shaped.<>({r=>import r._; _1.map(_=> OfflineUserSessionRow.tupled((_1.get, _2, _3.get, _4.get, _5.get, _6, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column USER_SESSION_ID SqlType(VARCHAR), Length(36,true) */
    val userSessionId: Rep[String] = column[String]("USER_SESSION_ID", O.Length(36,varying=true))
    /** Database column USER_ID SqlType(VARCHAR), Length(255,true), Default(None) */
    val userId: Rep[Option[String]] = column[Option[String]]("USER_ID", O.Length(255,varying=true), O.Default(None))
    /** Database column REALM_ID SqlType(VARCHAR), Length(36,true) */
    val realmId: Rep[String] = column[String]("REALM_ID", O.Length(36,varying=true))
    /** Database column CREATED_ON SqlType(INT) */
    val createdOn: Rep[Int] = column[Int]("CREATED_ON")
    /** Database column OFFLINE_FLAG SqlType(VARCHAR), Length(4,true) */
    val offlineFlag: Rep[String] = column[String]("OFFLINE_FLAG", O.Length(4,varying=true))
    /** Database column DATA SqlType(LONGTEXT), Length(2147483647,true), Default(None) */
    val data: Rep[Option[String]] = column[Option[String]]("DATA", O.Length(2147483647,varying=true), O.Default(None))
    /** Database column LAST_SESSION_REFRESH SqlType(INT), Default(0) */
    val lastSessionRefresh: Rep[Int] = column[Int]("LAST_SESSION_REFRESH", O.Default(0))

    /** Primary key of OfflineUserSession (database name OFFLINE_USER_SESSION_PK) */
    val pk = primaryKey("OFFLINE_USER_SESSION_PK", (userSessionId, offlineFlag))

    /** Index over (userId,realmId,offlineFlag) (database name IDX_OFFLINE_USS_BY_USER) */
    val index1 = index("IDX_OFFLINE_USS_BY_USER", (userId, realmId, offlineFlag))
    /** Index over (realmId,offlineFlag,userSessionId) (database name IDX_OFFLINE_USS_BY_USERSESS) */
    val index2 = index("IDX_OFFLINE_USS_BY_USERSESS", (realmId, offlineFlag, userSessionId))
    /** Index over (createdOn) (database name IDX_OFFLINE_USS_CREATEDON) */
    val index3 = index("IDX_OFFLINE_USS_CREATEDON", createdOn)
    /** Index over (offlineFlag,createdOn,userSessionId) (database name IDX_OFFLINE_USS_PRELOAD) */
    val index4 = index("IDX_OFFLINE_USS_PRELOAD", (offlineFlag, createdOn, userSessionId))
  }
  /** Collection-like TableQuery object for table OfflineUserSession */
  lazy val OfflineUserSession = new TableQuery(tag => new OfflineUserSession(tag))

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

  /** Entity class storing rows of table PolicyConfig
   *  @param policyId Database column POLICY_ID SqlType(VARCHAR), Length(36,true)
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true)
   *  @param value Database column VALUE SqlType(LONGTEXT), Length(2147483647,true), Default(None) */
  case class PolicyConfigRow(policyId: String, name: String, value: Option[String] = None)
  /** GetResult implicit for fetching PolicyConfigRow objects using plain SQL queries */
  implicit def GetResultPolicyConfigRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[PolicyConfigRow] = GR{
    prs => import prs._
    PolicyConfigRow.tupled((<<[String], <<[String], <<?[String]))
  }
  /** Table description of table POLICY_CONFIG. Objects of this class serve as prototypes for rows in queries. */
  class PolicyConfig(_tableTag: Tag) extends profile.api.Table[PolicyConfigRow](_tableTag, Some("chaman"), "POLICY_CONFIG") {
    def * = (policyId, name, value) <> (PolicyConfigRow.tupled, PolicyConfigRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(policyId), Rep.Some(name), value)).shaped.<>({r=>import r._; _1.map(_=> PolicyConfigRow.tupled((_1.get, _2.get, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column POLICY_ID SqlType(VARCHAR), Length(36,true) */
    val policyId: Rep[String] = column[String]("POLICY_ID", O.Length(36,varying=true))
    /** Database column NAME SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("NAME", O.Length(255,varying=true))
    /** Database column VALUE SqlType(LONGTEXT), Length(2147483647,true), Default(None) */
    val value: Rep[Option[String]] = column[Option[String]]("VALUE", O.Length(2147483647,varying=true), O.Default(None))

    /** Primary key of PolicyConfig (database name POLICY_CONFIG_PK) */
    val pk = primaryKey("POLICY_CONFIG_PK", (policyId, name))

    /** Foreign key referencing ResourceServerPolicy (database name FKDC34197CF864C4E43) */
    lazy val resourceServerPolicyFk = foreignKey("FKDC34197CF864C4E43", policyId, ResourceServerPolicy)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table PolicyConfig */
  lazy val PolicyConfig = new TableQuery(tag => new PolicyConfig(tag))

  /** Entity class storing rows of table ProtocolMapper
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true)
   *  @param protocol Database column PROTOCOL SqlType(VARCHAR), Length(255,true)
   *  @param protocolMapperName Database column PROTOCOL_MAPPER_NAME SqlType(VARCHAR), Length(255,true)
   *  @param clientId Database column CLIENT_ID SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param clientScopeId Database column CLIENT_SCOPE_ID SqlType(VARCHAR), Length(36,true), Default(None) */
  case class ProtocolMapperRow(id: String, name: String, protocol: String, protocolMapperName: String, clientId: Option[String] = None, clientScopeId: Option[String] = None)
  /** GetResult implicit for fetching ProtocolMapperRow objects using plain SQL queries */
  implicit def GetResultProtocolMapperRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[ProtocolMapperRow] = GR{
    prs => import prs._
    ProtocolMapperRow.tupled((<<[String], <<[String], <<[String], <<[String], <<?[String], <<?[String]))
  }
  /** Table description of table PROTOCOL_MAPPER. Objects of this class serve as prototypes for rows in queries. */
  class ProtocolMapper(_tableTag: Tag) extends profile.api.Table[ProtocolMapperRow](_tableTag, Some("chaman"), "PROTOCOL_MAPPER") {
    def * = (id, name, protocol, protocolMapperName, clientId, clientScopeId) <> (ProtocolMapperRow.tupled, ProtocolMapperRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(name), Rep.Some(protocol), Rep.Some(protocolMapperName), clientId, clientScopeId)).shaped.<>({r=>import r._; _1.map(_=> ProtocolMapperRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column NAME SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("NAME", O.Length(255,varying=true))
    /** Database column PROTOCOL SqlType(VARCHAR), Length(255,true) */
    val protocol: Rep[String] = column[String]("PROTOCOL", O.Length(255,varying=true))
    /** Database column PROTOCOL_MAPPER_NAME SqlType(VARCHAR), Length(255,true) */
    val protocolMapperName: Rep[String] = column[String]("PROTOCOL_MAPPER_NAME", O.Length(255,varying=true))
    /** Database column CLIENT_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val clientId: Rep[Option[String]] = column[Option[String]]("CLIENT_ID", O.Length(36,varying=true), O.Default(None))
    /** Database column CLIENT_SCOPE_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val clientScopeId: Rep[Option[String]] = column[Option[String]]("CLIENT_SCOPE_ID", O.Length(36,varying=true), O.Default(None))

    /** Foreign key referencing Client (database name FK_PCM_REALM) */
    lazy val clientFk = foreignKey("FK_PCM_REALM", clientId, Client)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing ClientScope (database name FK_CLI_SCOPE_MAPPER) */
    lazy val clientScopeFk = foreignKey("FK_CLI_SCOPE_MAPPER", clientScopeId, ClientScope)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table ProtocolMapper */
  lazy val ProtocolMapper = new TableQuery(tag => new ProtocolMapper(tag))

  /** Entity class storing rows of table ProtocolMapperConfig
   *  @param protocolMapperId Database column PROTOCOL_MAPPER_ID SqlType(VARCHAR), Length(36,true)
   *  @param value Database column VALUE SqlType(LONGTEXT), Length(2147483647,true), Default(None)
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true) */
  case class ProtocolMapperConfigRow(protocolMapperId: String, value: Option[String] = None, name: String)
  /** GetResult implicit for fetching ProtocolMapperConfigRow objects using plain SQL queries */
  implicit def GetResultProtocolMapperConfigRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[ProtocolMapperConfigRow] = GR{
    prs => import prs._
    ProtocolMapperConfigRow.tupled((<<[String], <<?[String], <<[String]))
  }
  /** Table description of table PROTOCOL_MAPPER_CONFIG. Objects of this class serve as prototypes for rows in queries. */
  class ProtocolMapperConfig(_tableTag: Tag) extends profile.api.Table[ProtocolMapperConfigRow](_tableTag, Some("chaman"), "PROTOCOL_MAPPER_CONFIG") {
    def * = (protocolMapperId, value, name) <> (ProtocolMapperConfigRow.tupled, ProtocolMapperConfigRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(protocolMapperId), value, Rep.Some(name))).shaped.<>({r=>import r._; _1.map(_=> ProtocolMapperConfigRow.tupled((_1.get, _2, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column PROTOCOL_MAPPER_ID SqlType(VARCHAR), Length(36,true) */
    val protocolMapperId: Rep[String] = column[String]("PROTOCOL_MAPPER_ID", O.Length(36,varying=true))
    /** Database column VALUE SqlType(LONGTEXT), Length(2147483647,true), Default(None) */
    val value: Rep[Option[String]] = column[Option[String]]("VALUE", O.Length(2147483647,varying=true), O.Default(None))
    /** Database column NAME SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("NAME", O.Length(255,varying=true))

    /** Primary key of ProtocolMapperConfig (database name PROTOCOL_MAPPER_CONFIG_PK) */
    val pk = primaryKey("PROTOCOL_MAPPER_CONFIG_PK", (protocolMapperId, name))

    /** Foreign key referencing ProtocolMapper (database name FK_PMCONFIG) */
    lazy val protocolMapperFk = foreignKey("FK_PMCONFIG", protocolMapperId, ProtocolMapper)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table ProtocolMapperConfig */
  lazy val ProtocolMapperConfig = new TableQuery(tag => new ProtocolMapperConfig(tag))

  /** Entity class storing rows of table Realm
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param accessCodeLifespan Database column ACCESS_CODE_LIFESPAN SqlType(INT), Default(None)
   *  @param userActionLifespan Database column USER_ACTION_LIFESPAN SqlType(INT), Default(None)
   *  @param accessTokenLifespan Database column ACCESS_TOKEN_LIFESPAN SqlType(INT), Default(None)
   *  @param accountTheme Database column ACCOUNT_THEME SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param adminTheme Database column ADMIN_THEME SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param emailTheme Database column EMAIL_THEME SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param enabled Database column ENABLED SqlType(BIT), Default(false)
   *  @param eventsEnabled Database column EVENTS_ENABLED SqlType(BIT), Default(false)
   *  @param eventsExpiration Database column EVENTS_EXPIRATION SqlType(BIGINT), Default(None)
   *  @param loginTheme Database column LOGIN_THEME SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param notBefore Database column NOT_BEFORE SqlType(INT), Default(None)
   *  @param passwordPolicy Database column PASSWORD_POLICY SqlType(TEXT), Default(None)
   *  @param registrationAllowed Database column REGISTRATION_ALLOWED SqlType(BIT), Default(false)
   *  @param rememberMe Database column REMEMBER_ME SqlType(BIT), Default(false)
   *  @param resetPasswordAllowed Database column RESET_PASSWORD_ALLOWED SqlType(BIT), Default(false)
   *  @param social Database column SOCIAL SqlType(BIT), Default(false)
   *  @param sslRequired Database column SSL_REQUIRED SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param ssoIdleTimeout Database column SSO_IDLE_TIMEOUT SqlType(INT), Default(None)
   *  @param ssoMaxLifespan Database column SSO_MAX_LIFESPAN SqlType(INT), Default(None)
   *  @param updateProfileOnSocLogin Database column UPDATE_PROFILE_ON_SOC_LOGIN SqlType(BIT), Default(false)
   *  @param verifyEmail Database column VERIFY_EMAIL SqlType(BIT), Default(false)
   *  @param masterAdminClient Database column MASTER_ADMIN_CLIENT SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param loginLifespan Database column LOGIN_LIFESPAN SqlType(INT), Default(None)
   *  @param internationalizationEnabled Database column INTERNATIONALIZATION_ENABLED SqlType(BIT), Default(false)
   *  @param defaultLocale Database column DEFAULT_LOCALE SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param regEmailAsUsername Database column REG_EMAIL_AS_USERNAME SqlType(BIT), Default(false)
   *  @param adminEventsEnabled Database column ADMIN_EVENTS_ENABLED SqlType(BIT), Default(false)
   *  @param adminEventsDetailsEnabled Database column ADMIN_EVENTS_DETAILS_ENABLED SqlType(BIT), Default(false)
   *  @param editUsernameAllowed Database column EDIT_USERNAME_ALLOWED SqlType(BIT), Default(false)
   *  @param otpPolicyCounter Database column OTP_POLICY_COUNTER SqlType(INT), Default(Some(0))
   *  @param otpPolicyWindow Database column OTP_POLICY_WINDOW SqlType(INT), Default(Some(1))
   *  @param otpPolicyPeriod Database column OTP_POLICY_PERIOD SqlType(INT), Default(Some(30))
   *  @param otpPolicyDigits Database column OTP_POLICY_DIGITS SqlType(INT), Default(Some(6))
   *  @param otpPolicyAlg Database column OTP_POLICY_ALG SqlType(VARCHAR), Length(36,true), Default(Some(HmacSHA1))
   *  @param otpPolicyType Database column OTP_POLICY_TYPE SqlType(VARCHAR), Length(36,true), Default(Some(totp))
   *  @param browserFlow Database column BROWSER_FLOW SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param registrationFlow Database column REGISTRATION_FLOW SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param directGrantFlow Database column DIRECT_GRANT_FLOW SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param resetCredentialsFlow Database column RESET_CREDENTIALS_FLOW SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param clientAuthFlow Database column CLIENT_AUTH_FLOW SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param offlineSessionIdleTimeout Database column OFFLINE_SESSION_IDLE_TIMEOUT SqlType(INT), Default(Some(0))
   *  @param revokeRefreshToken Database column REVOKE_REFRESH_TOKEN SqlType(BIT), Default(false)
   *  @param accessTokenLifeImplicit Database column ACCESS_TOKEN_LIFE_IMPLICIT SqlType(INT), Default(Some(0))
   *  @param loginWithEmailAllowed Database column LOGIN_WITH_EMAIL_ALLOWED SqlType(BIT), Default(true)
   *  @param duplicateEmailsAllowed Database column DUPLICATE_EMAILS_ALLOWED SqlType(BIT), Default(false)
   *  @param dockerAuthFlow Database column DOCKER_AUTH_FLOW SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param refreshTokenMaxReuse Database column REFRESH_TOKEN_MAX_REUSE SqlType(INT), Default(Some(0))
   *  @param allowUserManagedAccess Database column ALLOW_USER_MANAGED_ACCESS SqlType(BIT), Default(false)
   *  @param ssoMaxLifespanRememberMe Database column SSO_MAX_LIFESPAN_REMEMBER_ME SqlType(INT)
   *  @param ssoIdleTimeoutRememberMe Database column SSO_IDLE_TIMEOUT_REMEMBER_ME SqlType(INT)
   *  @param defaultRole Database column DEFAULT_ROLE SqlType(VARCHAR), Length(255,true), Default(None) */
  case class RealmRow(id: String, accessCodeLifespan: Option[Int] = None, userActionLifespan: Option[Int] = None, accessTokenLifespan: Option[Int] = None, accountTheme: Option[String] = None, adminTheme: Option[String] = None, emailTheme: Option[String] = None, enabled: Boolean = false, eventsEnabled: Boolean = false, eventsExpiration: Option[Long] = None, loginTheme: Option[String] = None, name: Option[String] = None, notBefore: Option[Int] = None, passwordPolicy: Option[String] = None, registrationAllowed: Boolean = false, rememberMe: Boolean = false, resetPasswordAllowed: Boolean = false, social: Boolean = false, sslRequired: Option[String] = None, ssoIdleTimeout: Option[Int] = None, ssoMaxLifespan: Option[Int] = None, updateProfileOnSocLogin: Boolean = false, verifyEmail: Boolean = false, masterAdminClient: Option[String] = None, loginLifespan: Option[Int] = None, internationalizationEnabled: Boolean = false, defaultLocale: Option[String] = None, regEmailAsUsername: Boolean = false, adminEventsEnabled: Boolean = false, adminEventsDetailsEnabled: Boolean = false, editUsernameAllowed: Boolean = false, otpPolicyCounter: Option[Int] = Some(0), otpPolicyWindow: Option[Int] = Some(1), otpPolicyPeriod: Option[Int] = Some(30), otpPolicyDigits: Option[Int] = Some(6), otpPolicyAlg: Option[String] = Some("HmacSHA1"), otpPolicyType: Option[String] = Some("totp"), browserFlow: Option[String] = None, registrationFlow: Option[String] = None, directGrantFlow: Option[String] = None, resetCredentialsFlow: Option[String] = None, clientAuthFlow: Option[String] = None, offlineSessionIdleTimeout: Option[Int] = Some(0), revokeRefreshToken: Boolean = false, accessTokenLifeImplicit: Option[Int] = Some(0), loginWithEmailAllowed: Boolean = true, duplicateEmailsAllowed: Boolean = false, dockerAuthFlow: Option[String] = None, refreshTokenMaxReuse: Option[Int] = Some(0), allowUserManagedAccess: Boolean = false, ssoMaxLifespanRememberMe: Int, ssoIdleTimeoutRememberMe: Int, defaultRole: Option[String] = None)
  /** GetResult implicit for fetching RealmRow objects using plain SQL queries */
  implicit def GetResultRealmRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Boolean], e4: GR[Option[Long]], e5: GR[Int]): GR[RealmRow] = GR{
    prs => import prs._
    RealmRow(<<[String], <<?[Int], <<?[Int], <<?[Int], <<?[String], <<?[String], <<?[String], <<[Boolean], <<[Boolean], <<?[Long], <<?[String], <<?[String], <<?[Int], <<?[String], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<?[String], <<?[Int], <<?[Int], <<[Boolean], <<[Boolean], <<?[String], <<?[Int], <<[Boolean], <<?[String], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Int], <<[Boolean], <<?[Int], <<[Boolean], <<[Boolean], <<?[String], <<?[Int], <<[Boolean], <<[Int], <<[Int], <<?[String])
  }
  /** Table description of table REALM. Objects of this class serve as prototypes for rows in queries. */
  class Realm(_tableTag: Tag) extends profile.api.Table[RealmRow](_tableTag, Some("chaman"), "REALM") {
    def * = (id :: accessCodeLifespan :: userActionLifespan :: accessTokenLifespan :: accountTheme :: adminTheme :: emailTheme :: enabled :: eventsEnabled :: eventsExpiration :: loginTheme :: name :: notBefore :: passwordPolicy :: registrationAllowed :: rememberMe :: resetPasswordAllowed :: social :: sslRequired :: ssoIdleTimeout :: ssoMaxLifespan :: updateProfileOnSocLogin :: verifyEmail :: masterAdminClient :: loginLifespan :: internationalizationEnabled :: defaultLocale :: regEmailAsUsername :: adminEventsEnabled :: adminEventsDetailsEnabled :: editUsernameAllowed :: otpPolicyCounter :: otpPolicyWindow :: otpPolicyPeriod :: otpPolicyDigits :: otpPolicyAlg :: otpPolicyType :: browserFlow :: registrationFlow :: directGrantFlow :: resetCredentialsFlow :: clientAuthFlow :: offlineSessionIdleTimeout :: revokeRefreshToken :: accessTokenLifeImplicit :: loginWithEmailAllowed :: duplicateEmailsAllowed :: dockerAuthFlow :: refreshTokenMaxReuse :: allowUserManagedAccess :: ssoMaxLifespanRememberMe :: ssoIdleTimeoutRememberMe :: defaultRole :: HNil).mapTo[RealmRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id) :: accessCodeLifespan :: userActionLifespan :: accessTokenLifespan :: accountTheme :: adminTheme :: emailTheme :: Rep.Some(enabled) :: Rep.Some(eventsEnabled) :: eventsExpiration :: loginTheme :: name :: notBefore :: passwordPolicy :: Rep.Some(registrationAllowed) :: Rep.Some(rememberMe) :: Rep.Some(resetPasswordAllowed) :: Rep.Some(social) :: sslRequired :: ssoIdleTimeout :: ssoMaxLifespan :: Rep.Some(updateProfileOnSocLogin) :: Rep.Some(verifyEmail) :: masterAdminClient :: loginLifespan :: Rep.Some(internationalizationEnabled) :: defaultLocale :: Rep.Some(regEmailAsUsername) :: Rep.Some(adminEventsEnabled) :: Rep.Some(adminEventsDetailsEnabled) :: Rep.Some(editUsernameAllowed) :: otpPolicyCounter :: otpPolicyWindow :: otpPolicyPeriod :: otpPolicyDigits :: otpPolicyAlg :: otpPolicyType :: browserFlow :: registrationFlow :: directGrantFlow :: resetCredentialsFlow :: clientAuthFlow :: offlineSessionIdleTimeout :: Rep.Some(revokeRefreshToken) :: accessTokenLifeImplicit :: Rep.Some(loginWithEmailAllowed) :: Rep.Some(duplicateEmailsAllowed) :: dockerAuthFlow :: refreshTokenMaxReuse :: Rep.Some(allowUserManagedAccess) :: Rep.Some(ssoMaxLifespanRememberMe) :: Rep.Some(ssoIdleTimeoutRememberMe) :: defaultRole :: HNil).shaped.<>(r => RealmRow(r(0).asInstanceOf[Option[String]].get, r(1).asInstanceOf[Option[Int]], r(2).asInstanceOf[Option[Int]], r(3).asInstanceOf[Option[Int]], r(4).asInstanceOf[Option[String]], r(5).asInstanceOf[Option[String]], r(6).asInstanceOf[Option[String]], r(7).asInstanceOf[Option[Boolean]].get, r(8).asInstanceOf[Option[Boolean]].get, r(9).asInstanceOf[Option[Long]], r(10).asInstanceOf[Option[String]], r(11).asInstanceOf[Option[String]], r(12).asInstanceOf[Option[Int]], r(13).asInstanceOf[Option[String]], r(14).asInstanceOf[Option[Boolean]].get, r(15).asInstanceOf[Option[Boolean]].get, r(16).asInstanceOf[Option[Boolean]].get, r(17).asInstanceOf[Option[Boolean]].get, r(18).asInstanceOf[Option[String]], r(19).asInstanceOf[Option[Int]], r(20).asInstanceOf[Option[Int]], r(21).asInstanceOf[Option[Boolean]].get, r(22).asInstanceOf[Option[Boolean]].get, r(23).asInstanceOf[Option[String]], r(24).asInstanceOf[Option[Int]], r(25).asInstanceOf[Option[Boolean]].get, r(26).asInstanceOf[Option[String]], r(27).asInstanceOf[Option[Boolean]].get, r(28).asInstanceOf[Option[Boolean]].get, r(29).asInstanceOf[Option[Boolean]].get, r(30).asInstanceOf[Option[Boolean]].get, r(31).asInstanceOf[Option[Int]], r(32).asInstanceOf[Option[Int]], r(33).asInstanceOf[Option[Int]], r(34).asInstanceOf[Option[Int]], r(35).asInstanceOf[Option[String]], r(36).asInstanceOf[Option[String]], r(37).asInstanceOf[Option[String]], r(38).asInstanceOf[Option[String]], r(39).asInstanceOf[Option[String]], r(40).asInstanceOf[Option[String]], r(41).asInstanceOf[Option[String]], r(42).asInstanceOf[Option[Int]], r(43).asInstanceOf[Option[Boolean]].get, r(44).asInstanceOf[Option[Int]], r(45).asInstanceOf[Option[Boolean]].get, r(46).asInstanceOf[Option[Boolean]].get, r(47).asInstanceOf[Option[String]], r(48).asInstanceOf[Option[Int]], r(49).asInstanceOf[Option[Boolean]].get, r(50).asInstanceOf[Option[Int]].get, r(51).asInstanceOf[Option[Int]].get, r(52).asInstanceOf[Option[String]]), (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column ACCESS_CODE_LIFESPAN SqlType(INT), Default(None) */
    val accessCodeLifespan: Rep[Option[Int]] = column[Option[Int]]("ACCESS_CODE_LIFESPAN", O.Default(None))
    /** Database column USER_ACTION_LIFESPAN SqlType(INT), Default(None) */
    val userActionLifespan: Rep[Option[Int]] = column[Option[Int]]("USER_ACTION_LIFESPAN", O.Default(None))
    /** Database column ACCESS_TOKEN_LIFESPAN SqlType(INT), Default(None) */
    val accessTokenLifespan: Rep[Option[Int]] = column[Option[Int]]("ACCESS_TOKEN_LIFESPAN", O.Default(None))
    /** Database column ACCOUNT_THEME SqlType(VARCHAR), Length(255,true), Default(None) */
    val accountTheme: Rep[Option[String]] = column[Option[String]]("ACCOUNT_THEME", O.Length(255,varying=true), O.Default(None))
    /** Database column ADMIN_THEME SqlType(VARCHAR), Length(255,true), Default(None) */
    val adminTheme: Rep[Option[String]] = column[Option[String]]("ADMIN_THEME", O.Length(255,varying=true), O.Default(None))
    /** Database column EMAIL_THEME SqlType(VARCHAR), Length(255,true), Default(None) */
    val emailTheme: Rep[Option[String]] = column[Option[String]]("EMAIL_THEME", O.Length(255,varying=true), O.Default(None))
    /** Database column ENABLED SqlType(BIT), Default(false) */
    val enabled: Rep[Boolean] = column[Boolean]("ENABLED", O.Default(false))
    /** Database column EVENTS_ENABLED SqlType(BIT), Default(false) */
    val eventsEnabled: Rep[Boolean] = column[Boolean]("EVENTS_ENABLED", O.Default(false))
    /** Database column EVENTS_EXPIRATION SqlType(BIGINT), Default(None) */
    val eventsExpiration: Rep[Option[Long]] = column[Option[Long]]("EVENTS_EXPIRATION", O.Default(None))
    /** Database column LOGIN_THEME SqlType(VARCHAR), Length(255,true), Default(None) */
    val loginTheme: Rep[Option[String]] = column[Option[String]]("LOGIN_THEME", O.Length(255,varying=true), O.Default(None))
    /** Database column NAME SqlType(VARCHAR), Length(255,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("NAME", O.Length(255,varying=true), O.Default(None))
    /** Database column NOT_BEFORE SqlType(INT), Default(None) */
    val notBefore: Rep[Option[Int]] = column[Option[Int]]("NOT_BEFORE", O.Default(None))
    /** Database column PASSWORD_POLICY SqlType(TEXT), Default(None) */
    val passwordPolicy: Rep[Option[String]] = column[Option[String]]("PASSWORD_POLICY", O.Default(None))
    /** Database column REGISTRATION_ALLOWED SqlType(BIT), Default(false) */
    val registrationAllowed: Rep[Boolean] = column[Boolean]("REGISTRATION_ALLOWED", O.Default(false))
    /** Database column REMEMBER_ME SqlType(BIT), Default(false) */
    val rememberMe: Rep[Boolean] = column[Boolean]("REMEMBER_ME", O.Default(false))
    /** Database column RESET_PASSWORD_ALLOWED SqlType(BIT), Default(false) */
    val resetPasswordAllowed: Rep[Boolean] = column[Boolean]("RESET_PASSWORD_ALLOWED", O.Default(false))
    /** Database column SOCIAL SqlType(BIT), Default(false) */
    val social: Rep[Boolean] = column[Boolean]("SOCIAL", O.Default(false))
    /** Database column SSL_REQUIRED SqlType(VARCHAR), Length(255,true), Default(None) */
    val sslRequired: Rep[Option[String]] = column[Option[String]]("SSL_REQUIRED", O.Length(255,varying=true), O.Default(None))
    /** Database column SSO_IDLE_TIMEOUT SqlType(INT), Default(None) */
    val ssoIdleTimeout: Rep[Option[Int]] = column[Option[Int]]("SSO_IDLE_TIMEOUT", O.Default(None))
    /** Database column SSO_MAX_LIFESPAN SqlType(INT), Default(None) */
    val ssoMaxLifespan: Rep[Option[Int]] = column[Option[Int]]("SSO_MAX_LIFESPAN", O.Default(None))
    /** Database column UPDATE_PROFILE_ON_SOC_LOGIN SqlType(BIT), Default(false) */
    val updateProfileOnSocLogin: Rep[Boolean] = column[Boolean]("UPDATE_PROFILE_ON_SOC_LOGIN", O.Default(false))
    /** Database column VERIFY_EMAIL SqlType(BIT), Default(false) */
    val verifyEmail: Rep[Boolean] = column[Boolean]("VERIFY_EMAIL", O.Default(false))
    /** Database column MASTER_ADMIN_CLIENT SqlType(VARCHAR), Length(36,true), Default(None) */
    val masterAdminClient: Rep[Option[String]] = column[Option[String]]("MASTER_ADMIN_CLIENT", O.Length(36,varying=true), O.Default(None))
    /** Database column LOGIN_LIFESPAN SqlType(INT), Default(None) */
    val loginLifespan: Rep[Option[Int]] = column[Option[Int]]("LOGIN_LIFESPAN", O.Default(None))
    /** Database column INTERNATIONALIZATION_ENABLED SqlType(BIT), Default(false) */
    val internationalizationEnabled: Rep[Boolean] = column[Boolean]("INTERNATIONALIZATION_ENABLED", O.Default(false))
    /** Database column DEFAULT_LOCALE SqlType(VARCHAR), Length(255,true), Default(None) */
    val defaultLocale: Rep[Option[String]] = column[Option[String]]("DEFAULT_LOCALE", O.Length(255,varying=true), O.Default(None))
    /** Database column REG_EMAIL_AS_USERNAME SqlType(BIT), Default(false) */
    val regEmailAsUsername: Rep[Boolean] = column[Boolean]("REG_EMAIL_AS_USERNAME", O.Default(false))
    /** Database column ADMIN_EVENTS_ENABLED SqlType(BIT), Default(false) */
    val adminEventsEnabled: Rep[Boolean] = column[Boolean]("ADMIN_EVENTS_ENABLED", O.Default(false))
    /** Database column ADMIN_EVENTS_DETAILS_ENABLED SqlType(BIT), Default(false) */
    val adminEventsDetailsEnabled: Rep[Boolean] = column[Boolean]("ADMIN_EVENTS_DETAILS_ENABLED", O.Default(false))
    /** Database column EDIT_USERNAME_ALLOWED SqlType(BIT), Default(false) */
    val editUsernameAllowed: Rep[Boolean] = column[Boolean]("EDIT_USERNAME_ALLOWED", O.Default(false))
    /** Database column OTP_POLICY_COUNTER SqlType(INT), Default(Some(0)) */
    val otpPolicyCounter: Rep[Option[Int]] = column[Option[Int]]("OTP_POLICY_COUNTER", O.Default(Some(0)))
    /** Database column OTP_POLICY_WINDOW SqlType(INT), Default(Some(1)) */
    val otpPolicyWindow: Rep[Option[Int]] = column[Option[Int]]("OTP_POLICY_WINDOW", O.Default(Some(1)))
    /** Database column OTP_POLICY_PERIOD SqlType(INT), Default(Some(30)) */
    val otpPolicyPeriod: Rep[Option[Int]] = column[Option[Int]]("OTP_POLICY_PERIOD", O.Default(Some(30)))
    /** Database column OTP_POLICY_DIGITS SqlType(INT), Default(Some(6)) */
    val otpPolicyDigits: Rep[Option[Int]] = column[Option[Int]]("OTP_POLICY_DIGITS", O.Default(Some(6)))
    /** Database column OTP_POLICY_ALG SqlType(VARCHAR), Length(36,true), Default(Some(HmacSHA1)) */
    val otpPolicyAlg: Rep[Option[String]] = column[Option[String]]("OTP_POLICY_ALG", O.Length(36,varying=true), O.Default(Some("HmacSHA1")))
    /** Database column OTP_POLICY_TYPE SqlType(VARCHAR), Length(36,true), Default(Some(totp)) */
    val otpPolicyType: Rep[Option[String]] = column[Option[String]]("OTP_POLICY_TYPE", O.Length(36,varying=true), O.Default(Some("totp")))
    /** Database column BROWSER_FLOW SqlType(VARCHAR), Length(36,true), Default(None) */
    val browserFlow: Rep[Option[String]] = column[Option[String]]("BROWSER_FLOW", O.Length(36,varying=true), O.Default(None))
    /** Database column REGISTRATION_FLOW SqlType(VARCHAR), Length(36,true), Default(None) */
    val registrationFlow: Rep[Option[String]] = column[Option[String]]("REGISTRATION_FLOW", O.Length(36,varying=true), O.Default(None))
    /** Database column DIRECT_GRANT_FLOW SqlType(VARCHAR), Length(36,true), Default(None) */
    val directGrantFlow: Rep[Option[String]] = column[Option[String]]("DIRECT_GRANT_FLOW", O.Length(36,varying=true), O.Default(None))
    /** Database column RESET_CREDENTIALS_FLOW SqlType(VARCHAR), Length(36,true), Default(None) */
    val resetCredentialsFlow: Rep[Option[String]] = column[Option[String]]("RESET_CREDENTIALS_FLOW", O.Length(36,varying=true), O.Default(None))
    /** Database column CLIENT_AUTH_FLOW SqlType(VARCHAR), Length(36,true), Default(None) */
    val clientAuthFlow: Rep[Option[String]] = column[Option[String]]("CLIENT_AUTH_FLOW", O.Length(36,varying=true), O.Default(None))
    /** Database column OFFLINE_SESSION_IDLE_TIMEOUT SqlType(INT), Default(Some(0)) */
    val offlineSessionIdleTimeout: Rep[Option[Int]] = column[Option[Int]]("OFFLINE_SESSION_IDLE_TIMEOUT", O.Default(Some(0)))
    /** Database column REVOKE_REFRESH_TOKEN SqlType(BIT), Default(false) */
    val revokeRefreshToken: Rep[Boolean] = column[Boolean]("REVOKE_REFRESH_TOKEN", O.Default(false))
    /** Database column ACCESS_TOKEN_LIFE_IMPLICIT SqlType(INT), Default(Some(0)) */
    val accessTokenLifeImplicit: Rep[Option[Int]] = column[Option[Int]]("ACCESS_TOKEN_LIFE_IMPLICIT", O.Default(Some(0)))
    /** Database column LOGIN_WITH_EMAIL_ALLOWED SqlType(BIT), Default(true) */
    val loginWithEmailAllowed: Rep[Boolean] = column[Boolean]("LOGIN_WITH_EMAIL_ALLOWED", O.Default(true))
    /** Database column DUPLICATE_EMAILS_ALLOWED SqlType(BIT), Default(false) */
    val duplicateEmailsAllowed: Rep[Boolean] = column[Boolean]("DUPLICATE_EMAILS_ALLOWED", O.Default(false))
    /** Database column DOCKER_AUTH_FLOW SqlType(VARCHAR), Length(36,true), Default(None) */
    val dockerAuthFlow: Rep[Option[String]] = column[Option[String]]("DOCKER_AUTH_FLOW", O.Length(36,varying=true), O.Default(None))
    /** Database column REFRESH_TOKEN_MAX_REUSE SqlType(INT), Default(Some(0)) */
    val refreshTokenMaxReuse: Rep[Option[Int]] = column[Option[Int]]("REFRESH_TOKEN_MAX_REUSE", O.Default(Some(0)))
    /** Database column ALLOW_USER_MANAGED_ACCESS SqlType(BIT), Default(false) */
    val allowUserManagedAccess: Rep[Boolean] = column[Boolean]("ALLOW_USER_MANAGED_ACCESS", O.Default(false))
    /** Database column SSO_MAX_LIFESPAN_REMEMBER_ME SqlType(INT) */
    val ssoMaxLifespanRememberMe: Rep[Int] = column[Int]("SSO_MAX_LIFESPAN_REMEMBER_ME")
    /** Database column SSO_IDLE_TIMEOUT_REMEMBER_ME SqlType(INT) */
    val ssoIdleTimeoutRememberMe: Rep[Int] = column[Int]("SSO_IDLE_TIMEOUT_REMEMBER_ME")
    /** Database column DEFAULT_ROLE SqlType(VARCHAR), Length(255,true), Default(None) */
    val defaultRole: Rep[Option[String]] = column[Option[String]]("DEFAULT_ROLE", O.Length(255,varying=true), O.Default(None))

    /** Index over (masterAdminClient) (database name IDX_REALM_MASTER_ADM_CLI) */
    val index1 = index("IDX_REALM_MASTER_ADM_CLI", masterAdminClient :: HNil)
    /** Uniqueness Index over (name) (database name UK_ORVSDMLA56612EAEFIQ6WL5OI) */
    val index2 = index("UK_ORVSDMLA56612EAEFIQ6WL5OI", name :: HNil, unique=true)
  }
  /** Collection-like TableQuery object for table Realm */
  lazy val Realm = new TableQuery(tag => new Realm(tag))

  /** Entity class storing rows of table RealmAttribute
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true)
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(36,true)
   *  @param value Database column VALUE SqlType(LONGTEXT), Length(2147483647,true), Default(None) */
  case class RealmAttributeRow(name: String, realmId: String, value: Option[String] = None)
  /** GetResult implicit for fetching RealmAttributeRow objects using plain SQL queries */
  implicit def GetResultRealmAttributeRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[RealmAttributeRow] = GR{
    prs => import prs._
    RealmAttributeRow.tupled((<<[String], <<[String], <<?[String]))
  }
  /** Table description of table REALM_ATTRIBUTE. Objects of this class serve as prototypes for rows in queries. */
  class RealmAttribute(_tableTag: Tag) extends profile.api.Table[RealmAttributeRow](_tableTag, Some("chaman"), "REALM_ATTRIBUTE") {
    def * = (name, realmId, value) <> (RealmAttributeRow.tupled, RealmAttributeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(name), Rep.Some(realmId), value)).shaped.<>({r=>import r._; _1.map(_=> RealmAttributeRow.tupled((_1.get, _2.get, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column NAME SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("NAME", O.Length(255,varying=true))
    /** Database column REALM_ID SqlType(VARCHAR), Length(36,true) */
    val realmId: Rep[String] = column[String]("REALM_ID", O.Length(36,varying=true))
    /** Database column VALUE SqlType(LONGTEXT), Length(2147483647,true), Default(None) */
    val value: Rep[Option[String]] = column[Option[String]]("VALUE", O.Length(2147483647,varying=true), O.Default(None))

    /** Primary key of RealmAttribute (database name REALM_ATTRIBUTE_PK) */
    val pk = primaryKey("REALM_ATTRIBUTE_PK", (name, realmId))

    /** Foreign key referencing Realm (database name FK_8SHXD6L3E9ATQUKACXGPFFPTW) */
    lazy val realmFk = foreignKey("FK_8SHXD6L3E9ATQUKACXGPFFPTW", realmId, Realm)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table RealmAttribute */
  lazy val RealmAttribute = new TableQuery(tag => new RealmAttribute(tag))

  /** Entity class storing rows of table RealmDefaultGroups
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(36,true)
   *  @param groupId Database column GROUP_ID SqlType(VARCHAR), Length(36,true) */
  case class RealmDefaultGroupsRow(realmId: String, groupId: String)
  /** GetResult implicit for fetching RealmDefaultGroupsRow objects using plain SQL queries */
  implicit def GetResultRealmDefaultGroupsRow(implicit e0: GR[String]): GR[RealmDefaultGroupsRow] = GR{
    prs => import prs._
    RealmDefaultGroupsRow.tupled((<<[String], <<[String]))
  }
  /** Table description of table REALM_DEFAULT_GROUPS. Objects of this class serve as prototypes for rows in queries. */
  class RealmDefaultGroups(_tableTag: Tag) extends profile.api.Table[RealmDefaultGroupsRow](_tableTag, Some("chaman"), "REALM_DEFAULT_GROUPS") {
    def * = (realmId, groupId) <> (RealmDefaultGroupsRow.tupled, RealmDefaultGroupsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(realmId), Rep.Some(groupId))).shaped.<>({r=>import r._; _1.map(_=> RealmDefaultGroupsRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column REALM_ID SqlType(VARCHAR), Length(36,true) */
    val realmId: Rep[String] = column[String]("REALM_ID", O.Length(36,varying=true))
    /** Database column GROUP_ID SqlType(VARCHAR), Length(36,true) */
    val groupId: Rep[String] = column[String]("GROUP_ID", O.Length(36,varying=true))

    /** Primary key of RealmDefaultGroups (database name REALM_DEFAULT_GROUPS_PK) */
    val pk = primaryKey("REALM_DEFAULT_GROUPS_PK", (realmId, groupId))

    /** Foreign key referencing Realm (database name FK_DEF_GROUPS_REALM) */
    lazy val realmFk = foreignKey("FK_DEF_GROUPS_REALM", realmId, Realm)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Uniqueness Index over (groupId) (database name CON_GROUP_ID_DEF_GROUPS) */
    val index1 = index("CON_GROUP_ID_DEF_GROUPS", groupId, unique=true)
  }
  /** Collection-like TableQuery object for table RealmDefaultGroups */
  lazy val RealmDefaultGroups = new TableQuery(tag => new RealmDefaultGroups(tag))

  /** Entity class storing rows of table RealmEnabledEventTypes
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(36,true)
   *  @param value Database column VALUE SqlType(VARCHAR), Length(255,true) */
  case class RealmEnabledEventTypesRow(realmId: String, value: String)
  /** GetResult implicit for fetching RealmEnabledEventTypesRow objects using plain SQL queries */
  implicit def GetResultRealmEnabledEventTypesRow(implicit e0: GR[String]): GR[RealmEnabledEventTypesRow] = GR{
    prs => import prs._
    RealmEnabledEventTypesRow.tupled((<<[String], <<[String]))
  }
  /** Table description of table REALM_ENABLED_EVENT_TYPES. Objects of this class serve as prototypes for rows in queries. */
  class RealmEnabledEventTypes(_tableTag: Tag) extends profile.api.Table[RealmEnabledEventTypesRow](_tableTag, Some("chaman"), "REALM_ENABLED_EVENT_TYPES") {
    def * = (realmId, value) <> (RealmEnabledEventTypesRow.tupled, RealmEnabledEventTypesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(realmId), Rep.Some(value))).shaped.<>({r=>import r._; _1.map(_=> RealmEnabledEventTypesRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column REALM_ID SqlType(VARCHAR), Length(36,true) */
    val realmId: Rep[String] = column[String]("REALM_ID", O.Length(36,varying=true))
    /** Database column VALUE SqlType(VARCHAR), Length(255,true) */
    val value: Rep[String] = column[String]("VALUE", O.Length(255,varying=true))

    /** Primary key of RealmEnabledEventTypes (database name REALM_ENABLED_EVENT_TYPES_PK) */
    val pk = primaryKey("REALM_ENABLED_EVENT_TYPES_PK", (realmId, value))

    /** Foreign key referencing Realm (database name FK_H846O4H0W8EPX5NWEDRF5Y69J) */
    lazy val realmFk = foreignKey("FK_H846O4H0W8EPX5NWEDRF5Y69J", realmId, Realm)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table RealmEnabledEventTypes */
  lazy val RealmEnabledEventTypes = new TableQuery(tag => new RealmEnabledEventTypes(tag))

  /** Entity class storing rows of table RealmEventsListeners
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(36,true)
   *  @param value Database column VALUE SqlType(VARCHAR), Length(255,true) */
  case class RealmEventsListenersRow(realmId: String, value: String)
  /** GetResult implicit for fetching RealmEventsListenersRow objects using plain SQL queries */
  implicit def GetResultRealmEventsListenersRow(implicit e0: GR[String]): GR[RealmEventsListenersRow] = GR{
    prs => import prs._
    RealmEventsListenersRow.tupled((<<[String], <<[String]))
  }
  /** Table description of table REALM_EVENTS_LISTENERS. Objects of this class serve as prototypes for rows in queries. */
  class RealmEventsListeners(_tableTag: Tag) extends profile.api.Table[RealmEventsListenersRow](_tableTag, Some("chaman"), "REALM_EVENTS_LISTENERS") {
    def * = (realmId, value) <> (RealmEventsListenersRow.tupled, RealmEventsListenersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(realmId), Rep.Some(value))).shaped.<>({r=>import r._; _1.map(_=> RealmEventsListenersRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column REALM_ID SqlType(VARCHAR), Length(36,true) */
    val realmId: Rep[String] = column[String]("REALM_ID", O.Length(36,varying=true))
    /** Database column VALUE SqlType(VARCHAR), Length(255,true) */
    val value: Rep[String] = column[String]("VALUE", O.Length(255,varying=true))

    /** Primary key of RealmEventsListeners (database name REALM_EVENTS_LISTENERS_PK) */
    val pk = primaryKey("REALM_EVENTS_LISTENERS_PK", (realmId, value))

    /** Foreign key referencing Realm (database name FK_H846O4H0W8EPX5NXEV9F5Y69J) */
    lazy val realmFk = foreignKey("FK_H846O4H0W8EPX5NXEV9F5Y69J", realmId, Realm)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table RealmEventsListeners */
  lazy val RealmEventsListeners = new TableQuery(tag => new RealmEventsListeners(tag))

  /** Entity class storing rows of table RealmLocalizations
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(255,true)
   *  @param locale Database column LOCALE SqlType(VARCHAR), Length(255,true)
   *  @param texts Database column TEXTS SqlType(LONGTEXT), Length(2147483647,true) */
  case class RealmLocalizationsRow(realmId: String, locale: String, texts: String)
  /** GetResult implicit for fetching RealmLocalizationsRow objects using plain SQL queries */
  implicit def GetResultRealmLocalizationsRow(implicit e0: GR[String]): GR[RealmLocalizationsRow] = GR{
    prs => import prs._
    RealmLocalizationsRow.tupled((<<[String], <<[String], <<[String]))
  }
  /** Table description of table REALM_LOCALIZATIONS. Objects of this class serve as prototypes for rows in queries. */
  class RealmLocalizations(_tableTag: Tag) extends profile.api.Table[RealmLocalizationsRow](_tableTag, Some("chaman"), "REALM_LOCALIZATIONS") {
    def * = (realmId, locale, texts) <> (RealmLocalizationsRow.tupled, RealmLocalizationsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(realmId), Rep.Some(locale), Rep.Some(texts))).shaped.<>({r=>import r._; _1.map(_=> RealmLocalizationsRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column REALM_ID SqlType(VARCHAR), Length(255,true) */
    val realmId: Rep[String] = column[String]("REALM_ID", O.Length(255,varying=true))
    /** Database column LOCALE SqlType(VARCHAR), Length(255,true) */
    val locale: Rep[String] = column[String]("LOCALE", O.Length(255,varying=true))
    /** Database column TEXTS SqlType(LONGTEXT), Length(2147483647,true) */
    val texts: Rep[String] = column[String]("TEXTS", O.Length(2147483647,varying=true))

    /** Primary key of RealmLocalizations (database name REALM_LOCALIZATIONS_PK) */
    val pk = primaryKey("REALM_LOCALIZATIONS_PK", (realmId, locale))
  }
  /** Collection-like TableQuery object for table RealmLocalizations */
  lazy val RealmLocalizations = new TableQuery(tag => new RealmLocalizations(tag))

  /** Entity class storing rows of table RealmRequiredCredential
   *  @param `type` Database column TYPE SqlType(VARCHAR), Length(255,true)
   *  @param formLabel Database column FORM_LABEL SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param input Database column INPUT SqlType(BIT), Default(false)
   *  @param secret Database column SECRET SqlType(BIT), Default(false)
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(36,true) */
  case class RealmRequiredCredentialRow(`type`: String, formLabel: Option[String] = None, input: Boolean = false, secret: Boolean = false, realmId: String)
  /** GetResult implicit for fetching RealmRequiredCredentialRow objects using plain SQL queries */
  implicit def GetResultRealmRequiredCredentialRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Boolean]): GR[RealmRequiredCredentialRow] = GR{
    prs => import prs._
    RealmRequiredCredentialRow.tupled((<<[String], <<?[String], <<[Boolean], <<[Boolean], <<[String]))
  }
  /** Table description of table REALM_REQUIRED_CREDENTIAL. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class RealmRequiredCredential(_tableTag: Tag) extends profile.api.Table[RealmRequiredCredentialRow](_tableTag, Some("chaman"), "REALM_REQUIRED_CREDENTIAL") {
    def * = (`type`, formLabel, input, secret, realmId) <> (RealmRequiredCredentialRow.tupled, RealmRequiredCredentialRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(`type`), formLabel, Rep.Some(input), Rep.Some(secret), Rep.Some(realmId))).shaped.<>({r=>import r._; _1.map(_=> RealmRequiredCredentialRow.tupled((_1.get, _2, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column TYPE SqlType(VARCHAR), Length(255,true)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[String] = column[String]("TYPE", O.Length(255,varying=true))
    /** Database column FORM_LABEL SqlType(VARCHAR), Length(255,true), Default(None) */
    val formLabel: Rep[Option[String]] = column[Option[String]]("FORM_LABEL", O.Length(255,varying=true), O.Default(None))
    /** Database column INPUT SqlType(BIT), Default(false) */
    val input: Rep[Boolean] = column[Boolean]("INPUT", O.Default(false))
    /** Database column SECRET SqlType(BIT), Default(false) */
    val secret: Rep[Boolean] = column[Boolean]("SECRET", O.Default(false))
    /** Database column REALM_ID SqlType(VARCHAR), Length(36,true) */
    val realmId: Rep[String] = column[String]("REALM_ID", O.Length(36,varying=true))

    /** Primary key of RealmRequiredCredential (database name REALM_REQUIRED_CREDENTIAL_PK) */
    val pk = primaryKey("REALM_REQUIRED_CREDENTIAL_PK", (realmId, `type`))

    /** Foreign key referencing Realm (database name FK_5HG65LYBEVAVKQFKI3KPONH9V) */
    lazy val realmFk = foreignKey("FK_5HG65LYBEVAVKQFKI3KPONH9V", realmId, Realm)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table RealmRequiredCredential */
  lazy val RealmRequiredCredential = new TableQuery(tag => new RealmRequiredCredential(tag))

  /** Entity class storing rows of table RealmSmtpConfig
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(36,true)
   *  @param value Database column VALUE SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true) */
  case class RealmSmtpConfigRow(realmId: String, value: Option[String] = None, name: String)
  /** GetResult implicit for fetching RealmSmtpConfigRow objects using plain SQL queries */
  implicit def GetResultRealmSmtpConfigRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[RealmSmtpConfigRow] = GR{
    prs => import prs._
    RealmSmtpConfigRow.tupled((<<[String], <<?[String], <<[String]))
  }
  /** Table description of table REALM_SMTP_CONFIG. Objects of this class serve as prototypes for rows in queries. */
  class RealmSmtpConfig(_tableTag: Tag) extends profile.api.Table[RealmSmtpConfigRow](_tableTag, Some("chaman"), "REALM_SMTP_CONFIG") {
    def * = (realmId, value, name) <> (RealmSmtpConfigRow.tupled, RealmSmtpConfigRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(realmId), value, Rep.Some(name))).shaped.<>({r=>import r._; _1.map(_=> RealmSmtpConfigRow.tupled((_1.get, _2, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column REALM_ID SqlType(VARCHAR), Length(36,true) */
    val realmId: Rep[String] = column[String]("REALM_ID", O.Length(36,varying=true))
    /** Database column VALUE SqlType(VARCHAR), Length(255,true), Default(None) */
    val value: Rep[Option[String]] = column[Option[String]]("VALUE", O.Length(255,varying=true), O.Default(None))
    /** Database column NAME SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("NAME", O.Length(255,varying=true))

    /** Primary key of RealmSmtpConfig (database name REALM_SMTP_CONFIG_PK) */
    val pk = primaryKey("REALM_SMTP_CONFIG_PK", (realmId, name))

    /** Foreign key referencing Realm (database name FK_70EJ8XDXGXD0B9HH6180IRR0O) */
    lazy val realmFk = foreignKey("FK_70EJ8XDXGXD0B9HH6180IRR0O", realmId, Realm)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table RealmSmtpConfig */
  lazy val RealmSmtpConfig = new TableQuery(tag => new RealmSmtpConfig(tag))

  /** Entity class storing rows of table RealmSupportedLocales
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(36,true)
   *  @param value Database column VALUE SqlType(VARCHAR), Length(255,true) */
  case class RealmSupportedLocalesRow(realmId: String, value: String)
  /** GetResult implicit for fetching RealmSupportedLocalesRow objects using plain SQL queries */
  implicit def GetResultRealmSupportedLocalesRow(implicit e0: GR[String]): GR[RealmSupportedLocalesRow] = GR{
    prs => import prs._
    RealmSupportedLocalesRow.tupled((<<[String], <<[String]))
  }
  /** Table description of table REALM_SUPPORTED_LOCALES. Objects of this class serve as prototypes for rows in queries. */
  class RealmSupportedLocales(_tableTag: Tag) extends profile.api.Table[RealmSupportedLocalesRow](_tableTag, Some("chaman"), "REALM_SUPPORTED_LOCALES") {
    def * = (realmId, value) <> (RealmSupportedLocalesRow.tupled, RealmSupportedLocalesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(realmId), Rep.Some(value))).shaped.<>({r=>import r._; _1.map(_=> RealmSupportedLocalesRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column REALM_ID SqlType(VARCHAR), Length(36,true) */
    val realmId: Rep[String] = column[String]("REALM_ID", O.Length(36,varying=true))
    /** Database column VALUE SqlType(VARCHAR), Length(255,true) */
    val value: Rep[String] = column[String]("VALUE", O.Length(255,varying=true))

    /** Primary key of RealmSupportedLocales (database name REALM_SUPPORTED_LOCALES_PK) */
    val pk = primaryKey("REALM_SUPPORTED_LOCALES_PK", (realmId, value))

    /** Foreign key referencing Realm (database name FK_SUPPORTED_LOCALES_REALM) */
    lazy val realmFk = foreignKey("FK_SUPPORTED_LOCALES_REALM", realmId, Realm)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table RealmSupportedLocales */
  lazy val RealmSupportedLocales = new TableQuery(tag => new RealmSupportedLocales(tag))

  /** Entity class storing rows of table RedirectUris
   *  @param clientId Database column CLIENT_ID SqlType(VARCHAR), Length(36,true)
   *  @param value Database column VALUE SqlType(VARCHAR), Length(255,true) */
  case class RedirectUrisRow(clientId: String, value: String)
  /** GetResult implicit for fetching RedirectUrisRow objects using plain SQL queries */
  implicit def GetResultRedirectUrisRow(implicit e0: GR[String]): GR[RedirectUrisRow] = GR{
    prs => import prs._
    RedirectUrisRow.tupled((<<[String], <<[String]))
  }
  /** Table description of table REDIRECT_URIS. Objects of this class serve as prototypes for rows in queries. */
  class RedirectUris(_tableTag: Tag) extends profile.api.Table[RedirectUrisRow](_tableTag, Some("chaman"), "REDIRECT_URIS") {
    def * = (clientId, value) <> (RedirectUrisRow.tupled, RedirectUrisRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(clientId), Rep.Some(value))).shaped.<>({r=>import r._; _1.map(_=> RedirectUrisRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column CLIENT_ID SqlType(VARCHAR), Length(36,true) */
    val clientId: Rep[String] = column[String]("CLIENT_ID", O.Length(36,varying=true))
    /** Database column VALUE SqlType(VARCHAR), Length(255,true) */
    val value: Rep[String] = column[String]("VALUE", O.Length(255,varying=true))

    /** Primary key of RedirectUris (database name REDIRECT_URIS_PK) */
    val pk = primaryKey("REDIRECT_URIS_PK", (clientId, value))

    /** Foreign key referencing Client (database name FK_1BURS8PB4OUJ97H5WUPPAHV9F) */
    lazy val clientFk = foreignKey("FK_1BURS8PB4OUJ97H5WUPPAHV9F", clientId, Client)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table RedirectUris */
  lazy val RedirectUris = new TableQuery(tag => new RedirectUris(tag))

  /** Entity class storing rows of table RequiredActionConfig
   *  @param requiredActionId Database column REQUIRED_ACTION_ID SqlType(VARCHAR), Length(36,true)
   *  @param value Database column VALUE SqlType(LONGTEXT), Length(2147483647,true), Default(None)
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true) */
  case class RequiredActionConfigRow(requiredActionId: String, value: Option[String] = None, name: String)
  /** GetResult implicit for fetching RequiredActionConfigRow objects using plain SQL queries */
  implicit def GetResultRequiredActionConfigRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[RequiredActionConfigRow] = GR{
    prs => import prs._
    RequiredActionConfigRow.tupled((<<[String], <<?[String], <<[String]))
  }
  /** Table description of table REQUIRED_ACTION_CONFIG. Objects of this class serve as prototypes for rows in queries. */
  class RequiredActionConfig(_tableTag: Tag) extends profile.api.Table[RequiredActionConfigRow](_tableTag, Some("chaman"), "REQUIRED_ACTION_CONFIG") {
    def * = (requiredActionId, value, name) <> (RequiredActionConfigRow.tupled, RequiredActionConfigRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(requiredActionId), value, Rep.Some(name))).shaped.<>({r=>import r._; _1.map(_=> RequiredActionConfigRow.tupled((_1.get, _2, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column REQUIRED_ACTION_ID SqlType(VARCHAR), Length(36,true) */
    val requiredActionId: Rep[String] = column[String]("REQUIRED_ACTION_ID", O.Length(36,varying=true))
    /** Database column VALUE SqlType(LONGTEXT), Length(2147483647,true), Default(None) */
    val value: Rep[Option[String]] = column[Option[String]]("VALUE", O.Length(2147483647,varying=true), O.Default(None))
    /** Database column NAME SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("NAME", O.Length(255,varying=true))

    /** Primary key of RequiredActionConfig (database name REQUIRED_ACTION_CONFIG_PK) */
    val pk = primaryKey("REQUIRED_ACTION_CONFIG_PK", (requiredActionId, name))
  }
  /** Collection-like TableQuery object for table RequiredActionConfig */
  lazy val RequiredActionConfig = new TableQuery(tag => new RequiredActionConfig(tag))

  /** Entity class storing rows of table RequiredActionProvider
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param alias Database column ALIAS SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param enabled Database column ENABLED SqlType(BIT), Default(false)
   *  @param defaultAction Database column DEFAULT_ACTION SqlType(BIT), Default(false)
   *  @param providerId Database column PROVIDER_ID SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param priority Database column PRIORITY SqlType(INT), Default(None) */
  case class RequiredActionProviderRow(id: String, alias: Option[String] = None, name: Option[String] = None, realmId: Option[String] = None, enabled: Boolean = false, defaultAction: Boolean = false, providerId: Option[String] = None, priority: Option[Int] = None)
  /** GetResult implicit for fetching RequiredActionProviderRow objects using plain SQL queries */
  implicit def GetResultRequiredActionProviderRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Boolean], e3: GR[Option[Int]]): GR[RequiredActionProviderRow] = GR{
    prs => import prs._
    RequiredActionProviderRow.tupled((<<[String], <<?[String], <<?[String], <<?[String], <<[Boolean], <<[Boolean], <<?[String], <<?[Int]))
  }
  /** Table description of table REQUIRED_ACTION_PROVIDER. Objects of this class serve as prototypes for rows in queries. */
  class RequiredActionProvider(_tableTag: Tag) extends profile.api.Table[RequiredActionProviderRow](_tableTag, Some("chaman"), "REQUIRED_ACTION_PROVIDER") {
    def * = (id, alias, name, realmId, enabled, defaultAction, providerId, priority) <> (RequiredActionProviderRow.tupled, RequiredActionProviderRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), alias, name, realmId, Rep.Some(enabled), Rep.Some(defaultAction), providerId, priority)).shaped.<>({r=>import r._; _1.map(_=> RequiredActionProviderRow.tupled((_1.get, _2, _3, _4, _5.get, _6.get, _7, _8)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column ALIAS SqlType(VARCHAR), Length(255,true), Default(None) */
    val alias: Rep[Option[String]] = column[Option[String]]("ALIAS", O.Length(255,varying=true), O.Default(None))
    /** Database column NAME SqlType(VARCHAR), Length(255,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("NAME", O.Length(255,varying=true), O.Default(None))
    /** Database column REALM_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val realmId: Rep[Option[String]] = column[Option[String]]("REALM_ID", O.Length(36,varying=true), O.Default(None))
    /** Database column ENABLED SqlType(BIT), Default(false) */
    val enabled: Rep[Boolean] = column[Boolean]("ENABLED", O.Default(false))
    /** Database column DEFAULT_ACTION SqlType(BIT), Default(false) */
    val defaultAction: Rep[Boolean] = column[Boolean]("DEFAULT_ACTION", O.Default(false))
    /** Database column PROVIDER_ID SqlType(VARCHAR), Length(255,true), Default(None) */
    val providerId: Rep[Option[String]] = column[Option[String]]("PROVIDER_ID", O.Length(255,varying=true), O.Default(None))
    /** Database column PRIORITY SqlType(INT), Default(None) */
    val priority: Rep[Option[Int]] = column[Option[Int]]("PRIORITY", O.Default(None))

    /** Foreign key referencing Realm (database name FK_REQ_ACT_REALM) */
    lazy val realmFk = foreignKey("FK_REQ_ACT_REALM", realmId, Realm)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table RequiredActionProvider */
  lazy val RequiredActionProvider = new TableQuery(tag => new RequiredActionProvider(tag))

  /** Entity class storing rows of table ResourceAttribute
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true), Default(sybase-needs-something-here)
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true)
   *  @param value Database column VALUE SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param resourceId Database column RESOURCE_ID SqlType(VARCHAR), Length(36,true) */
  case class ResourceAttributeRow(id: String = "sybase-needs-something-here", name: String, value: Option[String] = None, resourceId: String)
  /** GetResult implicit for fetching ResourceAttributeRow objects using plain SQL queries */
  implicit def GetResultResourceAttributeRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[ResourceAttributeRow] = GR{
    prs => import prs._
    ResourceAttributeRow.tupled((<<[String], <<[String], <<?[String], <<[String]))
  }
  /** Table description of table RESOURCE_ATTRIBUTE. Objects of this class serve as prototypes for rows in queries. */
  class ResourceAttribute(_tableTag: Tag) extends profile.api.Table[ResourceAttributeRow](_tableTag, Some("chaman"), "RESOURCE_ATTRIBUTE") {
    def * = (id, name, value, resourceId) <> (ResourceAttributeRow.tupled, ResourceAttributeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(name), value, Rep.Some(resourceId))).shaped.<>({r=>import r._; _1.map(_=> ResourceAttributeRow.tupled((_1.get, _2.get, _3, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true), Default(sybase-needs-something-here) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true), O.Default("sybase-needs-something-here"))
    /** Database column NAME SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("NAME", O.Length(255,varying=true))
    /** Database column VALUE SqlType(VARCHAR), Length(255,true), Default(None) */
    val value: Rep[Option[String]] = column[Option[String]]("VALUE", O.Length(255,varying=true), O.Default(None))
    /** Database column RESOURCE_ID SqlType(VARCHAR), Length(36,true) */
    val resourceId: Rep[String] = column[String]("RESOURCE_ID", O.Length(36,varying=true))

    /** Foreign key referencing ResourceServerResource (database name FK_5HRM2VLF9QL5FU022KQEPOVBR) */
    lazy val resourceServerResourceFk = foreignKey("FK_5HRM2VLF9QL5FU022KQEPOVBR", resourceId, ResourceServerResource)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table ResourceAttribute */
  lazy val ResourceAttribute = new TableQuery(tag => new ResourceAttribute(tag))

  /** Entity class storing rows of table ResourcePolicy
   *  @param resourceId Database column RESOURCE_ID SqlType(VARCHAR), Length(36,true)
   *  @param policyId Database column POLICY_ID SqlType(VARCHAR), Length(36,true) */
  case class ResourcePolicyRow(resourceId: String, policyId: String)
  /** GetResult implicit for fetching ResourcePolicyRow objects using plain SQL queries */
  implicit def GetResultResourcePolicyRow(implicit e0: GR[String]): GR[ResourcePolicyRow] = GR{
    prs => import prs._
    ResourcePolicyRow.tupled((<<[String], <<[String]))
  }
  /** Table description of table RESOURCE_POLICY. Objects of this class serve as prototypes for rows in queries. */
  class ResourcePolicy(_tableTag: Tag) extends profile.api.Table[ResourcePolicyRow](_tableTag, Some("chaman"), "RESOURCE_POLICY") {
    def * = (resourceId, policyId) <> (ResourcePolicyRow.tupled, ResourcePolicyRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(resourceId), Rep.Some(policyId))).shaped.<>({r=>import r._; _1.map(_=> ResourcePolicyRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column RESOURCE_ID SqlType(VARCHAR), Length(36,true) */
    val resourceId: Rep[String] = column[String]("RESOURCE_ID", O.Length(36,varying=true))
    /** Database column POLICY_ID SqlType(VARCHAR), Length(36,true) */
    val policyId: Rep[String] = column[String]("POLICY_ID", O.Length(36,varying=true))

    /** Primary key of ResourcePolicy (database name RESOURCE_POLICY_PK) */
    val pk = primaryKey("RESOURCE_POLICY_PK", (resourceId, policyId))

    /** Foreign key referencing ResourceServerPolicy (database name FK_FRSRPP213XCX4WNKOG82SSRFY) */
    lazy val resourceServerPolicyFk = foreignKey("FK_FRSRPP213XCX4WNKOG82SSRFY", policyId, ResourceServerPolicy)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing ResourceServerResource (database name FK_FRSRPOS53XCX4WNKOG82SSRFY) */
    lazy val resourceServerResourceFk = foreignKey("FK_FRSRPOS53XCX4WNKOG82SSRFY", resourceId, ResourceServerResource)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table ResourcePolicy */
  lazy val ResourcePolicy = new TableQuery(tag => new ResourcePolicy(tag))

  /** Entity class storing rows of table ResourceScope
   *  @param resourceId Database column RESOURCE_ID SqlType(VARCHAR), Length(36,true)
   *  @param scopeId Database column SCOPE_ID SqlType(VARCHAR), Length(36,true) */
  case class ResourceScopeRow(resourceId: String, scopeId: String)
  /** GetResult implicit for fetching ResourceScopeRow objects using plain SQL queries */
  implicit def GetResultResourceScopeRow(implicit e0: GR[String]): GR[ResourceScopeRow] = GR{
    prs => import prs._
    ResourceScopeRow.tupled((<<[String], <<[String]))
  }
  /** Table description of table RESOURCE_SCOPE. Objects of this class serve as prototypes for rows in queries. */
  class ResourceScope(_tableTag: Tag) extends profile.api.Table[ResourceScopeRow](_tableTag, Some("chaman"), "RESOURCE_SCOPE") {
    def * = (resourceId, scopeId) <> (ResourceScopeRow.tupled, ResourceScopeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(resourceId), Rep.Some(scopeId))).shaped.<>({r=>import r._; _1.map(_=> ResourceScopeRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column RESOURCE_ID SqlType(VARCHAR), Length(36,true) */
    val resourceId: Rep[String] = column[String]("RESOURCE_ID", O.Length(36,varying=true))
    /** Database column SCOPE_ID SqlType(VARCHAR), Length(36,true) */
    val scopeId: Rep[String] = column[String]("SCOPE_ID", O.Length(36,varying=true))

    /** Primary key of ResourceScope (database name RESOURCE_SCOPE_PK) */
    val pk = primaryKey("RESOURCE_SCOPE_PK", (resourceId, scopeId))

    /** Foreign key referencing ResourceServerResource (database name FK_FRSRPOS13XCX4WNKOG82SSRFY) */
    lazy val resourceServerResourceFk = foreignKey("FK_FRSRPOS13XCX4WNKOG82SSRFY", resourceId, ResourceServerResource)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing ResourceServerScope (database name FK_FRSRPS213XCX4WNKOG82SSRFY) */
    lazy val resourceServerScopeFk = foreignKey("FK_FRSRPS213XCX4WNKOG82SSRFY", scopeId, ResourceServerScope)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table ResourceScope */
  lazy val ResourceScope = new TableQuery(tag => new ResourceScope(tag))

  /** Entity class storing rows of table ResourceServer
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param allowRsRemoteMgmt Database column ALLOW_RS_REMOTE_MGMT SqlType(BIT), Default(false)
   *  @param policyEnforceMode Database column POLICY_ENFORCE_MODE SqlType(VARCHAR), Length(15,true)
   *  @param decisionStrategy Database column DECISION_STRATEGY SqlType(TINYINT), Default(1) */
  case class ResourceServerRow(id: String, allowRsRemoteMgmt: Boolean = false, policyEnforceMode: String, decisionStrategy: Byte = 1)
  /** GetResult implicit for fetching ResourceServerRow objects using plain SQL queries */
  implicit def GetResultResourceServerRow(implicit e0: GR[String], e1: GR[Boolean], e2: GR[Byte]): GR[ResourceServerRow] = GR{
    prs => import prs._
    ResourceServerRow.tupled((<<[String], <<[Boolean], <<[String], <<[Byte]))
  }
  /** Table description of table RESOURCE_SERVER. Objects of this class serve as prototypes for rows in queries. */
  class ResourceServer(_tableTag: Tag) extends profile.api.Table[ResourceServerRow](_tableTag, Some("chaman"), "RESOURCE_SERVER") {
    def * = (id, allowRsRemoteMgmt, policyEnforceMode, decisionStrategy) <> (ResourceServerRow.tupled, ResourceServerRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(allowRsRemoteMgmt), Rep.Some(policyEnforceMode), Rep.Some(decisionStrategy))).shaped.<>({r=>import r._; _1.map(_=> ResourceServerRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column ALLOW_RS_REMOTE_MGMT SqlType(BIT), Default(false) */
    val allowRsRemoteMgmt: Rep[Boolean] = column[Boolean]("ALLOW_RS_REMOTE_MGMT", O.Default(false))
    /** Database column POLICY_ENFORCE_MODE SqlType(VARCHAR), Length(15,true) */
    val policyEnforceMode: Rep[String] = column[String]("POLICY_ENFORCE_MODE", O.Length(15,varying=true))
    /** Database column DECISION_STRATEGY SqlType(TINYINT), Default(1) */
    val decisionStrategy: Rep[Byte] = column[Byte]("DECISION_STRATEGY", O.Default(1))
  }
  /** Collection-like TableQuery object for table ResourceServer */
  lazy val ResourceServer = new TableQuery(tag => new ResourceServer(tag))

  /** Entity class storing rows of table ResourceServerPermTicket
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param owner Database column OWNER SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param requester Database column REQUESTER SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param createdTimestamp Database column CREATED_TIMESTAMP SqlType(BIGINT)
   *  @param grantedTimestamp Database column GRANTED_TIMESTAMP SqlType(BIGINT), Default(None)
   *  @param resourceId Database column RESOURCE_ID SqlType(VARCHAR), Length(36,true)
   *  @param scopeId Database column SCOPE_ID SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param resourceServerId Database column RESOURCE_SERVER_ID SqlType(VARCHAR), Length(36,true)
   *  @param policyId Database column POLICY_ID SqlType(VARCHAR), Length(36,true), Default(None) */
  case class ResourceServerPermTicketRow(id: String, owner: Option[String] = None, requester: Option[String] = None, createdTimestamp: Long, grantedTimestamp: Option[Long] = None, resourceId: String, scopeId: Option[String] = None, resourceServerId: String, policyId: Option[String] = None)
  /** GetResult implicit for fetching ResourceServerPermTicketRow objects using plain SQL queries */
  implicit def GetResultResourceServerPermTicketRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Long], e3: GR[Option[Long]]): GR[ResourceServerPermTicketRow] = GR{
    prs => import prs._
    ResourceServerPermTicketRow.tupled((<<[String], <<?[String], <<?[String], <<[Long], <<?[Long], <<[String], <<?[String], <<[String], <<?[String]))
  }
  /** Table description of table RESOURCE_SERVER_PERM_TICKET. Objects of this class serve as prototypes for rows in queries. */
  class ResourceServerPermTicket(_tableTag: Tag) extends profile.api.Table[ResourceServerPermTicketRow](_tableTag, Some("chaman"), "RESOURCE_SERVER_PERM_TICKET") {
    def * = (id, owner, requester, createdTimestamp, grantedTimestamp, resourceId, scopeId, resourceServerId, policyId) <> (ResourceServerPermTicketRow.tupled, ResourceServerPermTicketRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), owner, requester, Rep.Some(createdTimestamp), grantedTimestamp, Rep.Some(resourceId), scopeId, Rep.Some(resourceServerId), policyId)).shaped.<>({r=>import r._; _1.map(_=> ResourceServerPermTicketRow.tupled((_1.get, _2, _3, _4.get, _5, _6.get, _7, _8.get, _9)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column OWNER SqlType(VARCHAR), Length(255,true), Default(None) */
    val owner: Rep[Option[String]] = column[Option[String]]("OWNER", O.Length(255,varying=true), O.Default(None))
    /** Database column REQUESTER SqlType(VARCHAR), Length(255,true), Default(None) */
    val requester: Rep[Option[String]] = column[Option[String]]("REQUESTER", O.Length(255,varying=true), O.Default(None))
    /** Database column CREATED_TIMESTAMP SqlType(BIGINT) */
    val createdTimestamp: Rep[Long] = column[Long]("CREATED_TIMESTAMP")
    /** Database column GRANTED_TIMESTAMP SqlType(BIGINT), Default(None) */
    val grantedTimestamp: Rep[Option[Long]] = column[Option[Long]]("GRANTED_TIMESTAMP", O.Default(None))
    /** Database column RESOURCE_ID SqlType(VARCHAR), Length(36,true) */
    val resourceId: Rep[String] = column[String]("RESOURCE_ID", O.Length(36,varying=true))
    /** Database column SCOPE_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val scopeId: Rep[Option[String]] = column[Option[String]]("SCOPE_ID", O.Length(36,varying=true), O.Default(None))
    /** Database column RESOURCE_SERVER_ID SqlType(VARCHAR), Length(36,true) */
    val resourceServerId: Rep[String] = column[String]("RESOURCE_SERVER_ID", O.Length(36,varying=true))
    /** Database column POLICY_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val policyId: Rep[Option[String]] = column[Option[String]]("POLICY_ID", O.Length(36,varying=true), O.Default(None))

    /** Foreign key referencing ResourceServer (database name FK_FRSRHO213XCX4WNKOG82SSPMT) */
    lazy val resourceServerFk = foreignKey("FK_FRSRHO213XCX4WNKOG82SSPMT", resourceServerId, ResourceServer)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing ResourceServerPolicy (database name FK_FRSRPO2128CX4WNKOG82SSRFY) */
    lazy val resourceServerPolicyFk = foreignKey("FK_FRSRPO2128CX4WNKOG82SSRFY", policyId, ResourceServerPolicy)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing ResourceServerResource (database name FK_FRSRHO213XCX4WNKOG83SSPMT) */
    lazy val resourceServerResourceFk = foreignKey("FK_FRSRHO213XCX4WNKOG83SSPMT", resourceId, ResourceServerResource)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing ResourceServerScope (database name FK_FRSRHO213XCX4WNKOG84SSPMT) */
    lazy val resourceServerScopeFk = foreignKey("FK_FRSRHO213XCX4WNKOG84SSPMT", scopeId, ResourceServerScope)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Uniqueness Index over (owner,requester,resourceServerId,resourceId,scopeId) (database name UK_FRSR6T700S9V50BU18WS5PMT) */
    val index1 = index("UK_FRSR6T700S9V50BU18WS5PMT", (owner, requester, resourceServerId, resourceId, scopeId), unique=true)
  }
  /** Collection-like TableQuery object for table ResourceServerPermTicket */
  lazy val ResourceServerPermTicket = new TableQuery(tag => new ResourceServerPermTicket(tag))

  /** Entity class storing rows of table ResourceServerPolicy
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true)
   *  @param description Database column DESCRIPTION SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param `type` Database column TYPE SqlType(VARCHAR), Length(255,true)
   *  @param decisionStrategy Database column DECISION_STRATEGY SqlType(VARCHAR), Length(20,true), Default(None)
   *  @param logic Database column LOGIC SqlType(VARCHAR), Length(20,true), Default(None)
   *  @param resourceServerId Database column RESOURCE_SERVER_ID SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param owner Database column OWNER SqlType(VARCHAR), Length(255,true), Default(None) */
  case class ResourceServerPolicyRow(id: String, name: String, description: Option[String] = None, `type`: String, decisionStrategy: Option[String] = None, logic: Option[String] = None, resourceServerId: Option[String] = None, owner: Option[String] = None)
  /** GetResult implicit for fetching ResourceServerPolicyRow objects using plain SQL queries */
  implicit def GetResultResourceServerPolicyRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[ResourceServerPolicyRow] = GR{
    prs => import prs._
    ResourceServerPolicyRow.tupled((<<[String], <<[String], <<?[String], <<[String], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table RESOURCE_SERVER_POLICY. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class ResourceServerPolicy(_tableTag: Tag) extends profile.api.Table[ResourceServerPolicyRow](_tableTag, Some("chaman"), "RESOURCE_SERVER_POLICY") {
    def * = (id, name, description, `type`, decisionStrategy, logic, resourceServerId, owner) <> (ResourceServerPolicyRow.tupled, ResourceServerPolicyRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(name), description, Rep.Some(`type`), decisionStrategy, logic, resourceServerId, owner)).shaped.<>({r=>import r._; _1.map(_=> ResourceServerPolicyRow.tupled((_1.get, _2.get, _3, _4.get, _5, _6, _7, _8)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column NAME SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("NAME", O.Length(255,varying=true))
    /** Database column DESCRIPTION SqlType(VARCHAR), Length(255,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("DESCRIPTION", O.Length(255,varying=true), O.Default(None))
    /** Database column TYPE SqlType(VARCHAR), Length(255,true)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[String] = column[String]("TYPE", O.Length(255,varying=true))
    /** Database column DECISION_STRATEGY SqlType(VARCHAR), Length(20,true), Default(None) */
    val decisionStrategy: Rep[Option[String]] = column[Option[String]]("DECISION_STRATEGY", O.Length(20,varying=true), O.Default(None))
    /** Database column LOGIC SqlType(VARCHAR), Length(20,true), Default(None) */
    val logic: Rep[Option[String]] = column[Option[String]]("LOGIC", O.Length(20,varying=true), O.Default(None))
    /** Database column RESOURCE_SERVER_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val resourceServerId: Rep[Option[String]] = column[Option[String]]("RESOURCE_SERVER_ID", O.Length(36,varying=true), O.Default(None))
    /** Database column OWNER SqlType(VARCHAR), Length(255,true), Default(None) */
    val owner: Rep[Option[String]] = column[Option[String]]("OWNER", O.Length(255,varying=true), O.Default(None))

    /** Foreign key referencing ResourceServer (database name FK_FRSRPO213XCX4WNKOG82SSRFY) */
    lazy val resourceServerFk = foreignKey("FK_FRSRPO213XCX4WNKOG82SSRFY", resourceServerId, ResourceServer)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Uniqueness Index over (name,resourceServerId) (database name UK_FRSRPT700S9V50BU18WS5HA6) */
    val index1 = index("UK_FRSRPT700S9V50BU18WS5HA6", (name, resourceServerId), unique=true)
  }
  /** Collection-like TableQuery object for table ResourceServerPolicy */
  lazy val ResourceServerPolicy = new TableQuery(tag => new ResourceServerPolicy(tag))

  /** Entity class storing rows of table ResourceServerResource
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true)
   *  @param `type` Database column TYPE SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param iconUri Database column ICON_URI SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param owner Database column OWNER SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param resourceServerId Database column RESOURCE_SERVER_ID SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param ownerManagedAccess Database column OWNER_MANAGED_ACCESS SqlType(BIT), Default(false)
   *  @param displayName Database column DISPLAY_NAME SqlType(VARCHAR), Length(255,true), Default(None) */
  case class ResourceServerResourceRow(id: String, name: String, `type`: Option[String] = None, iconUri: Option[String] = None, owner: Option[String] = None, resourceServerId: Option[String] = None, ownerManagedAccess: Boolean = false, displayName: Option[String] = None)
  /** GetResult implicit for fetching ResourceServerResourceRow objects using plain SQL queries */
  implicit def GetResultResourceServerResourceRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Boolean]): GR[ResourceServerResourceRow] = GR{
    prs => import prs._
    ResourceServerResourceRow.tupled((<<[String], <<[String], <<?[String], <<?[String], <<?[String], <<?[String], <<[Boolean], <<?[String]))
  }
  /** Table description of table RESOURCE_SERVER_RESOURCE. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class ResourceServerResource(_tableTag: Tag) extends profile.api.Table[ResourceServerResourceRow](_tableTag, Some("chaman"), "RESOURCE_SERVER_RESOURCE") {
    def * = (id, name, `type`, iconUri, owner, resourceServerId, ownerManagedAccess, displayName) <> (ResourceServerResourceRow.tupled, ResourceServerResourceRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(name), `type`, iconUri, owner, resourceServerId, Rep.Some(ownerManagedAccess), displayName)).shaped.<>({r=>import r._; _1.map(_=> ResourceServerResourceRow.tupled((_1.get, _2.get, _3, _4, _5, _6, _7.get, _8)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column NAME SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("NAME", O.Length(255,varying=true))
    /** Database column TYPE SqlType(VARCHAR), Length(255,true), Default(None)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[Option[String]] = column[Option[String]]("TYPE", O.Length(255,varying=true), O.Default(None))
    /** Database column ICON_URI SqlType(VARCHAR), Length(255,true), Default(None) */
    val iconUri: Rep[Option[String]] = column[Option[String]]("ICON_URI", O.Length(255,varying=true), O.Default(None))
    /** Database column OWNER SqlType(VARCHAR), Length(255,true), Default(None) */
    val owner: Rep[Option[String]] = column[Option[String]]("OWNER", O.Length(255,varying=true), O.Default(None))
    /** Database column RESOURCE_SERVER_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val resourceServerId: Rep[Option[String]] = column[Option[String]]("RESOURCE_SERVER_ID", O.Length(36,varying=true), O.Default(None))
    /** Database column OWNER_MANAGED_ACCESS SqlType(BIT), Default(false) */
    val ownerManagedAccess: Rep[Boolean] = column[Boolean]("OWNER_MANAGED_ACCESS", O.Default(false))
    /** Database column DISPLAY_NAME SqlType(VARCHAR), Length(255,true), Default(None) */
    val displayName: Rep[Option[String]] = column[Option[String]]("DISPLAY_NAME", O.Length(255,varying=true), O.Default(None))

    /** Foreign key referencing ResourceServer (database name FK_FRSRHO213XCX4WNKOG82SSRFY) */
    lazy val resourceServerFk = foreignKey("FK_FRSRHO213XCX4WNKOG82SSRFY", resourceServerId, ResourceServer)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Uniqueness Index over (name,owner,resourceServerId) (database name UK_FRSR6T700S9V50BU18WS5HA6) */
    val index1 = index("UK_FRSR6T700S9V50BU18WS5HA6", (name, owner, resourceServerId), unique=true)
  }
  /** Collection-like TableQuery object for table ResourceServerResource */
  lazy val ResourceServerResource = new TableQuery(tag => new ResourceServerResource(tag))

  /** Entity class storing rows of table ResourceServerScope
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true)
   *  @param iconUri Database column ICON_URI SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param resourceServerId Database column RESOURCE_SERVER_ID SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param displayName Database column DISPLAY_NAME SqlType(VARCHAR), Length(255,true), Default(None) */
  case class ResourceServerScopeRow(id: String, name: String, iconUri: Option[String] = None, resourceServerId: Option[String] = None, displayName: Option[String] = None)
  /** GetResult implicit for fetching ResourceServerScopeRow objects using plain SQL queries */
  implicit def GetResultResourceServerScopeRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[ResourceServerScopeRow] = GR{
    prs => import prs._
    ResourceServerScopeRow.tupled((<<[String], <<[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table RESOURCE_SERVER_SCOPE. Objects of this class serve as prototypes for rows in queries. */
  class ResourceServerScope(_tableTag: Tag) extends profile.api.Table[ResourceServerScopeRow](_tableTag, Some("chaman"), "RESOURCE_SERVER_SCOPE") {
    def * = (id, name, iconUri, resourceServerId, displayName) <> (ResourceServerScopeRow.tupled, ResourceServerScopeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(name), iconUri, resourceServerId, displayName)).shaped.<>({r=>import r._; _1.map(_=> ResourceServerScopeRow.tupled((_1.get, _2.get, _3, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column NAME SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("NAME", O.Length(255,varying=true))
    /** Database column ICON_URI SqlType(VARCHAR), Length(255,true), Default(None) */
    val iconUri: Rep[Option[String]] = column[Option[String]]("ICON_URI", O.Length(255,varying=true), O.Default(None))
    /** Database column RESOURCE_SERVER_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val resourceServerId: Rep[Option[String]] = column[Option[String]]("RESOURCE_SERVER_ID", O.Length(36,varying=true), O.Default(None))
    /** Database column DISPLAY_NAME SqlType(VARCHAR), Length(255,true), Default(None) */
    val displayName: Rep[Option[String]] = column[Option[String]]("DISPLAY_NAME", O.Length(255,varying=true), O.Default(None))

    /** Foreign key referencing ResourceServer (database name FK_FRSRSO213XCX4WNKOG82SSRFY) */
    lazy val resourceServerFk = foreignKey("FK_FRSRSO213XCX4WNKOG82SSRFY", resourceServerId, ResourceServer)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Uniqueness Index over (name,resourceServerId) (database name UK_FRSRST700S9V50BU18WS5HA6) */
    val index1 = index("UK_FRSRST700S9V50BU18WS5HA6", (name, resourceServerId), unique=true)
  }
  /** Collection-like TableQuery object for table ResourceServerScope */
  lazy val ResourceServerScope = new TableQuery(tag => new ResourceServerScope(tag))

  /** Entity class storing rows of table ResourceUris
   *  @param resourceId Database column RESOURCE_ID SqlType(VARCHAR), Length(36,true)
   *  @param value Database column VALUE SqlType(VARCHAR), Length(255,true) */
  case class ResourceUrisRow(resourceId: String, value: String)
  /** GetResult implicit for fetching ResourceUrisRow objects using plain SQL queries */
  implicit def GetResultResourceUrisRow(implicit e0: GR[String]): GR[ResourceUrisRow] = GR{
    prs => import prs._
    ResourceUrisRow.tupled((<<[String], <<[String]))
  }
  /** Table description of table RESOURCE_URIS. Objects of this class serve as prototypes for rows in queries. */
  class ResourceUris(_tableTag: Tag) extends profile.api.Table[ResourceUrisRow](_tableTag, Some("chaman"), "RESOURCE_URIS") {
    def * = (resourceId, value) <> (ResourceUrisRow.tupled, ResourceUrisRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(resourceId), Rep.Some(value))).shaped.<>({r=>import r._; _1.map(_=> ResourceUrisRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column RESOURCE_ID SqlType(VARCHAR), Length(36,true) */
    val resourceId: Rep[String] = column[String]("RESOURCE_ID", O.Length(36,varying=true))
    /** Database column VALUE SqlType(VARCHAR), Length(255,true) */
    val value: Rep[String] = column[String]("VALUE", O.Length(255,varying=true))

    /** Primary key of ResourceUris (database name RESOURCE_URIS_PK) */
    val pk = primaryKey("RESOURCE_URIS_PK", (resourceId, value))

    /** Foreign key referencing ResourceServerResource (database name FK_RESOURCE_SERVER_URIS) */
    lazy val resourceServerResourceFk = foreignKey("FK_RESOURCE_SERVER_URIS", resourceId, ResourceServerResource)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table ResourceUris */
  lazy val ResourceUris = new TableQuery(tag => new ResourceUris(tag))

  /** Entity class storing rows of table RoleAttribute
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param roleId Database column ROLE_ID SqlType(VARCHAR), Length(36,true)
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true)
   *  @param value Database column VALUE SqlType(VARCHAR), Length(255,true), Default(None) */
  case class RoleAttributeRow(id: String, roleId: String, name: String, value: Option[String] = None)
  /** GetResult implicit for fetching RoleAttributeRow objects using plain SQL queries */
  implicit def GetResultRoleAttributeRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[RoleAttributeRow] = GR{
    prs => import prs._
    RoleAttributeRow.tupled((<<[String], <<[String], <<[String], <<?[String]))
  }
  /** Table description of table ROLE_ATTRIBUTE. Objects of this class serve as prototypes for rows in queries. */
  class RoleAttribute(_tableTag: Tag) extends profile.api.Table[RoleAttributeRow](_tableTag, Some("chaman"), "ROLE_ATTRIBUTE") {
    def * = (id, roleId, name, value) <> (RoleAttributeRow.tupled, RoleAttributeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(roleId), Rep.Some(name), value)).shaped.<>({r=>import r._; _1.map(_=> RoleAttributeRow.tupled((_1.get, _2.get, _3.get, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column ROLE_ID SqlType(VARCHAR), Length(36,true) */
    val roleId: Rep[String] = column[String]("ROLE_ID", O.Length(36,varying=true))
    /** Database column NAME SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("NAME", O.Length(255,varying=true))
    /** Database column VALUE SqlType(VARCHAR), Length(255,true), Default(None) */
    val value: Rep[Option[String]] = column[Option[String]]("VALUE", O.Length(255,varying=true), O.Default(None))

    /** Foreign key referencing KeycloakRole (database name FK_ROLE_ATTRIBUTE_ID) */
    lazy val keycloakRoleFk = foreignKey("FK_ROLE_ATTRIBUTE_ID", roleId, KeycloakRole)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table RoleAttribute */
  lazy val RoleAttribute = new TableQuery(tag => new RoleAttribute(tag))

  /** Entity class storing rows of table ScopeMapping
   *  @param clientId Database column CLIENT_ID SqlType(VARCHAR), Length(36,true)
   *  @param roleId Database column ROLE_ID SqlType(VARCHAR), Length(36,true) */
  case class ScopeMappingRow(clientId: String, roleId: String)
  /** GetResult implicit for fetching ScopeMappingRow objects using plain SQL queries */
  implicit def GetResultScopeMappingRow(implicit e0: GR[String]): GR[ScopeMappingRow] = GR{
    prs => import prs._
    ScopeMappingRow.tupled((<<[String], <<[String]))
  }
  /** Table description of table SCOPE_MAPPING. Objects of this class serve as prototypes for rows in queries. */
  class ScopeMapping(_tableTag: Tag) extends profile.api.Table[ScopeMappingRow](_tableTag, Some("chaman"), "SCOPE_MAPPING") {
    def * = (clientId, roleId) <> (ScopeMappingRow.tupled, ScopeMappingRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(clientId), Rep.Some(roleId))).shaped.<>({r=>import r._; _1.map(_=> ScopeMappingRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column CLIENT_ID SqlType(VARCHAR), Length(36,true) */
    val clientId: Rep[String] = column[String]("CLIENT_ID", O.Length(36,varying=true))
    /** Database column ROLE_ID SqlType(VARCHAR), Length(36,true) */
    val roleId: Rep[String] = column[String]("ROLE_ID", O.Length(36,varying=true))

    /** Primary key of ScopeMapping (database name SCOPE_MAPPING_PK) */
    val pk = primaryKey("SCOPE_MAPPING_PK", (clientId, roleId))

    /** Foreign key referencing Client (database name FK_OUSE064PLMLR732LXJCN1Q5F1) */
    lazy val clientFk = foreignKey("FK_OUSE064PLMLR732LXJCN1Q5F1", clientId, Client)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Index over (roleId) (database name IDX_SCOPE_MAPPING_ROLE) */
    val index1 = index("IDX_SCOPE_MAPPING_ROLE", roleId)
  }
  /** Collection-like TableQuery object for table ScopeMapping */
  lazy val ScopeMapping = new TableQuery(tag => new ScopeMapping(tag))

  /** Entity class storing rows of table ScopePolicy
   *  @param scopeId Database column SCOPE_ID SqlType(VARCHAR), Length(36,true)
   *  @param policyId Database column POLICY_ID SqlType(VARCHAR), Length(36,true) */
  case class ScopePolicyRow(scopeId: String, policyId: String)
  /** GetResult implicit for fetching ScopePolicyRow objects using plain SQL queries */
  implicit def GetResultScopePolicyRow(implicit e0: GR[String]): GR[ScopePolicyRow] = GR{
    prs => import prs._
    ScopePolicyRow.tupled((<<[String], <<[String]))
  }
  /** Table description of table SCOPE_POLICY. Objects of this class serve as prototypes for rows in queries. */
  class ScopePolicy(_tableTag: Tag) extends profile.api.Table[ScopePolicyRow](_tableTag, Some("chaman"), "SCOPE_POLICY") {
    def * = (scopeId, policyId) <> (ScopePolicyRow.tupled, ScopePolicyRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(scopeId), Rep.Some(policyId))).shaped.<>({r=>import r._; _1.map(_=> ScopePolicyRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column SCOPE_ID SqlType(VARCHAR), Length(36,true) */
    val scopeId: Rep[String] = column[String]("SCOPE_ID", O.Length(36,varying=true))
    /** Database column POLICY_ID SqlType(VARCHAR), Length(36,true) */
    val policyId: Rep[String] = column[String]("POLICY_ID", O.Length(36,varying=true))

    /** Primary key of ScopePolicy (database name SCOPE_POLICY_PK) */
    val pk = primaryKey("SCOPE_POLICY_PK", (scopeId, policyId))

    /** Foreign key referencing ResourceServerPolicy (database name FK_FRSRASP13XCX4WNKOG82SSRFY) */
    lazy val resourceServerPolicyFk = foreignKey("FK_FRSRASP13XCX4WNKOG82SSRFY", policyId, ResourceServerPolicy)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing ResourceServerScope (database name FK_FRSRPASS3XCX4WNKOG82SSRFY) */
    lazy val resourceServerScopeFk = foreignKey("FK_FRSRPASS3XCX4WNKOG82SSRFY", scopeId, ResourceServerScope)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table ScopePolicy */
  lazy val ScopePolicy = new TableQuery(tag => new ScopePolicy(tag))

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

  /** Entity class storing rows of table UserAttribute
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true)
   *  @param value Database column VALUE SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param userId Database column USER_ID SqlType(VARCHAR), Length(36,true)
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true), Default(sybase-needs-something-here) */
  case class UserAttributeRow(name: String, value: Option[String] = None, userId: String, id: String = "sybase-needs-something-here")
  /** GetResult implicit for fetching UserAttributeRow objects using plain SQL queries */
  implicit def GetResultUserAttributeRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[UserAttributeRow] = GR{
    prs => import prs._
    UserAttributeRow.tupled((<<[String], <<?[String], <<[String], <<[String]))
  }
  /** Table description of table USER_ATTRIBUTE. Objects of this class serve as prototypes for rows in queries. */
  class UserAttribute(_tableTag: Tag) extends profile.api.Table[UserAttributeRow](_tableTag, Some("chaman"), "USER_ATTRIBUTE") {
    def * = (name, value, userId, id) <> (UserAttributeRow.tupled, UserAttributeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(name), value, Rep.Some(userId), Rep.Some(id))).shaped.<>({r=>import r._; _1.map(_=> UserAttributeRow.tupled((_1.get, _2, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column NAME SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("NAME", O.Length(255,varying=true))
    /** Database column VALUE SqlType(VARCHAR), Length(255,true), Default(None) */
    val value: Rep[Option[String]] = column[Option[String]]("VALUE", O.Length(255,varying=true), O.Default(None))
    /** Database column USER_ID SqlType(VARCHAR), Length(36,true) */
    val userId: Rep[String] = column[String]("USER_ID", O.Length(36,varying=true))
    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true), Default(sybase-needs-something-here) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true), O.Default("sybase-needs-something-here"))

    /** Foreign key referencing UserEntity (database name FK_5HRM2VLF9QL5FU043KQEPOVBR) */
    lazy val userEntityFk = foreignKey("FK_5HRM2VLF9QL5FU043KQEPOVBR", userId, UserEntity)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Index over (name,value) (database name IDX_USER_ATTRIBUTE_NAME) */
    val index1 = index("IDX_USER_ATTRIBUTE_NAME", (name, value))
  }
  /** Collection-like TableQuery object for table UserAttribute */
  lazy val UserAttribute = new TableQuery(tag => new UserAttribute(tag))

  /** Entity class storing rows of table UserConsent
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param clientId Database column CLIENT_ID SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param userId Database column USER_ID SqlType(VARCHAR), Length(36,true)
   *  @param createdDate Database column CREATED_DATE SqlType(BIGINT), Default(None)
   *  @param lastUpdatedDate Database column LAST_UPDATED_DATE SqlType(BIGINT), Default(None)
   *  @param clientStorageProvider Database column CLIENT_STORAGE_PROVIDER SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param externalClientId Database column EXTERNAL_CLIENT_ID SqlType(VARCHAR), Length(255,true), Default(None) */
  case class UserConsentRow(id: String, clientId: Option[String] = None, userId: String, createdDate: Option[Long] = None, lastUpdatedDate: Option[Long] = None, clientStorageProvider: Option[String] = None, externalClientId: Option[String] = None)
  /** GetResult implicit for fetching UserConsentRow objects using plain SQL queries */
  implicit def GetResultUserConsentRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Option[Long]]): GR[UserConsentRow] = GR{
    prs => import prs._
    UserConsentRow.tupled((<<[String], <<?[String], <<[String], <<?[Long], <<?[Long], <<?[String], <<?[String]))
  }
  /** Table description of table USER_CONSENT. Objects of this class serve as prototypes for rows in queries. */
  class UserConsent(_tableTag: Tag) extends profile.api.Table[UserConsentRow](_tableTag, Some("chaman"), "USER_CONSENT") {
    def * = (id, clientId, userId, createdDate, lastUpdatedDate, clientStorageProvider, externalClientId) <> (UserConsentRow.tupled, UserConsentRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), clientId, Rep.Some(userId), createdDate, lastUpdatedDate, clientStorageProvider, externalClientId)).shaped.<>({r=>import r._; _1.map(_=> UserConsentRow.tupled((_1.get, _2, _3.get, _4, _5, _6, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column CLIENT_ID SqlType(VARCHAR), Length(255,true), Default(None) */
    val clientId: Rep[Option[String]] = column[Option[String]]("CLIENT_ID", O.Length(255,varying=true), O.Default(None))
    /** Database column USER_ID SqlType(VARCHAR), Length(36,true) */
    val userId: Rep[String] = column[String]("USER_ID", O.Length(36,varying=true))
    /** Database column CREATED_DATE SqlType(BIGINT), Default(None) */
    val createdDate: Rep[Option[Long]] = column[Option[Long]]("CREATED_DATE", O.Default(None))
    /** Database column LAST_UPDATED_DATE SqlType(BIGINT), Default(None) */
    val lastUpdatedDate: Rep[Option[Long]] = column[Option[Long]]("LAST_UPDATED_DATE", O.Default(None))
    /** Database column CLIENT_STORAGE_PROVIDER SqlType(VARCHAR), Length(36,true), Default(None) */
    val clientStorageProvider: Rep[Option[String]] = column[Option[String]]("CLIENT_STORAGE_PROVIDER", O.Length(36,varying=true), O.Default(None))
    /** Database column EXTERNAL_CLIENT_ID SqlType(VARCHAR), Length(255,true), Default(None) */
    val externalClientId: Rep[Option[String]] = column[Option[String]]("EXTERNAL_CLIENT_ID", O.Length(255,varying=true), O.Default(None))

    /** Foreign key referencing UserEntity (database name FK_GRNTCSNT_USER) */
    lazy val userEntityFk = foreignKey("FK_GRNTCSNT_USER", userId, UserEntity)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Uniqueness Index over (clientId,clientStorageProvider,externalClientId,userId) (database name UK_JKUWUVD56ONTGSUHOGM8UEWRT) */
    val index1 = index("UK_JKUWUVD56ONTGSUHOGM8UEWRT", (clientId, clientStorageProvider, externalClientId, userId), unique=true)
  }
  /** Collection-like TableQuery object for table UserConsent */
  lazy val UserConsent = new TableQuery(tag => new UserConsent(tag))

  /** Entity class storing rows of table UserConsentClientScope
   *  @param userConsentId Database column USER_CONSENT_ID SqlType(VARCHAR), Length(36,true)
   *  @param scopeId Database column SCOPE_ID SqlType(VARCHAR), Length(36,true) */
  case class UserConsentClientScopeRow(userConsentId: String, scopeId: String)
  /** GetResult implicit for fetching UserConsentClientScopeRow objects using plain SQL queries */
  implicit def GetResultUserConsentClientScopeRow(implicit e0: GR[String]): GR[UserConsentClientScopeRow] = GR{
    prs => import prs._
    UserConsentClientScopeRow.tupled((<<[String], <<[String]))
  }
  /** Table description of table USER_CONSENT_CLIENT_SCOPE. Objects of this class serve as prototypes for rows in queries. */
  class UserConsentClientScope(_tableTag: Tag) extends profile.api.Table[UserConsentClientScopeRow](_tableTag, Some("chaman"), "USER_CONSENT_CLIENT_SCOPE") {
    def * = (userConsentId, scopeId) <> (UserConsentClientScopeRow.tupled, UserConsentClientScopeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(userConsentId), Rep.Some(scopeId))).shaped.<>({r=>import r._; _1.map(_=> UserConsentClientScopeRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column USER_CONSENT_ID SqlType(VARCHAR), Length(36,true) */
    val userConsentId: Rep[String] = column[String]("USER_CONSENT_ID", O.Length(36,varying=true))
    /** Database column SCOPE_ID SqlType(VARCHAR), Length(36,true) */
    val scopeId: Rep[String] = column[String]("SCOPE_ID", O.Length(36,varying=true))

    /** Primary key of UserConsentClientScope (database name USER_CONSENT_CLIENT_SCOPE_PK) */
    val pk = primaryKey("USER_CONSENT_CLIENT_SCOPE_PK", (userConsentId, scopeId))

    /** Foreign key referencing UserConsent (database name FK_GRNTCSNT_CLSC_USC) */
    lazy val userConsentFk = foreignKey("FK_GRNTCSNT_CLSC_USC", userConsentId, UserConsent)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table UserConsentClientScope */
  lazy val UserConsentClientScope = new TableQuery(tag => new UserConsentClientScope(tag))

  /** Entity class storing rows of table UserEntity
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param email Database column EMAIL SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param emailConstraint Database column EMAIL_CONSTRAINT SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param emailVerified Database column EMAIL_VERIFIED SqlType(BIT), Default(false)
   *  @param enabled Database column ENABLED SqlType(BIT), Default(false)
   *  @param federationLink Database column FEDERATION_LINK SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param firstName Database column FIRST_NAME SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param lastName Database column LAST_NAME SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param username Database column USERNAME SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param createdTimestamp Database column CREATED_TIMESTAMP SqlType(BIGINT), Default(None)
   *  @param serviceAccountClientLink Database column SERVICE_ACCOUNT_CLIENT_LINK SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param notBefore Database column NOT_BEFORE SqlType(INT), Default(0) */
  case class UserEntityRow(id: String, email: Option[String] = None, emailConstraint: Option[String] = None, emailVerified: Boolean = false, enabled: Boolean = false, federationLink: Option[String] = None, firstName: Option[String] = None, lastName: Option[String] = None, realmId: Option[String] = None, username: Option[String] = None, createdTimestamp: Option[Long] = None, serviceAccountClientLink: Option[String] = None, notBefore: Int = 0)
  /** GetResult implicit for fetching UserEntityRow objects using plain SQL queries */
  implicit def GetResultUserEntityRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Boolean], e3: GR[Option[Long]], e4: GR[Int]): GR[UserEntityRow] = GR{
    prs => import prs._
    UserEntityRow.tupled((<<[String], <<?[String], <<?[String], <<[Boolean], <<[Boolean], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Long], <<?[String], <<[Int]))
  }
  /** Table description of table USER_ENTITY. Objects of this class serve as prototypes for rows in queries. */
  class UserEntity(_tableTag: Tag) extends profile.api.Table[UserEntityRow](_tableTag, Some("chaman"), "USER_ENTITY") {
    def * = (id, email, emailConstraint, emailVerified, enabled, federationLink, firstName, lastName, realmId, username, createdTimestamp, serviceAccountClientLink, notBefore) <> (UserEntityRow.tupled, UserEntityRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), email, emailConstraint, Rep.Some(emailVerified), Rep.Some(enabled), federationLink, firstName, lastName, realmId, username, createdTimestamp, serviceAccountClientLink, Rep.Some(notBefore))).shaped.<>({r=>import r._; _1.map(_=> UserEntityRow.tupled((_1.get, _2, _3, _4.get, _5.get, _6, _7, _8, _9, _10, _11, _12, _13.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column EMAIL SqlType(VARCHAR), Length(255,true), Default(None) */
    val email: Rep[Option[String]] = column[Option[String]]("EMAIL", O.Length(255,varying=true), O.Default(None))
    /** Database column EMAIL_CONSTRAINT SqlType(VARCHAR), Length(255,true), Default(None) */
    val emailConstraint: Rep[Option[String]] = column[Option[String]]("EMAIL_CONSTRAINT", O.Length(255,varying=true), O.Default(None))
    /** Database column EMAIL_VERIFIED SqlType(BIT), Default(false) */
    val emailVerified: Rep[Boolean] = column[Boolean]("EMAIL_VERIFIED", O.Default(false))
    /** Database column ENABLED SqlType(BIT), Default(false) */
    val enabled: Rep[Boolean] = column[Boolean]("ENABLED", O.Default(false))
    /** Database column FEDERATION_LINK SqlType(VARCHAR), Length(255,true), Default(None) */
    val federationLink: Rep[Option[String]] = column[Option[String]]("FEDERATION_LINK", O.Length(255,varying=true), O.Default(None))
    /** Database column FIRST_NAME SqlType(VARCHAR), Length(255,true), Default(None) */
    val firstName: Rep[Option[String]] = column[Option[String]]("FIRST_NAME", O.Length(255,varying=true), O.Default(None))
    /** Database column LAST_NAME SqlType(VARCHAR), Length(255,true), Default(None) */
    val lastName: Rep[Option[String]] = column[Option[String]]("LAST_NAME", O.Length(255,varying=true), O.Default(None))
    /** Database column REALM_ID SqlType(VARCHAR), Length(255,true), Default(None) */
    val realmId: Rep[Option[String]] = column[Option[String]]("REALM_ID", O.Length(255,varying=true), O.Default(None))
    /** Database column USERNAME SqlType(VARCHAR), Length(255,true), Default(None) */
    val username: Rep[Option[String]] = column[Option[String]]("USERNAME", O.Length(255,varying=true), O.Default(None))
    /** Database column CREATED_TIMESTAMP SqlType(BIGINT), Default(None) */
    val createdTimestamp: Rep[Option[Long]] = column[Option[Long]]("CREATED_TIMESTAMP", O.Default(None))
    /** Database column SERVICE_ACCOUNT_CLIENT_LINK SqlType(VARCHAR), Length(255,true), Default(None) */
    val serviceAccountClientLink: Rep[Option[String]] = column[Option[String]]("SERVICE_ACCOUNT_CLIENT_LINK", O.Length(255,varying=true), O.Default(None))
    /** Database column NOT_BEFORE SqlType(INT), Default(0) */
    val notBefore: Rep[Int] = column[Int]("NOT_BEFORE", O.Default(0))

    /** Index over (email) (database name IDX_USER_EMAIL) */
    val index1 = index("IDX_USER_EMAIL", email)
    /** Uniqueness Index over (realmId,emailConstraint) (database name UK_DYKN684SL8UP1CRFEI6ECKHD7) */
    val index2 = index("UK_DYKN684SL8UP1CRFEI6ECKHD7", (realmId, emailConstraint), unique=true)
    /** Uniqueness Index over (realmId,username) (database name UK_RU8TT6T700S9V50BU18WS5HA6) */
    val index3 = index("UK_RU8TT6T700S9V50BU18WS5HA6", (realmId, username), unique=true)
  }
  /** Collection-like TableQuery object for table UserEntity */
  lazy val UserEntity = new TableQuery(tag => new UserEntity(tag))

  /** Entity class storing rows of table UserFederationConfig
   *  @param userFederationProviderId Database column USER_FEDERATION_PROVIDER_ID SqlType(VARCHAR), Length(36,true)
   *  @param value Database column VALUE SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true) */
  case class UserFederationConfigRow(userFederationProviderId: String, value: Option[String] = None, name: String)
  /** GetResult implicit for fetching UserFederationConfigRow objects using plain SQL queries */
  implicit def GetResultUserFederationConfigRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[UserFederationConfigRow] = GR{
    prs => import prs._
    UserFederationConfigRow.tupled((<<[String], <<?[String], <<[String]))
  }
  /** Table description of table USER_FEDERATION_CONFIG. Objects of this class serve as prototypes for rows in queries. */
  class UserFederationConfig(_tableTag: Tag) extends profile.api.Table[UserFederationConfigRow](_tableTag, Some("chaman"), "USER_FEDERATION_CONFIG") {
    def * = (userFederationProviderId, value, name) <> (UserFederationConfigRow.tupled, UserFederationConfigRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(userFederationProviderId), value, Rep.Some(name))).shaped.<>({r=>import r._; _1.map(_=> UserFederationConfigRow.tupled((_1.get, _2, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column USER_FEDERATION_PROVIDER_ID SqlType(VARCHAR), Length(36,true) */
    val userFederationProviderId: Rep[String] = column[String]("USER_FEDERATION_PROVIDER_ID", O.Length(36,varying=true))
    /** Database column VALUE SqlType(VARCHAR), Length(255,true), Default(None) */
    val value: Rep[Option[String]] = column[Option[String]]("VALUE", O.Length(255,varying=true), O.Default(None))
    /** Database column NAME SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("NAME", O.Length(255,varying=true))

    /** Primary key of UserFederationConfig (database name USER_FEDERATION_CONFIG_PK) */
    val pk = primaryKey("USER_FEDERATION_CONFIG_PK", (userFederationProviderId, name))

    /** Foreign key referencing UserFederationProvider (database name FK_T13HPU1J94R2EBPEKR39X5EU5) */
    lazy val userFederationProviderFk = foreignKey("FK_T13HPU1J94R2EBPEKR39X5EU5", userFederationProviderId, UserFederationProvider)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table UserFederationConfig */
  lazy val UserFederationConfig = new TableQuery(tag => new UserFederationConfig(tag))

  /** Entity class storing rows of table UserFederationMapper
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true)
   *  @param federationProviderId Database column FEDERATION_PROVIDER_ID SqlType(VARCHAR), Length(36,true)
   *  @param federationMapperType Database column FEDERATION_MAPPER_TYPE SqlType(VARCHAR), Length(255,true)
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(36,true) */
  case class UserFederationMapperRow(id: String, name: String, federationProviderId: String, federationMapperType: String, realmId: String)
  /** GetResult implicit for fetching UserFederationMapperRow objects using plain SQL queries */
  implicit def GetResultUserFederationMapperRow(implicit e0: GR[String]): GR[UserFederationMapperRow] = GR{
    prs => import prs._
    UserFederationMapperRow.tupled((<<[String], <<[String], <<[String], <<[String], <<[String]))
  }
  /** Table description of table USER_FEDERATION_MAPPER. Objects of this class serve as prototypes for rows in queries. */
  class UserFederationMapper(_tableTag: Tag) extends profile.api.Table[UserFederationMapperRow](_tableTag, Some("chaman"), "USER_FEDERATION_MAPPER") {
    def * = (id, name, federationProviderId, federationMapperType, realmId) <> (UserFederationMapperRow.tupled, UserFederationMapperRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(name), Rep.Some(federationProviderId), Rep.Some(federationMapperType), Rep.Some(realmId))).shaped.<>({r=>import r._; _1.map(_=> UserFederationMapperRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column NAME SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("NAME", O.Length(255,varying=true))
    /** Database column FEDERATION_PROVIDER_ID SqlType(VARCHAR), Length(36,true) */
    val federationProviderId: Rep[String] = column[String]("FEDERATION_PROVIDER_ID", O.Length(36,varying=true))
    /** Database column FEDERATION_MAPPER_TYPE SqlType(VARCHAR), Length(255,true) */
    val federationMapperType: Rep[String] = column[String]("FEDERATION_MAPPER_TYPE", O.Length(255,varying=true))
    /** Database column REALM_ID SqlType(VARCHAR), Length(36,true) */
    val realmId: Rep[String] = column[String]("REALM_ID", O.Length(36,varying=true))

    /** Foreign key referencing Realm (database name FK_FEDMAPPERPM_REALM) */
    lazy val realmFk = foreignKey("FK_FEDMAPPERPM_REALM", realmId, Realm)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing UserFederationProvider (database name FK_FEDMAPPERPM_FEDPRV) */
    lazy val userFederationProviderFk = foreignKey("FK_FEDMAPPERPM_FEDPRV", federationProviderId, UserFederationProvider)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table UserFederationMapper */
  lazy val UserFederationMapper = new TableQuery(tag => new UserFederationMapper(tag))

  /** Entity class storing rows of table UserFederationMapperConfig
   *  @param userFederationMapperId Database column USER_FEDERATION_MAPPER_ID SqlType(VARCHAR), Length(36,true)
   *  @param value Database column VALUE SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true) */
  case class UserFederationMapperConfigRow(userFederationMapperId: String, value: Option[String] = None, name: String)
  /** GetResult implicit for fetching UserFederationMapperConfigRow objects using plain SQL queries */
  implicit def GetResultUserFederationMapperConfigRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[UserFederationMapperConfigRow] = GR{
    prs => import prs._
    UserFederationMapperConfigRow.tupled((<<[String], <<?[String], <<[String]))
  }
  /** Table description of table USER_FEDERATION_MAPPER_CONFIG. Objects of this class serve as prototypes for rows in queries. */
  class UserFederationMapperConfig(_tableTag: Tag) extends profile.api.Table[UserFederationMapperConfigRow](_tableTag, Some("chaman"), "USER_FEDERATION_MAPPER_CONFIG") {
    def * = (userFederationMapperId, value, name) <> (UserFederationMapperConfigRow.tupled, UserFederationMapperConfigRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(userFederationMapperId), value, Rep.Some(name))).shaped.<>({r=>import r._; _1.map(_=> UserFederationMapperConfigRow.tupled((_1.get, _2, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column USER_FEDERATION_MAPPER_ID SqlType(VARCHAR), Length(36,true) */
    val userFederationMapperId: Rep[String] = column[String]("USER_FEDERATION_MAPPER_ID", O.Length(36,varying=true))
    /** Database column VALUE SqlType(VARCHAR), Length(255,true), Default(None) */
    val value: Rep[Option[String]] = column[Option[String]]("VALUE", O.Length(255,varying=true), O.Default(None))
    /** Database column NAME SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("NAME", O.Length(255,varying=true))

    /** Primary key of UserFederationMapperConfig (database name USER_FEDERATION_MAPPER_CONFIG_PK) */
    val pk = primaryKey("USER_FEDERATION_MAPPER_CONFIG_PK", (userFederationMapperId, name))

    /** Foreign key referencing UserFederationMapper (database name FK_FEDMAPPER_CFG) */
    lazy val userFederationMapperFk = foreignKey("FK_FEDMAPPER_CFG", userFederationMapperId, UserFederationMapper)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table UserFederationMapperConfig */
  lazy val UserFederationMapperConfig = new TableQuery(tag => new UserFederationMapperConfig(tag))

  /** Entity class storing rows of table UserFederationProvider
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param changedSyncPeriod Database column CHANGED_SYNC_PERIOD SqlType(INT), Default(None)
   *  @param displayName Database column DISPLAY_NAME SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param fullSyncPeriod Database column FULL_SYNC_PERIOD SqlType(INT), Default(None)
   *  @param lastSync Database column LAST_SYNC SqlType(INT), Default(None)
   *  @param priority Database column PRIORITY SqlType(INT), Default(None)
   *  @param providerName Database column PROVIDER_NAME SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(36,true), Default(None) */
  case class UserFederationProviderRow(id: String, changedSyncPeriod: Option[Int] = None, displayName: Option[String] = None, fullSyncPeriod: Option[Int] = None, lastSync: Option[Int] = None, priority: Option[Int] = None, providerName: Option[String] = None, realmId: Option[String] = None)
  /** GetResult implicit for fetching UserFederationProviderRow objects using plain SQL queries */
  implicit def GetResultUserFederationProviderRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]]): GR[UserFederationProviderRow] = GR{
    prs => import prs._
    UserFederationProviderRow.tupled((<<[String], <<?[Int], <<?[String], <<?[Int], <<?[Int], <<?[Int], <<?[String], <<?[String]))
  }
  /** Table description of table USER_FEDERATION_PROVIDER. Objects of this class serve as prototypes for rows in queries. */
  class UserFederationProvider(_tableTag: Tag) extends profile.api.Table[UserFederationProviderRow](_tableTag, Some("chaman"), "USER_FEDERATION_PROVIDER") {
    def * = (id, changedSyncPeriod, displayName, fullSyncPeriod, lastSync, priority, providerName, realmId) <> (UserFederationProviderRow.tupled, UserFederationProviderRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), changedSyncPeriod, displayName, fullSyncPeriod, lastSync, priority, providerName, realmId)).shaped.<>({r=>import r._; _1.map(_=> UserFederationProviderRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column CHANGED_SYNC_PERIOD SqlType(INT), Default(None) */
    val changedSyncPeriod: Rep[Option[Int]] = column[Option[Int]]("CHANGED_SYNC_PERIOD", O.Default(None))
    /** Database column DISPLAY_NAME SqlType(VARCHAR), Length(255,true), Default(None) */
    val displayName: Rep[Option[String]] = column[Option[String]]("DISPLAY_NAME", O.Length(255,varying=true), O.Default(None))
    /** Database column FULL_SYNC_PERIOD SqlType(INT), Default(None) */
    val fullSyncPeriod: Rep[Option[Int]] = column[Option[Int]]("FULL_SYNC_PERIOD", O.Default(None))
    /** Database column LAST_SYNC SqlType(INT), Default(None) */
    val lastSync: Rep[Option[Int]] = column[Option[Int]]("LAST_SYNC", O.Default(None))
    /** Database column PRIORITY SqlType(INT), Default(None) */
    val priority: Rep[Option[Int]] = column[Option[Int]]("PRIORITY", O.Default(None))
    /** Database column PROVIDER_NAME SqlType(VARCHAR), Length(255,true), Default(None) */
    val providerName: Rep[Option[String]] = column[Option[String]]("PROVIDER_NAME", O.Length(255,varying=true), O.Default(None))
    /** Database column REALM_ID SqlType(VARCHAR), Length(36,true), Default(None) */
    val realmId: Rep[Option[String]] = column[Option[String]]("REALM_ID", O.Length(36,varying=true), O.Default(None))

    /** Foreign key referencing Realm (database name FK_1FJ32F6PTOLW2QY60CD8N01E8) */
    lazy val realmFk = foreignKey("FK_1FJ32F6PTOLW2QY60CD8N01E8", realmId, Realm)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table UserFederationProvider */
  lazy val UserFederationProvider = new TableQuery(tag => new UserFederationProvider(tag))

  /** Entity class storing rows of table UserGroupMembership
   *  @param groupId Database column GROUP_ID SqlType(VARCHAR), Length(36,true)
   *  @param userId Database column USER_ID SqlType(VARCHAR), Length(36,true) */
  case class UserGroupMembershipRow(groupId: String, userId: String)
  /** GetResult implicit for fetching UserGroupMembershipRow objects using plain SQL queries */
  implicit def GetResultUserGroupMembershipRow(implicit e0: GR[String]): GR[UserGroupMembershipRow] = GR{
    prs => import prs._
    UserGroupMembershipRow.tupled((<<[String], <<[String]))
  }
  /** Table description of table USER_GROUP_MEMBERSHIP. Objects of this class serve as prototypes for rows in queries. */
  class UserGroupMembership(_tableTag: Tag) extends profile.api.Table[UserGroupMembershipRow](_tableTag, Some("chaman"), "USER_GROUP_MEMBERSHIP") {
    def * = (groupId, userId) <> (UserGroupMembershipRow.tupled, UserGroupMembershipRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(groupId), Rep.Some(userId))).shaped.<>({r=>import r._; _1.map(_=> UserGroupMembershipRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column GROUP_ID SqlType(VARCHAR), Length(36,true) */
    val groupId: Rep[String] = column[String]("GROUP_ID", O.Length(36,varying=true))
    /** Database column USER_ID SqlType(VARCHAR), Length(36,true) */
    val userId: Rep[String] = column[String]("USER_ID", O.Length(36,varying=true))

    /** Primary key of UserGroupMembership (database name USER_GROUP_MEMBERSHIP_PK) */
    val pk = primaryKey("USER_GROUP_MEMBERSHIP_PK", (groupId, userId))

    /** Foreign key referencing UserEntity (database name FK_USER_GROUP_USER) */
    lazy val userEntityFk = foreignKey("FK_USER_GROUP_USER", userId, UserEntity)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table UserGroupMembership */
  lazy val UserGroupMembership = new TableQuery(tag => new UserGroupMembership(tag))

  /** Entity class storing rows of table UsernameLoginFailure
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(36,true)
   *  @param username Database column USERNAME SqlType(VARCHAR), Length(255,true)
   *  @param failedLoginNotBefore Database column FAILED_LOGIN_NOT_BEFORE SqlType(INT), Default(None)
   *  @param lastFailure Database column LAST_FAILURE SqlType(BIGINT), Default(None)
   *  @param lastIpFailure Database column LAST_IP_FAILURE SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param numFailures Database column NUM_FAILURES SqlType(INT), Default(None) */
  case class UsernameLoginFailureRow(realmId: String, username: String, failedLoginNotBefore: Option[Int] = None, lastFailure: Option[Long] = None, lastIpFailure: Option[String] = None, numFailures: Option[Int] = None)
  /** GetResult implicit for fetching UsernameLoginFailureRow objects using plain SQL queries */
  implicit def GetResultUsernameLoginFailureRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[Long]], e3: GR[Option[String]]): GR[UsernameLoginFailureRow] = GR{
    prs => import prs._
    UsernameLoginFailureRow.tupled((<<[String], <<[String], <<?[Int], <<?[Long], <<?[String], <<?[Int]))
  }
  /** Table description of table USERNAME_LOGIN_FAILURE. Objects of this class serve as prototypes for rows in queries. */
  class UsernameLoginFailure(_tableTag: Tag) extends profile.api.Table[UsernameLoginFailureRow](_tableTag, Some("chaman"), "USERNAME_LOGIN_FAILURE") {
    def * = (realmId, username, failedLoginNotBefore, lastFailure, lastIpFailure, numFailures) <> (UsernameLoginFailureRow.tupled, UsernameLoginFailureRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(realmId), Rep.Some(username), failedLoginNotBefore, lastFailure, lastIpFailure, numFailures)).shaped.<>({r=>import r._; _1.map(_=> UsernameLoginFailureRow.tupled((_1.get, _2.get, _3, _4, _5, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column REALM_ID SqlType(VARCHAR), Length(36,true) */
    val realmId: Rep[String] = column[String]("REALM_ID", O.Length(36,varying=true))
    /** Database column USERNAME SqlType(VARCHAR), Length(255,true) */
    val username: Rep[String] = column[String]("USERNAME", O.Length(255,varying=true))
    /** Database column FAILED_LOGIN_NOT_BEFORE SqlType(INT), Default(None) */
    val failedLoginNotBefore: Rep[Option[Int]] = column[Option[Int]]("FAILED_LOGIN_NOT_BEFORE", O.Default(None))
    /** Database column LAST_FAILURE SqlType(BIGINT), Default(None) */
    val lastFailure: Rep[Option[Long]] = column[Option[Long]]("LAST_FAILURE", O.Default(None))
    /** Database column LAST_IP_FAILURE SqlType(VARCHAR), Length(255,true), Default(None) */
    val lastIpFailure: Rep[Option[String]] = column[Option[String]]("LAST_IP_FAILURE", O.Length(255,varying=true), O.Default(None))
    /** Database column NUM_FAILURES SqlType(INT), Default(None) */
    val numFailures: Rep[Option[Int]] = column[Option[Int]]("NUM_FAILURES", O.Default(None))

    /** Primary key of UsernameLoginFailure (database name USERNAME_LOGIN_FAILURE_PK) */
    val pk = primaryKey("USERNAME_LOGIN_FAILURE_PK", (realmId, username))
  }
  /** Collection-like TableQuery object for table UsernameLoginFailure */
  lazy val UsernameLoginFailure = new TableQuery(tag => new UsernameLoginFailure(tag))

  /** Entity class storing rows of table UserRequiredAction
   *  @param userId Database column USER_ID SqlType(VARCHAR), Length(36,true)
   *  @param requiredAction Database column REQUIRED_ACTION SqlType(VARCHAR), Length(255,true), Default( ) */
  case class UserRequiredActionRow(userId: String, requiredAction: String = " ")
  /** GetResult implicit for fetching UserRequiredActionRow objects using plain SQL queries */
  implicit def GetResultUserRequiredActionRow(implicit e0: GR[String]): GR[UserRequiredActionRow] = GR{
    prs => import prs._
    UserRequiredActionRow.tupled((<<[String], <<[String]))
  }
  /** Table description of table USER_REQUIRED_ACTION. Objects of this class serve as prototypes for rows in queries. */
  class UserRequiredAction(_tableTag: Tag) extends profile.api.Table[UserRequiredActionRow](_tableTag, Some("chaman"), "USER_REQUIRED_ACTION") {
    def * = (userId, requiredAction) <> (UserRequiredActionRow.tupled, UserRequiredActionRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(userId), Rep.Some(requiredAction))).shaped.<>({r=>import r._; _1.map(_=> UserRequiredActionRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column USER_ID SqlType(VARCHAR), Length(36,true) */
    val userId: Rep[String] = column[String]("USER_ID", O.Length(36,varying=true))
    /** Database column REQUIRED_ACTION SqlType(VARCHAR), Length(255,true), Default( ) */
    val requiredAction: Rep[String] = column[String]("REQUIRED_ACTION", O.Length(255,varying=true), O.Default(" "))

    /** Primary key of UserRequiredAction (database name USER_REQUIRED_ACTION_PK) */
    val pk = primaryKey("USER_REQUIRED_ACTION_PK", (requiredAction, userId))

    /** Foreign key referencing UserEntity (database name FK_6QJ3W1JW9CVAFHE19BWSIUVMD) */
    lazy val userEntityFk = foreignKey("FK_6QJ3W1JW9CVAFHE19BWSIUVMD", userId, UserEntity)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table UserRequiredAction */
  lazy val UserRequiredAction = new TableQuery(tag => new UserRequiredAction(tag))

  /** Entity class storing rows of table UserRoleMapping
   *  @param roleId Database column ROLE_ID SqlType(VARCHAR), Length(255,true)
   *  @param userId Database column USER_ID SqlType(VARCHAR), Length(36,true) */
  case class UserRoleMappingRow(roleId: String, userId: String)
  /** GetResult implicit for fetching UserRoleMappingRow objects using plain SQL queries */
  implicit def GetResultUserRoleMappingRow(implicit e0: GR[String]): GR[UserRoleMappingRow] = GR{
    prs => import prs._
    UserRoleMappingRow.tupled((<<[String], <<[String]))
  }
  /** Table description of table USER_ROLE_MAPPING. Objects of this class serve as prototypes for rows in queries. */
  class UserRoleMapping(_tableTag: Tag) extends profile.api.Table[UserRoleMappingRow](_tableTag, Some("chaman"), "USER_ROLE_MAPPING") {
    def * = (roleId, userId) <> (UserRoleMappingRow.tupled, UserRoleMappingRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(roleId), Rep.Some(userId))).shaped.<>({r=>import r._; _1.map(_=> UserRoleMappingRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ROLE_ID SqlType(VARCHAR), Length(255,true) */
    val roleId: Rep[String] = column[String]("ROLE_ID", O.Length(255,varying=true))
    /** Database column USER_ID SqlType(VARCHAR), Length(36,true) */
    val userId: Rep[String] = column[String]("USER_ID", O.Length(36,varying=true))

    /** Primary key of UserRoleMapping (database name USER_ROLE_MAPPING_PK) */
    val pk = primaryKey("USER_ROLE_MAPPING_PK", (roleId, userId))

    /** Foreign key referencing UserEntity (database name FK_C4FQV34P1MBYLLOXANG7B1Q3L) */
    lazy val userEntityFk = foreignKey("FK_C4FQV34P1MBYLLOXANG7B1Q3L", userId, UserEntity)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table UserRoleMapping */
  lazy val UserRoleMapping = new TableQuery(tag => new UserRoleMapping(tag))

  /** Entity class storing rows of table UserSession
   *  @param id Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param authMethod Database column AUTH_METHOD SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param ipAddress Database column IP_ADDRESS SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param lastSessionRefresh Database column LAST_SESSION_REFRESH SqlType(INT), Default(None)
   *  @param loginUsername Database column LOGIN_USERNAME SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param realmId Database column REALM_ID SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param rememberMe Database column REMEMBER_ME SqlType(BIT), Default(false)
   *  @param started Database column STARTED SqlType(INT), Default(None)
   *  @param userId Database column USER_ID SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param userSessionState Database column USER_SESSION_STATE SqlType(INT), Default(None)
   *  @param brokerSessionId Database column BROKER_SESSION_ID SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param brokerUserId Database column BROKER_USER_ID SqlType(VARCHAR), Length(255,true), Default(None) */
  case class UserSessionRow(id: String, authMethod: Option[String] = None, ipAddress: Option[String] = None, lastSessionRefresh: Option[Int] = None, loginUsername: Option[String] = None, realmId: Option[String] = None, rememberMe: Boolean = false, started: Option[Int] = None, userId: Option[String] = None, userSessionState: Option[Int] = None, brokerSessionId: Option[String] = None, brokerUserId: Option[String] = None)
  /** GetResult implicit for fetching UserSessionRow objects using plain SQL queries */
  implicit def GetResultUserSessionRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[Boolean]): GR[UserSessionRow] = GR{
    prs => import prs._
    UserSessionRow.tupled((<<[String], <<?[String], <<?[String], <<?[Int], <<?[String], <<?[String], <<[Boolean], <<?[Int], <<?[String], <<?[Int], <<?[String], <<?[String]))
  }
  /** Table description of table USER_SESSION. Objects of this class serve as prototypes for rows in queries. */
  class UserSession(_tableTag: Tag) extends profile.api.Table[UserSessionRow](_tableTag, Some("chaman"), "USER_SESSION") {
    def * = (id, authMethod, ipAddress, lastSessionRefresh, loginUsername, realmId, rememberMe, started, userId, userSessionState, brokerSessionId, brokerUserId) <> (UserSessionRow.tupled, UserSessionRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), authMethod, ipAddress, lastSessionRefresh, loginUsername, realmId, Rep.Some(rememberMe), started, userId, userSessionState, brokerSessionId, brokerUserId)).shaped.<>({r=>import r._; _1.map(_=> UserSessionRow.tupled((_1.get, _2, _3, _4, _5, _6, _7.get, _8, _9, _10, _11, _12)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val id: Rep[String] = column[String]("ID", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column AUTH_METHOD SqlType(VARCHAR), Length(255,true), Default(None) */
    val authMethod: Rep[Option[String]] = column[Option[String]]("AUTH_METHOD", O.Length(255,varying=true), O.Default(None))
    /** Database column IP_ADDRESS SqlType(VARCHAR), Length(255,true), Default(None) */
    val ipAddress: Rep[Option[String]] = column[Option[String]]("IP_ADDRESS", O.Length(255,varying=true), O.Default(None))
    /** Database column LAST_SESSION_REFRESH SqlType(INT), Default(None) */
    val lastSessionRefresh: Rep[Option[Int]] = column[Option[Int]]("LAST_SESSION_REFRESH", O.Default(None))
    /** Database column LOGIN_USERNAME SqlType(VARCHAR), Length(255,true), Default(None) */
    val loginUsername: Rep[Option[String]] = column[Option[String]]("LOGIN_USERNAME", O.Length(255,varying=true), O.Default(None))
    /** Database column REALM_ID SqlType(VARCHAR), Length(255,true), Default(None) */
    val realmId: Rep[Option[String]] = column[Option[String]]("REALM_ID", O.Length(255,varying=true), O.Default(None))
    /** Database column REMEMBER_ME SqlType(BIT), Default(false) */
    val rememberMe: Rep[Boolean] = column[Boolean]("REMEMBER_ME", O.Default(false))
    /** Database column STARTED SqlType(INT), Default(None) */
    val started: Rep[Option[Int]] = column[Option[Int]]("STARTED", O.Default(None))
    /** Database column USER_ID SqlType(VARCHAR), Length(255,true), Default(None) */
    val userId: Rep[Option[String]] = column[Option[String]]("USER_ID", O.Length(255,varying=true), O.Default(None))
    /** Database column USER_SESSION_STATE SqlType(INT), Default(None) */
    val userSessionState: Rep[Option[Int]] = column[Option[Int]]("USER_SESSION_STATE", O.Default(None))
    /** Database column BROKER_SESSION_ID SqlType(VARCHAR), Length(255,true), Default(None) */
    val brokerSessionId: Rep[Option[String]] = column[Option[String]]("BROKER_SESSION_ID", O.Length(255,varying=true), O.Default(None))
    /** Database column BROKER_USER_ID SqlType(VARCHAR), Length(255,true), Default(None) */
    val brokerUserId: Rep[Option[String]] = column[Option[String]]("BROKER_USER_ID", O.Length(255,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table UserSession */
  lazy val UserSession = new TableQuery(tag => new UserSession(tag))

  /** Entity class storing rows of table UserSessionNote
   *  @param userSession Database column USER_SESSION SqlType(VARCHAR), Length(36,true)
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true)
   *  @param value Database column VALUE SqlType(TEXT), Default(None) */
  case class UserSessionNoteRow(userSession: String, name: String, value: Option[String] = None)
  /** GetResult implicit for fetching UserSessionNoteRow objects using plain SQL queries */
  implicit def GetResultUserSessionNoteRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[UserSessionNoteRow] = GR{
    prs => import prs._
    UserSessionNoteRow.tupled((<<[String], <<[String], <<?[String]))
  }
  /** Table description of table USER_SESSION_NOTE. Objects of this class serve as prototypes for rows in queries. */
  class UserSessionNote(_tableTag: Tag) extends profile.api.Table[UserSessionNoteRow](_tableTag, Some("chaman"), "USER_SESSION_NOTE") {
    def * = (userSession, name, value) <> (UserSessionNoteRow.tupled, UserSessionNoteRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(userSession), Rep.Some(name), value)).shaped.<>({r=>import r._; _1.map(_=> UserSessionNoteRow.tupled((_1.get, _2.get, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column USER_SESSION SqlType(VARCHAR), Length(36,true) */
    val userSession: Rep[String] = column[String]("USER_SESSION", O.Length(36,varying=true))
    /** Database column NAME SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("NAME", O.Length(255,varying=true))
    /** Database column VALUE SqlType(TEXT), Default(None) */
    val value: Rep[Option[String]] = column[Option[String]]("VALUE", O.Default(None))

    /** Primary key of UserSessionNote (database name USER_SESSION_NOTE_PK) */
    val pk = primaryKey("USER_SESSION_NOTE_PK", (userSession, name))

    /** Foreign key referencing UserSession (database name FK5EDFB00FF51D3472) */
    lazy val userSessionFk = foreignKey("FK5EDFB00FF51D3472", userSession, UserSession)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table UserSessionNote */
  lazy val UserSessionNote = new TableQuery(tag => new UserSessionNote(tag))

  /** Entity class storing rows of table WebOrigins
   *  @param clientId Database column CLIENT_ID SqlType(VARCHAR), Length(36,true)
   *  @param value Database column VALUE SqlType(VARCHAR), Length(255,true) */
  case class WebOriginsRow(clientId: String, value: String)
  /** GetResult implicit for fetching WebOriginsRow objects using plain SQL queries */
  implicit def GetResultWebOriginsRow(implicit e0: GR[String]): GR[WebOriginsRow] = GR{
    prs => import prs._
    WebOriginsRow.tupled((<<[String], <<[String]))
  }
  /** Table description of table WEB_ORIGINS. Objects of this class serve as prototypes for rows in queries. */
  class WebOrigins(_tableTag: Tag) extends profile.api.Table[WebOriginsRow](_tableTag, Some("chaman"), "WEB_ORIGINS") {
    def * = (clientId, value) <> (WebOriginsRow.tupled, WebOriginsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(clientId), Rep.Some(value))).shaped.<>({r=>import r._; _1.map(_=> WebOriginsRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column CLIENT_ID SqlType(VARCHAR), Length(36,true) */
    val clientId: Rep[String] = column[String]("CLIENT_ID", O.Length(36,varying=true))
    /** Database column VALUE SqlType(VARCHAR), Length(255,true) */
    val value: Rep[String] = column[String]("VALUE", O.Length(255,varying=true))

    /** Primary key of WebOrigins (database name WEB_ORIGINS_PK) */
    val pk = primaryKey("WEB_ORIGINS_PK", (clientId, value))

    /** Foreign key referencing Client (database name FK_LOJPHO213XCX4WNKOG82SSRFY) */
    lazy val clientFk = foreignKey("FK_LOJPHO213XCX4WNKOG82SSRFY", clientId, Client)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table WebOrigins */
  lazy val WebOrigins = new TableQuery(tag => new WebOrigins(tag))
}
