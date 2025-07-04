PGDMP  7                    }            keycloaklicenta    16.4 (Debian 16.4-1.pgdg120+2)    16.4 �   �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    18030    keycloaklicenta    DATABASE     z   CREATE DATABASE keycloaklicenta WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.utf8';
    DROP DATABASE keycloaklicenta;
                postgres    false            �            1259    18031    admin_event_entity    TABLE     
  CREATE TABLE public.admin_event_entity (
    id character varying(36) NOT NULL,
    admin_event_time bigint,
    realm_id character varying(255),
    operation_type character varying(255),
    auth_realm_id character varying(255),
    auth_client_id character varying(255),
    auth_user_id character varying(255),
    ip_address character varying(255),
    resource_path character varying(2550),
    representation text,
    error character varying(255),
    resource_type character varying(64),
    details_json text
);
 &   DROP TABLE public.admin_event_entity;
       public         heap    postgres    false            �            1259    18036    associated_policy    TABLE     �   CREATE TABLE public.associated_policy (
    policy_id character varying(36) NOT NULL,
    associated_policy_id character varying(36) NOT NULL
);
 %   DROP TABLE public.associated_policy;
       public         heap    postgres    false            �            1259    18039    authentication_execution    TABLE     �  CREATE TABLE public.authentication_execution (
    id character varying(36) NOT NULL,
    alias character varying(255),
    authenticator character varying(36),
    realm_id character varying(36),
    flow_id character varying(36),
    requirement integer,
    priority integer,
    authenticator_flow boolean DEFAULT false NOT NULL,
    auth_flow_id character varying(36),
    auth_config character varying(36)
);
 ,   DROP TABLE public.authentication_execution;
       public         heap    postgres    false            �            1259    18043    authentication_flow    TABLE     t  CREATE TABLE public.authentication_flow (
    id character varying(36) NOT NULL,
    alias character varying(255),
    description character varying(255),
    realm_id character varying(36),
    provider_id character varying(36) DEFAULT 'basic-flow'::character varying NOT NULL,
    top_level boolean DEFAULT false NOT NULL,
    built_in boolean DEFAULT false NOT NULL
);
 '   DROP TABLE public.authentication_flow;
       public         heap    postgres    false            �            1259    18051    authenticator_config    TABLE     �   CREATE TABLE public.authenticator_config (
    id character varying(36) NOT NULL,
    alias character varying(255),
    realm_id character varying(36)
);
 (   DROP TABLE public.authenticator_config;
       public         heap    postgres    false            �            1259    18054    authenticator_config_entry    TABLE     �   CREATE TABLE public.authenticator_config_entry (
    authenticator_id character varying(36) NOT NULL,
    value text,
    name character varying(255) NOT NULL
);
 .   DROP TABLE public.authenticator_config_entry;
       public         heap    postgres    false            �            1259    18059    broker_link    TABLE     L  CREATE TABLE public.broker_link (
    identity_provider character varying(255) NOT NULL,
    storage_provider_id character varying(255),
    realm_id character varying(36) NOT NULL,
    broker_user_id character varying(255),
    broker_username character varying(255),
    token text,
    user_id character varying(255) NOT NULL
);
    DROP TABLE public.broker_link;
       public         heap    postgres    false            �            1259    18064    client    TABLE     �  CREATE TABLE public.client (
    id character varying(36) NOT NULL,
    enabled boolean DEFAULT false NOT NULL,
    full_scope_allowed boolean DEFAULT false NOT NULL,
    client_id character varying(255),
    not_before integer,
    public_client boolean DEFAULT false NOT NULL,
    secret character varying(255),
    base_url character varying(255),
    bearer_only boolean DEFAULT false NOT NULL,
    management_url character varying(255),
    surrogate_auth_required boolean DEFAULT false NOT NULL,
    realm_id character varying(36),
    protocol character varying(255),
    node_rereg_timeout integer DEFAULT 0,
    frontchannel_logout boolean DEFAULT false NOT NULL,
    consent_required boolean DEFAULT false NOT NULL,
    name character varying(255),
    service_accounts_enabled boolean DEFAULT false NOT NULL,
    client_authenticator_type character varying(255),
    root_url character varying(255),
    description character varying(255),
    registration_token character varying(255),
    standard_flow_enabled boolean DEFAULT true NOT NULL,
    implicit_flow_enabled boolean DEFAULT false NOT NULL,
    direct_access_grants_enabled boolean DEFAULT false NOT NULL,
    always_display_in_console boolean DEFAULT false NOT NULL
);
    DROP TABLE public.client;
       public         heap    postgres    false            �            1259    18082    client_attributes    TABLE     �   CREATE TABLE public.client_attributes (
    client_id character varying(36) NOT NULL,
    name character varying(255) NOT NULL,
    value text
);
 %   DROP TABLE public.client_attributes;
       public         heap    postgres    false            �            1259    18087    client_auth_flow_bindings    TABLE     �   CREATE TABLE public.client_auth_flow_bindings (
    client_id character varying(36) NOT NULL,
    flow_id character varying(36),
    binding_name character varying(255) NOT NULL
);
 -   DROP TABLE public.client_auth_flow_bindings;
       public         heap    postgres    false            �            1259    18090    client_initial_access    TABLE     �   CREATE TABLE public.client_initial_access (
    id character varying(36) NOT NULL,
    realm_id character varying(36) NOT NULL,
    "timestamp" integer,
    expiration integer,
    count integer,
    remaining_count integer
);
 )   DROP TABLE public.client_initial_access;
       public         heap    postgres    false            �            1259    18093    client_node_registrations    TABLE     �   CREATE TABLE public.client_node_registrations (
    client_id character varying(36) NOT NULL,
    value integer,
    name character varying(255) NOT NULL
);
 -   DROP TABLE public.client_node_registrations;
       public         heap    postgres    false            �            1259    18096    client_scope    TABLE     �   CREATE TABLE public.client_scope (
    id character varying(36) NOT NULL,
    name character varying(255),
    realm_id character varying(36),
    description character varying(255),
    protocol character varying(255)
);
     DROP TABLE public.client_scope;
       public         heap    postgres    false            �            1259    18101    client_scope_attributes    TABLE     �   CREATE TABLE public.client_scope_attributes (
    scope_id character varying(36) NOT NULL,
    value character varying(2048),
    name character varying(255) NOT NULL
);
 +   DROP TABLE public.client_scope_attributes;
       public         heap    postgres    false            �            1259    18106    client_scope_client    TABLE     �   CREATE TABLE public.client_scope_client (
    client_id character varying(255) NOT NULL,
    scope_id character varying(255) NOT NULL,
    default_scope boolean DEFAULT false NOT NULL
);
 '   DROP TABLE public.client_scope_client;
       public         heap    postgres    false            �            1259    18112    client_scope_role_mapping    TABLE     �   CREATE TABLE public.client_scope_role_mapping (
    scope_id character varying(36) NOT NULL,
    role_id character varying(36) NOT NULL
);
 -   DROP TABLE public.client_scope_role_mapping;
       public         heap    postgres    false            �            1259    18115 	   component    TABLE     )  CREATE TABLE public.component (
    id character varying(36) NOT NULL,
    name character varying(255),
    parent_id character varying(36),
    provider_id character varying(36),
    provider_type character varying(255),
    realm_id character varying(36),
    sub_type character varying(255)
);
    DROP TABLE public.component;
       public         heap    postgres    false            �            1259    18120    component_config    TABLE     �   CREATE TABLE public.component_config (
    id character varying(36) NOT NULL,
    component_id character varying(36) NOT NULL,
    name character varying(255) NOT NULL,
    value text
);
 $   DROP TABLE public.component_config;
       public         heap    postgres    false            �            1259    18125    composite_role    TABLE     �   CREATE TABLE public.composite_role (
    composite character varying(36) NOT NULL,
    child_role character varying(36) NOT NULL
);
 "   DROP TABLE public.composite_role;
       public         heap    postgres    false            �            1259    18128 
   credential    TABLE     C  CREATE TABLE public.credential (
    id character varying(36) NOT NULL,
    salt bytea,
    type character varying(255),
    user_id character varying(36),
    created_date bigint,
    user_label character varying(255),
    secret_data text,
    credential_data text,
    priority integer,
    version integer DEFAULT 0
);
    DROP TABLE public.credential;
       public         heap    postgres    false            �            1259    18134    databasechangelog    TABLE     Y  CREATE TABLE public.databasechangelog (
    id character varying(255) NOT NULL,
    author character varying(255) NOT NULL,
    filename character varying(255) NOT NULL,
    dateexecuted timestamp without time zone NOT NULL,
    orderexecuted integer NOT NULL,
    exectype character varying(10) NOT NULL,
    md5sum character varying(35),
    description character varying(255),
    comments character varying(255),
    tag character varying(255),
    liquibase character varying(20),
    contexts character varying(255),
    labels character varying(255),
    deployment_id character varying(10)
);
 %   DROP TABLE public.databasechangelog;
       public         heap    postgres    false            �            1259    18139    databasechangeloglock    TABLE     �   CREATE TABLE public.databasechangeloglock (
    id integer NOT NULL,
    locked boolean NOT NULL,
    lockgranted timestamp without time zone,
    lockedby character varying(255)
);
 )   DROP TABLE public.databasechangeloglock;
       public         heap    postgres    false            �            1259    18142    default_client_scope    TABLE     �   CREATE TABLE public.default_client_scope (
    realm_id character varying(36) NOT NULL,
    scope_id character varying(36) NOT NULL,
    default_scope boolean DEFAULT false NOT NULL
);
 (   DROP TABLE public.default_client_scope;
       public         heap    postgres    false            �            1259    18146    event_entity    TABLE     �  CREATE TABLE public.event_entity (
    id character varying(36) NOT NULL,
    client_id character varying(255),
    details_json character varying(2550),
    error character varying(255),
    ip_address character varying(255),
    realm_id character varying(255),
    session_id character varying(255),
    event_time bigint,
    type character varying(255),
    user_id character varying(255),
    details_json_long_value text
);
     DROP TABLE public.event_entity;
       public         heap    postgres    false            �            1259    18151    fed_user_attribute    TABLE     ~  CREATE TABLE public.fed_user_attribute (
    id character varying(36) NOT NULL,
    name character varying(255) NOT NULL,
    user_id character varying(255) NOT NULL,
    realm_id character varying(36) NOT NULL,
    storage_provider_id character varying(36),
    value character varying(2024),
    long_value_hash bytea,
    long_value_hash_lower_case bytea,
    long_value text
);
 &   DROP TABLE public.fed_user_attribute;
       public         heap    postgres    false            �            1259    18156    fed_user_consent    TABLE     �  CREATE TABLE public.fed_user_consent (
    id character varying(36) NOT NULL,
    client_id character varying(255),
    user_id character varying(255) NOT NULL,
    realm_id character varying(36) NOT NULL,
    storage_provider_id character varying(36),
    created_date bigint,
    last_updated_date bigint,
    client_storage_provider character varying(36),
    external_client_id character varying(255)
);
 $   DROP TABLE public.fed_user_consent;
       public         heap    postgres    false            �            1259    18161    fed_user_consent_cl_scope    TABLE     �   CREATE TABLE public.fed_user_consent_cl_scope (
    user_consent_id character varying(36) NOT NULL,
    scope_id character varying(36) NOT NULL
);
 -   DROP TABLE public.fed_user_consent_cl_scope;
       public         heap    postgres    false            �            1259    18164    fed_user_credential    TABLE     �  CREATE TABLE public.fed_user_credential (
    id character varying(36) NOT NULL,
    salt bytea,
    type character varying(255),
    created_date bigint,
    user_id character varying(255) NOT NULL,
    realm_id character varying(36) NOT NULL,
    storage_provider_id character varying(36),
    user_label character varying(255),
    secret_data text,
    credential_data text,
    priority integer
);
 '   DROP TABLE public.fed_user_credential;
       public         heap    postgres    false            �            1259    18169    fed_user_group_membership    TABLE     �   CREATE TABLE public.fed_user_group_membership (
    group_id character varying(36) NOT NULL,
    user_id character varying(255) NOT NULL,
    realm_id character varying(36) NOT NULL,
    storage_provider_id character varying(36)
);
 -   DROP TABLE public.fed_user_group_membership;
       public         heap    postgres    false            �            1259    18172    fed_user_required_action    TABLE       CREATE TABLE public.fed_user_required_action (
    required_action character varying(255) DEFAULT ' '::character varying NOT NULL,
    user_id character varying(255) NOT NULL,
    realm_id character varying(36) NOT NULL,
    storage_provider_id character varying(36)
);
 ,   DROP TABLE public.fed_user_required_action;
       public         heap    postgres    false            �            1259    18178    fed_user_role_mapping    TABLE     �   CREATE TABLE public.fed_user_role_mapping (
    role_id character varying(36) NOT NULL,
    user_id character varying(255) NOT NULL,
    realm_id character varying(36) NOT NULL,
    storage_provider_id character varying(36)
);
 )   DROP TABLE public.fed_user_role_mapping;
       public         heap    postgres    false            �            1259    18181    federated_identity    TABLE       CREATE TABLE public.federated_identity (
    identity_provider character varying(255) NOT NULL,
    realm_id character varying(36),
    federated_user_id character varying(255),
    federated_username character varying(255),
    token text,
    user_id character varying(36) NOT NULL
);
 &   DROP TABLE public.federated_identity;
       public         heap    postgres    false            �            1259    18186    federated_user    TABLE     �   CREATE TABLE public.federated_user (
    id character varying(255) NOT NULL,
    storage_provider_id character varying(255),
    realm_id character varying(36) NOT NULL
);
 "   DROP TABLE public.federated_user;
       public         heap    postgres    false            �            1259    18191    group_attribute    TABLE       CREATE TABLE public.group_attribute (
    id character varying(36) DEFAULT 'sybase-needs-something-here'::character varying NOT NULL,
    name character varying(255) NOT NULL,
    value character varying(255),
    group_id character varying(36) NOT NULL
);
 #   DROP TABLE public.group_attribute;
       public         heap    postgres    false            �            1259    18197    group_role_mapping    TABLE     �   CREATE TABLE public.group_role_mapping (
    role_id character varying(36) NOT NULL,
    group_id character varying(36) NOT NULL
);
 &   DROP TABLE public.group_role_mapping;
       public         heap    postgres    false            �            1259    18200    identity_provider    TABLE     �  CREATE TABLE public.identity_provider (
    internal_id character varying(36) NOT NULL,
    enabled boolean DEFAULT false NOT NULL,
    provider_alias character varying(255),
    provider_id character varying(255),
    store_token boolean DEFAULT false NOT NULL,
    authenticate_by_default boolean DEFAULT false NOT NULL,
    realm_id character varying(36),
    add_token_role boolean DEFAULT true NOT NULL,
    trust_email boolean DEFAULT false NOT NULL,
    first_broker_login_flow_id character varying(36),
    post_broker_login_flow_id character varying(36),
    provider_display_name character varying(255),
    link_only boolean DEFAULT false NOT NULL,
    organization_id character varying(255),
    hide_on_login boolean DEFAULT false
);
 %   DROP TABLE public.identity_provider;
       public         heap    postgres    false            �            1259    18212    identity_provider_config    TABLE     �   CREATE TABLE public.identity_provider_config (
    identity_provider_id character varying(36) NOT NULL,
    value text,
    name character varying(255) NOT NULL
);
 ,   DROP TABLE public.identity_provider_config;
       public         heap    postgres    false            �            1259    18217    identity_provider_mapper    TABLE       CREATE TABLE public.identity_provider_mapper (
    id character varying(36) NOT NULL,
    name character varying(255) NOT NULL,
    idp_alias character varying(255) NOT NULL,
    idp_mapper_name character varying(255) NOT NULL,
    realm_id character varying(36) NOT NULL
);
 ,   DROP TABLE public.identity_provider_mapper;
       public         heap    postgres    false            �            1259    18222    idp_mapper_config    TABLE     �   CREATE TABLE public.idp_mapper_config (
    idp_mapper_id character varying(36) NOT NULL,
    value text,
    name character varying(255) NOT NULL
);
 %   DROP TABLE public.idp_mapper_config;
       public         heap    postgres    false            �            1259    18227    jgroups_ping    TABLE     �   CREATE TABLE public.jgroups_ping (
    address character varying(200) NOT NULL,
    name character varying(200),
    cluster_name character varying(200) NOT NULL,
    ip character varying(200) NOT NULL,
    coord boolean
);
     DROP TABLE public.jgroups_ping;
       public         heap    postgres    false            �            1259    18232    keycloak_group    TABLE     �   CREATE TABLE public.keycloak_group (
    id character varying(36) NOT NULL,
    name character varying(255),
    parent_group character varying(36) NOT NULL,
    realm_id character varying(36),
    type integer DEFAULT 0 NOT NULL
);
 "   DROP TABLE public.keycloak_group;
       public         heap    postgres    false                        1259    18236    keycloak_role    TABLE     b  CREATE TABLE public.keycloak_role (
    id character varying(36) NOT NULL,
    client_realm_constraint character varying(255),
    client_role boolean DEFAULT false NOT NULL,
    description character varying(255),
    name character varying(255),
    realm_id character varying(255),
    client character varying(36),
    realm character varying(36)
);
 !   DROP TABLE public.keycloak_role;
       public         heap    postgres    false                       1259    18242    migration_model    TABLE     �   CREATE TABLE public.migration_model (
    id character varying(36) NOT NULL,
    version character varying(36),
    update_time bigint DEFAULT 0 NOT NULL
);
 #   DROP TABLE public.migration_model;
       public         heap    postgres    false                       1259    18246    offline_client_session    TABLE     �  CREATE TABLE public.offline_client_session (
    user_session_id character varying(36) NOT NULL,
    client_id character varying(255) NOT NULL,
    offline_flag character varying(4) NOT NULL,
    "timestamp" integer,
    data text,
    client_storage_provider character varying(36) DEFAULT 'local'::character varying NOT NULL,
    external_client_id character varying(255) DEFAULT 'local'::character varying NOT NULL,
    version integer DEFAULT 0
);
 *   DROP TABLE public.offline_client_session;
       public         heap    postgres    false                       1259    18254    offline_user_session    TABLE     �  CREATE TABLE public.offline_user_session (
    user_session_id character varying(36) NOT NULL,
    user_id character varying(255) NOT NULL,
    realm_id character varying(36) NOT NULL,
    created_on integer NOT NULL,
    offline_flag character varying(4) NOT NULL,
    data text,
    last_session_refresh integer DEFAULT 0 NOT NULL,
    broker_session_id character varying(1024),
    version integer DEFAULT 0
);
 (   DROP TABLE public.offline_user_session;
       public         heap    postgres    false                       1259    18261    org    TABLE     f  CREATE TABLE public.org (
    id character varying(255) NOT NULL,
    enabled boolean NOT NULL,
    realm_id character varying(255) NOT NULL,
    group_id character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    description character varying(4000),
    alias character varying(255) NOT NULL,
    redirect_url character varying(2048)
);
    DROP TABLE public.org;
       public         heap    postgres    false                       1259    18266 
   org_domain    TABLE     �   CREATE TABLE public.org_domain (
    id character varying(36) NOT NULL,
    name character varying(255) NOT NULL,
    verified boolean NOT NULL,
    org_id character varying(255) NOT NULL
);
    DROP TABLE public.org_domain;
       public         heap    postgres    false                       1259    18271    policy_config    TABLE     �   CREATE TABLE public.policy_config (
    policy_id character varying(36) NOT NULL,
    name character varying(255) NOT NULL,
    value text
);
 !   DROP TABLE public.policy_config;
       public         heap    postgres    false                       1259    18276    protocol_mapper    TABLE     1  CREATE TABLE public.protocol_mapper (
    id character varying(36) NOT NULL,
    name character varying(255) NOT NULL,
    protocol character varying(255) NOT NULL,
    protocol_mapper_name character varying(255) NOT NULL,
    client_id character varying(36),
    client_scope_id character varying(36)
);
 #   DROP TABLE public.protocol_mapper;
       public         heap    postgres    false                       1259    18281    protocol_mapper_config    TABLE     �   CREATE TABLE public.protocol_mapper_config (
    protocol_mapper_id character varying(36) NOT NULL,
    value text,
    name character varying(255) NOT NULL
);
 *   DROP TABLE public.protocol_mapper_config;
       public         heap    postgres    false            	           1259    18286    realm    TABLE     �	  CREATE TABLE public.realm (
    id character varying(36) NOT NULL,
    access_code_lifespan integer,
    user_action_lifespan integer,
    access_token_lifespan integer,
    account_theme character varying(255),
    admin_theme character varying(255),
    email_theme character varying(255),
    enabled boolean DEFAULT false NOT NULL,
    events_enabled boolean DEFAULT false NOT NULL,
    events_expiration bigint,
    login_theme character varying(255),
    name character varying(255),
    not_before integer,
    password_policy character varying(2550),
    registration_allowed boolean DEFAULT false NOT NULL,
    remember_me boolean DEFAULT false NOT NULL,
    reset_password_allowed boolean DEFAULT false NOT NULL,
    social boolean DEFAULT false NOT NULL,
    ssl_required character varying(255),
    sso_idle_timeout integer,
    sso_max_lifespan integer,
    update_profile_on_soc_login boolean DEFAULT false NOT NULL,
    verify_email boolean DEFAULT false NOT NULL,
    master_admin_client character varying(36),
    login_lifespan integer,
    internationalization_enabled boolean DEFAULT false NOT NULL,
    default_locale character varying(255),
    reg_email_as_username boolean DEFAULT false NOT NULL,
    admin_events_enabled boolean DEFAULT false NOT NULL,
    admin_events_details_enabled boolean DEFAULT false NOT NULL,
    edit_username_allowed boolean DEFAULT false NOT NULL,
    otp_policy_counter integer DEFAULT 0,
    otp_policy_window integer DEFAULT 1,
    otp_policy_period integer DEFAULT 30,
    otp_policy_digits integer DEFAULT 6,
    otp_policy_alg character varying(36) DEFAULT 'HmacSHA1'::character varying,
    otp_policy_type character varying(36) DEFAULT 'totp'::character varying,
    browser_flow character varying(36),
    registration_flow character varying(36),
    direct_grant_flow character varying(36),
    reset_credentials_flow character varying(36),
    client_auth_flow character varying(36),
    offline_session_idle_timeout integer DEFAULT 0,
    revoke_refresh_token boolean DEFAULT false NOT NULL,
    access_token_life_implicit integer DEFAULT 0,
    login_with_email_allowed boolean DEFAULT true NOT NULL,
    duplicate_emails_allowed boolean DEFAULT false NOT NULL,
    docker_auth_flow character varying(36),
    refresh_token_max_reuse integer DEFAULT 0,
    allow_user_managed_access boolean DEFAULT false NOT NULL,
    sso_max_lifespan_remember_me integer DEFAULT 0 NOT NULL,
    sso_idle_timeout_remember_me integer DEFAULT 0 NOT NULL,
    default_role character varying(255)
);
    DROP TABLE public.realm;
       public         heap    postgres    false            
           1259    18319    realm_attribute    TABLE     �   CREATE TABLE public.realm_attribute (
    name character varying(255) NOT NULL,
    realm_id character varying(36) NOT NULL,
    value text
);
 #   DROP TABLE public.realm_attribute;
       public         heap    postgres    false                       1259    18324    realm_default_groups    TABLE     �   CREATE TABLE public.realm_default_groups (
    realm_id character varying(36) NOT NULL,
    group_id character varying(36) NOT NULL
);
 (   DROP TABLE public.realm_default_groups;
       public         heap    postgres    false                       1259    18327    realm_enabled_event_types    TABLE     �   CREATE TABLE public.realm_enabled_event_types (
    realm_id character varying(36) NOT NULL,
    value character varying(255) NOT NULL
);
 -   DROP TABLE public.realm_enabled_event_types;
       public         heap    postgres    false                       1259    18330    realm_events_listeners    TABLE     �   CREATE TABLE public.realm_events_listeners (
    realm_id character varying(36) NOT NULL,
    value character varying(255) NOT NULL
);
 *   DROP TABLE public.realm_events_listeners;
       public         heap    postgres    false                       1259    18333    realm_localizations    TABLE     �   CREATE TABLE public.realm_localizations (
    realm_id character varying(255) NOT NULL,
    locale character varying(255) NOT NULL,
    texts text NOT NULL
);
 '   DROP TABLE public.realm_localizations;
       public         heap    postgres    false                       1259    18338    realm_required_credential    TABLE       CREATE TABLE public.realm_required_credential (
    type character varying(255) NOT NULL,
    form_label character varying(255),
    input boolean DEFAULT false NOT NULL,
    secret boolean DEFAULT false NOT NULL,
    realm_id character varying(36) NOT NULL
);
 -   DROP TABLE public.realm_required_credential;
       public         heap    postgres    false                       1259    18345    realm_smtp_config    TABLE     �   CREATE TABLE public.realm_smtp_config (
    realm_id character varying(36) NOT NULL,
    value character varying(255),
    name character varying(255) NOT NULL
);
 %   DROP TABLE public.realm_smtp_config;
       public         heap    postgres    false                       1259    18350    realm_supported_locales    TABLE     �   CREATE TABLE public.realm_supported_locales (
    realm_id character varying(36) NOT NULL,
    value character varying(255) NOT NULL
);
 +   DROP TABLE public.realm_supported_locales;
       public         heap    postgres    false                       1259    18353    redirect_uris    TABLE        CREATE TABLE public.redirect_uris (
    client_id character varying(36) NOT NULL,
    value character varying(255) NOT NULL
);
 !   DROP TABLE public.redirect_uris;
       public         heap    postgres    false                       1259    18356    required_action_config    TABLE     �   CREATE TABLE public.required_action_config (
    required_action_id character varying(36) NOT NULL,
    value text,
    name character varying(255) NOT NULL
);
 *   DROP TABLE public.required_action_config;
       public         heap    postgres    false                       1259    18361    required_action_provider    TABLE     \  CREATE TABLE public.required_action_provider (
    id character varying(36) NOT NULL,
    alias character varying(255),
    name character varying(255),
    realm_id character varying(36),
    enabled boolean DEFAULT false NOT NULL,
    default_action boolean DEFAULT false NOT NULL,
    provider_id character varying(255),
    priority integer
);
 ,   DROP TABLE public.required_action_provider;
       public         heap    postgres    false                       1259    18368    resource_attribute    TABLE       CREATE TABLE public.resource_attribute (
    id character varying(36) DEFAULT 'sybase-needs-something-here'::character varying NOT NULL,
    name character varying(255) NOT NULL,
    value character varying(255),
    resource_id character varying(36) NOT NULL
);
 &   DROP TABLE public.resource_attribute;
       public         heap    postgres    false                       1259    18374    resource_policy    TABLE     �   CREATE TABLE public.resource_policy (
    resource_id character varying(36) NOT NULL,
    policy_id character varying(36) NOT NULL
);
 #   DROP TABLE public.resource_policy;
       public         heap    postgres    false                       1259    18377    resource_scope    TABLE     �   CREATE TABLE public.resource_scope (
    resource_id character varying(36) NOT NULL,
    scope_id character varying(36) NOT NULL
);
 "   DROP TABLE public.resource_scope;
       public         heap    postgres    false                       1259    18380    resource_server    TABLE     �   CREATE TABLE public.resource_server (
    id character varying(36) NOT NULL,
    allow_rs_remote_mgmt boolean DEFAULT false NOT NULL,
    policy_enforce_mode smallint NOT NULL,
    decision_strategy smallint DEFAULT 1 NOT NULL
);
 #   DROP TABLE public.resource_server;
       public         heap    postgres    false                       1259    18385    resource_server_perm_ticket    TABLE     �  CREATE TABLE public.resource_server_perm_ticket (
    id character varying(36) NOT NULL,
    owner character varying(255) NOT NULL,
    requester character varying(255) NOT NULL,
    created_timestamp bigint NOT NULL,
    granted_timestamp bigint,
    resource_id character varying(36) NOT NULL,
    scope_id character varying(36),
    resource_server_id character varying(36) NOT NULL,
    policy_id character varying(36)
);
 /   DROP TABLE public.resource_server_perm_ticket;
       public         heap    postgres    false                       1259    18390    resource_server_policy    TABLE     _  CREATE TABLE public.resource_server_policy (
    id character varying(36) NOT NULL,
    name character varying(255) NOT NULL,
    description character varying(255),
    type character varying(255) NOT NULL,
    decision_strategy smallint,
    logic smallint,
    resource_server_id character varying(36) NOT NULL,
    owner character varying(255)
);
 *   DROP TABLE public.resource_server_policy;
       public         heap    postgres    false                       1259    18395    resource_server_resource    TABLE     �  CREATE TABLE public.resource_server_resource (
    id character varying(36) NOT NULL,
    name character varying(255) NOT NULL,
    type character varying(255),
    icon_uri character varying(255),
    owner character varying(255) NOT NULL,
    resource_server_id character varying(36) NOT NULL,
    owner_managed_access boolean DEFAULT false NOT NULL,
    display_name character varying(255)
);
 ,   DROP TABLE public.resource_server_resource;
       public         heap    postgres    false                       1259    18401    resource_server_scope    TABLE       CREATE TABLE public.resource_server_scope (
    id character varying(36) NOT NULL,
    name character varying(255) NOT NULL,
    icon_uri character varying(255),
    resource_server_id character varying(36) NOT NULL,
    display_name character varying(255)
);
 )   DROP TABLE public.resource_server_scope;
       public         heap    postgres    false                       1259    18406    resource_uris    TABLE     �   CREATE TABLE public.resource_uris (
    resource_id character varying(36) NOT NULL,
    value character varying(255) NOT NULL
);
 !   DROP TABLE public.resource_uris;
       public         heap    postgres    false                       1259    18409    revoked_token    TABLE     j   CREATE TABLE public.revoked_token (
    id character varying(255) NOT NULL,
    expire bigint NOT NULL
);
 !   DROP TABLE public.revoked_token;
       public         heap    postgres    false                       1259    18412    role_attribute    TABLE     �   CREATE TABLE public.role_attribute (
    id character varying(36) NOT NULL,
    role_id character varying(36) NOT NULL,
    name character varying(255) NOT NULL,
    value character varying(255)
);
 "   DROP TABLE public.role_attribute;
       public         heap    postgres    false                        1259    18417    scope_mapping    TABLE     �   CREATE TABLE public.scope_mapping (
    client_id character varying(36) NOT NULL,
    role_id character varying(36) NOT NULL
);
 !   DROP TABLE public.scope_mapping;
       public         heap    postgres    false            !           1259    18420    scope_policy    TABLE     �   CREATE TABLE public.scope_policy (
    scope_id character varying(36) NOT NULL,
    policy_id character varying(36) NOT NULL
);
     DROP TABLE public.scope_policy;
       public         heap    postgres    false            "           1259    18423    server_config    TABLE     �   CREATE TABLE public.server_config (
    server_config_key character varying(255) NOT NULL,
    value text NOT NULL,
    version integer DEFAULT 0
);
 !   DROP TABLE public.server_config;
       public         heap    postgres    false            #           1259    18429    user_attribute    TABLE     U  CREATE TABLE public.user_attribute (
    name character varying(255) NOT NULL,
    value character varying(255),
    user_id character varying(36) NOT NULL,
    id character varying(36) DEFAULT 'sybase-needs-something-here'::character varying NOT NULL,
    long_value_hash bytea,
    long_value_hash_lower_case bytea,
    long_value text
);
 "   DROP TABLE public.user_attribute;
       public         heap    postgres    false            $           1259    18435    user_consent    TABLE     7  CREATE TABLE public.user_consent (
    id character varying(36) NOT NULL,
    client_id character varying(255),
    user_id character varying(36) NOT NULL,
    created_date bigint,
    last_updated_date bigint,
    client_storage_provider character varying(36),
    external_client_id character varying(255)
);
     DROP TABLE public.user_consent;
       public         heap    postgres    false            %           1259    18440    user_consent_client_scope    TABLE     �   CREATE TABLE public.user_consent_client_scope (
    user_consent_id character varying(36) NOT NULL,
    scope_id character varying(36) NOT NULL
);
 -   DROP TABLE public.user_consent_client_scope;
       public         heap    postgres    false            &           1259    18443    user_entity    TABLE     =  CREATE TABLE public.user_entity (
    id character varying(36) NOT NULL,
    email character varying(255),
    email_constraint character varying(255),
    email_verified boolean DEFAULT false NOT NULL,
    enabled boolean DEFAULT false NOT NULL,
    federation_link character varying(255),
    first_name character varying(255),
    last_name character varying(255),
    realm_id character varying(255),
    username character varying(255),
    created_timestamp bigint,
    service_account_client_link character varying(255),
    not_before integer DEFAULT 0 NOT NULL
);
    DROP TABLE public.user_entity;
       public         heap    postgres    false            '           1259    18451    user_federation_config    TABLE     �   CREATE TABLE public.user_federation_config (
    user_federation_provider_id character varying(36) NOT NULL,
    value character varying(255),
    name character varying(255) NOT NULL
);
 *   DROP TABLE public.user_federation_config;
       public         heap    postgres    false            (           1259    18456    user_federation_mapper    TABLE     $  CREATE TABLE public.user_federation_mapper (
    id character varying(36) NOT NULL,
    name character varying(255) NOT NULL,
    federation_provider_id character varying(36) NOT NULL,
    federation_mapper_type character varying(255) NOT NULL,
    realm_id character varying(36) NOT NULL
);
 *   DROP TABLE public.user_federation_mapper;
       public         heap    postgres    false            )           1259    18461    user_federation_mapper_config    TABLE     �   CREATE TABLE public.user_federation_mapper_config (
    user_federation_mapper_id character varying(36) NOT NULL,
    value character varying(255),
    name character varying(255) NOT NULL
);
 1   DROP TABLE public.user_federation_mapper_config;
       public         heap    postgres    false            *           1259    18466    user_federation_provider    TABLE     ;  CREATE TABLE public.user_federation_provider (
    id character varying(36) NOT NULL,
    changed_sync_period integer,
    display_name character varying(255),
    full_sync_period integer,
    last_sync integer,
    priority integer,
    provider_name character varying(255),
    realm_id character varying(36)
);
 ,   DROP TABLE public.user_federation_provider;
       public         heap    postgres    false            +           1259    18471    user_group_membership    TABLE     �   CREATE TABLE public.user_group_membership (
    group_id character varying(36) NOT NULL,
    user_id character varying(36) NOT NULL,
    membership_type character varying(255) NOT NULL
);
 )   DROP TABLE public.user_group_membership;
       public         heap    postgres    false            ,           1259    18474    user_required_action    TABLE     �   CREATE TABLE public.user_required_action (
    user_id character varying(36) NOT NULL,
    required_action character varying(255) DEFAULT ' '::character varying NOT NULL
);
 (   DROP TABLE public.user_required_action;
       public         heap    postgres    false            -           1259    18478    user_role_mapping    TABLE     �   CREATE TABLE public.user_role_mapping (
    role_id character varying(255) NOT NULL,
    user_id character varying(36) NOT NULL
);
 %   DROP TABLE public.user_role_mapping;
       public         heap    postgres    false            .           1259    18481    web_origins    TABLE     }   CREATE TABLE public.web_origins (
    client_id character varying(36) NOT NULL,
    value character varying(255) NOT NULL
);
    DROP TABLE public.web_origins;
       public         heap    postgres    false            ,          0    18031    admin_event_entity 
   TABLE DATA           �   COPY public.admin_event_entity (id, admin_event_time, realm_id, operation_type, auth_realm_id, auth_client_id, auth_user_id, ip_address, resource_path, representation, error, resource_type, details_json) FROM stdin;
    public          postgres    false    215   �m      -          0    18036    associated_policy 
   TABLE DATA           L   COPY public.associated_policy (policy_id, associated_policy_id) FROM stdin;
    public          postgres    false    216   �m      .          0    18039    authentication_execution 
   TABLE DATA           �   COPY public.authentication_execution (id, alias, authenticator, realm_id, flow_id, requirement, priority, authenticator_flow, auth_flow_id, auth_config) FROM stdin;
    public          postgres    false    217   �m      /          0    18043    authentication_flow 
   TABLE DATA           q   COPY public.authentication_flow (id, alias, description, realm_id, provider_id, top_level, built_in) FROM stdin;
    public          postgres    false    218   �}      0          0    18051    authenticator_config 
   TABLE DATA           C   COPY public.authenticator_config (id, alias, realm_id) FROM stdin;
    public          postgres    false    219   �      1          0    18054    authenticator_config_entry 
   TABLE DATA           S   COPY public.authenticator_config_entry (authenticator_id, value, name) FROM stdin;
    public          postgres    false    220   ��      2          0    18059    broker_link 
   TABLE DATA           �   COPY public.broker_link (identity_provider, storage_provider_id, realm_id, broker_user_id, broker_username, token, user_id) FROM stdin;
    public          postgres    false    221   Ć      3          0    18064    client 
   TABLE DATA           �  COPY public.client (id, enabled, full_scope_allowed, client_id, not_before, public_client, secret, base_url, bearer_only, management_url, surrogate_auth_required, realm_id, protocol, node_rereg_timeout, frontchannel_logout, consent_required, name, service_accounts_enabled, client_authenticator_type, root_url, description, registration_token, standard_flow_enabled, implicit_flow_enabled, direct_access_grants_enabled, always_display_in_console) FROM stdin;
    public          postgres    false    222   �      4          0    18082    client_attributes 
   TABLE DATA           C   COPY public.client_attributes (client_id, name, value) FROM stdin;
    public          postgres    false    223   ȉ      5          0    18087    client_auth_flow_bindings 
   TABLE DATA           U   COPY public.client_auth_flow_bindings (client_id, flow_id, binding_name) FROM stdin;
    public          postgres    false    224   Ջ      6          0    18090    client_initial_access 
   TABLE DATA           n   COPY public.client_initial_access (id, realm_id, "timestamp", expiration, count, remaining_count) FROM stdin;
    public          postgres    false    225   �      7          0    18093    client_node_registrations 
   TABLE DATA           K   COPY public.client_node_registrations (client_id, value, name) FROM stdin;
    public          postgres    false    226   �      8          0    18096    client_scope 
   TABLE DATA           Q   COPY public.client_scope (id, name, realm_id, description, protocol) FROM stdin;
    public          postgres    false    227   ,�      9          0    18101    client_scope_attributes 
   TABLE DATA           H   COPY public.client_scope_attributes (scope_id, value, name) FROM stdin;
    public          postgres    false    228   �      :          0    18106    client_scope_client 
   TABLE DATA           Q   COPY public.client_scope_client (client_id, scope_id, default_scope) FROM stdin;
    public          postgres    false    229   ��      ;          0    18112    client_scope_role_mapping 
   TABLE DATA           F   COPY public.client_scope_role_mapping (scope_id, role_id) FROM stdin;
    public          postgres    false    230   ߙ      <          0    18115 	   component 
   TABLE DATA           h   COPY public.component (id, name, parent_id, provider_id, provider_type, realm_id, sub_type) FROM stdin;
    public          postgres    false    231   b�      =          0    18120    component_config 
   TABLE DATA           I   COPY public.component_config (id, component_id, name, value) FROM stdin;
    public          postgres    false    232   Ş      >          0    18125    composite_role 
   TABLE DATA           ?   COPY public.composite_role (composite, child_role) FROM stdin;
    public          postgres    false    233   (�      ?          0    18128 
   credential 
   TABLE DATA           �   COPY public.credential (id, salt, type, user_id, created_date, user_label, secret_data, credential_data, priority, version) FROM stdin;
    public          postgres    false    234   �      @          0    18134    databasechangelog 
   TABLE DATA           �   COPY public.databasechangelog (id, author, filename, dateexecuted, orderexecuted, exectype, md5sum, description, comments, tag, liquibase, contexts, labels, deployment_id) FROM stdin;
    public          postgres    false    235   ��      A          0    18139    databasechangeloglock 
   TABLE DATA           R   COPY public.databasechangeloglock (id, locked, lockgranted, lockedby) FROM stdin;
    public          postgres    false    236   ��      B          0    18142    default_client_scope 
   TABLE DATA           Q   COPY public.default_client_scope (realm_id, scope_id, default_scope) FROM stdin;
    public          postgres    false    237   ��      C          0    18146    event_entity 
   TABLE DATA           �   COPY public.event_entity (id, client_id, details_json, error, ip_address, realm_id, session_id, event_time, type, user_id, details_json_long_value) FROM stdin;
    public          postgres    false    238   ��      D          0    18151    fed_user_attribute 
   TABLE DATA           �   COPY public.fed_user_attribute (id, name, user_id, realm_id, storage_provider_id, value, long_value_hash, long_value_hash_lower_case, long_value) FROM stdin;
    public          postgres    false    239   ��      E          0    18156    fed_user_consent 
   TABLE DATA           �   COPY public.fed_user_consent (id, client_id, user_id, realm_id, storage_provider_id, created_date, last_updated_date, client_storage_provider, external_client_id) FROM stdin;
    public          postgres    false    240   ��      F          0    18161    fed_user_consent_cl_scope 
   TABLE DATA           N   COPY public.fed_user_consent_cl_scope (user_consent_id, scope_id) FROM stdin;
    public          postgres    false    241   ��      G          0    18164    fed_user_credential 
   TABLE DATA           �   COPY public.fed_user_credential (id, salt, type, created_date, user_id, realm_id, storage_provider_id, user_label, secret_data, credential_data, priority) FROM stdin;
    public          postgres    false    242   �      H          0    18169    fed_user_group_membership 
   TABLE DATA           e   COPY public.fed_user_group_membership (group_id, user_id, realm_id, storage_provider_id) FROM stdin;
    public          postgres    false    243   )�      I          0    18172    fed_user_required_action 
   TABLE DATA           k   COPY public.fed_user_required_action (required_action, user_id, realm_id, storage_provider_id) FROM stdin;
    public          postgres    false    244   F�      J          0    18178    fed_user_role_mapping 
   TABLE DATA           `   COPY public.fed_user_role_mapping (role_id, user_id, realm_id, storage_provider_id) FROM stdin;
    public          postgres    false    245   c�      K          0    18181    federated_identity 
   TABLE DATA           �   COPY public.federated_identity (identity_provider, realm_id, federated_user_id, federated_username, token, user_id) FROM stdin;
    public          postgres    false    246   ��      L          0    18186    federated_user 
   TABLE DATA           K   COPY public.federated_user (id, storage_provider_id, realm_id) FROM stdin;
    public          postgres    false    247   ��      M          0    18191    group_attribute 
   TABLE DATA           D   COPY public.group_attribute (id, name, value, group_id) FROM stdin;
    public          postgres    false    248   ��      N          0    18197    group_role_mapping 
   TABLE DATA           ?   COPY public.group_role_mapping (role_id, group_id) FROM stdin;
    public          postgres    false    249   ��      O          0    18200    identity_provider 
   TABLE DATA           $  COPY public.identity_provider (internal_id, enabled, provider_alias, provider_id, store_token, authenticate_by_default, realm_id, add_token_role, trust_email, first_broker_login_flow_id, post_broker_login_flow_id, provider_display_name, link_only, organization_id, hide_on_login) FROM stdin;
    public          postgres    false    250   ��      P          0    18212    identity_provider_config 
   TABLE DATA           U   COPY public.identity_provider_config (identity_provider_id, value, name) FROM stdin;
    public          postgres    false    251          Q          0    18217    identity_provider_mapper 
   TABLE DATA           b   COPY public.identity_provider_mapper (id, name, idp_alias, idp_mapper_name, realm_id) FROM stdin;
    public          postgres    false    252   .       R          0    18222    idp_mapper_config 
   TABLE DATA           G   COPY public.idp_mapper_config (idp_mapper_id, value, name) FROM stdin;
    public          postgres    false    253   K       S          0    18227    jgroups_ping 
   TABLE DATA           N   COPY public.jgroups_ping (address, name, cluster_name, ip, coord) FROM stdin;
    public          postgres    false    254   h       T          0    18232    keycloak_group 
   TABLE DATA           P   COPY public.keycloak_group (id, name, parent_group, realm_id, type) FROM stdin;
    public          postgres    false    255   �       U          0    18236    keycloak_role 
   TABLE DATA           }   COPY public.keycloak_role (id, client_realm_constraint, client_role, description, name, realm_id, client, realm) FROM stdin;
    public          postgres    false    256   �       V          0    18242    migration_model 
   TABLE DATA           C   COPY public.migration_model (id, version, update_time) FROM stdin;
    public          postgres    false    257   _      W          0    18246    offline_client_session 
   TABLE DATA           �   COPY public.offline_client_session (user_session_id, client_id, offline_flag, "timestamp", data, client_storage_provider, external_client_id, version) FROM stdin;
    public          postgres    false    258   �      X          0    18254    offline_user_session 
   TABLE DATA           �   COPY public.offline_user_session (user_session_id, user_id, realm_id, created_on, offline_flag, data, last_session_refresh, broker_session_id, version) FROM stdin;
    public          postgres    false    259   O      Y          0    18261    org 
   TABLE DATA           f   COPY public.org (id, enabled, realm_id, group_id, name, description, alias, redirect_url) FROM stdin;
    public          postgres    false    260         Z          0    18266 
   org_domain 
   TABLE DATA           @   COPY public.org_domain (id, name, verified, org_id) FROM stdin;
    public          postgres    false    261   6      [          0    18271    policy_config 
   TABLE DATA           ?   COPY public.policy_config (policy_id, name, value) FROM stdin;
    public          postgres    false    262   S      \          0    18276    protocol_mapper 
   TABLE DATA           o   COPY public.protocol_mapper (id, name, protocol, protocol_mapper_name, client_id, client_scope_id) FROM stdin;
    public          postgres    false    263   p      ]          0    18281    protocol_mapper_config 
   TABLE DATA           Q   COPY public.protocol_mapper_config (protocol_mapper_id, value, name) FROM stdin;
    public          postgres    false    264   >      ^          0    18286    realm 
   TABLE DATA              COPY public.realm (id, access_code_lifespan, user_action_lifespan, access_token_lifespan, account_theme, admin_theme, email_theme, enabled, events_enabled, events_expiration, login_theme, name, not_before, password_policy, registration_allowed, remember_me, reset_password_allowed, social, ssl_required, sso_idle_timeout, sso_max_lifespan, update_profile_on_soc_login, verify_email, master_admin_client, login_lifespan, internationalization_enabled, default_locale, reg_email_as_username, admin_events_enabled, admin_events_details_enabled, edit_username_allowed, otp_policy_counter, otp_policy_window, otp_policy_period, otp_policy_digits, otp_policy_alg, otp_policy_type, browser_flow, registration_flow, direct_grant_flow, reset_credentials_flow, client_auth_flow, offline_session_idle_timeout, revoke_refresh_token, access_token_life_implicit, login_with_email_allowed, duplicate_emails_allowed, docker_auth_flow, refresh_token_max_reuse, allow_user_managed_access, sso_max_lifespan_remember_me, sso_idle_timeout_remember_me, default_role) FROM stdin;
    public          postgres    false    265   �*      _          0    18319    realm_attribute 
   TABLE DATA           @   COPY public.realm_attribute (name, realm_id, value) FROM stdin;
    public          postgres    false    266   �,      `          0    18324    realm_default_groups 
   TABLE DATA           B   COPY public.realm_default_groups (realm_id, group_id) FROM stdin;
    public          postgres    false    267   �1      a          0    18327    realm_enabled_event_types 
   TABLE DATA           D   COPY public.realm_enabled_event_types (realm_id, value) FROM stdin;
    public          postgres    false    268   2      b          0    18330    realm_events_listeners 
   TABLE DATA           A   COPY public.realm_events_listeners (realm_id, value) FROM stdin;
    public          postgres    false    269   2      c          0    18333    realm_localizations 
   TABLE DATA           F   COPY public.realm_localizations (realm_id, locale, texts) FROM stdin;
    public          postgres    false    270   �2      d          0    18338    realm_required_credential 
   TABLE DATA           ^   COPY public.realm_required_credential (type, form_label, input, secret, realm_id) FROM stdin;
    public          postgres    false    271   �2      e          0    18345    realm_smtp_config 
   TABLE DATA           B   COPY public.realm_smtp_config (realm_id, value, name) FROM stdin;
    public          postgres    false    272   3      f          0    18350    realm_supported_locales 
   TABLE DATA           B   COPY public.realm_supported_locales (realm_id, value) FROM stdin;
    public          postgres    false    273   23      g          0    18353    redirect_uris 
   TABLE DATA           9   COPY public.redirect_uris (client_id, value) FROM stdin;
    public          postgres    false    274   O3      h          0    18356    required_action_config 
   TABLE DATA           Q   COPY public.required_action_config (required_action_id, value, name) FROM stdin;
    public          postgres    false    275   g4      i          0    18361    required_action_provider 
   TABLE DATA           }   COPY public.required_action_provider (id, alias, name, realm_id, enabled, default_action, provider_id, priority) FROM stdin;
    public          postgres    false    276   �4      j          0    18368    resource_attribute 
   TABLE DATA           J   COPY public.resource_attribute (id, name, value, resource_id) FROM stdin;
    public          postgres    false    277   b8      k          0    18374    resource_policy 
   TABLE DATA           A   COPY public.resource_policy (resource_id, policy_id) FROM stdin;
    public          postgres    false    278   8      l          0    18377    resource_scope 
   TABLE DATA           ?   COPY public.resource_scope (resource_id, scope_id) FROM stdin;
    public          postgres    false    279   �8      m          0    18380    resource_server 
   TABLE DATA           k   COPY public.resource_server (id, allow_rs_remote_mgmt, policy_enforce_mode, decision_strategy) FROM stdin;
    public          postgres    false    280   �8      n          0    18385    resource_server_perm_ticket 
   TABLE DATA           �   COPY public.resource_server_perm_ticket (id, owner, requester, created_timestamp, granted_timestamp, resource_id, scope_id, resource_server_id, policy_id) FROM stdin;
    public          postgres    false    281   �8      o          0    18390    resource_server_policy 
   TABLE DATA           �   COPY public.resource_server_policy (id, name, description, type, decision_strategy, logic, resource_server_id, owner) FROM stdin;
    public          postgres    false    282   �8      p          0    18395    resource_server_resource 
   TABLE DATA           �   COPY public.resource_server_resource (id, name, type, icon_uri, owner, resource_server_id, owner_managed_access, display_name) FROM stdin;
    public          postgres    false    283   9      q          0    18401    resource_server_scope 
   TABLE DATA           e   COPY public.resource_server_scope (id, name, icon_uri, resource_server_id, display_name) FROM stdin;
    public          postgres    false    284   -9      r          0    18406    resource_uris 
   TABLE DATA           ;   COPY public.resource_uris (resource_id, value) FROM stdin;
    public          postgres    false    285   J9      s          0    18409    revoked_token 
   TABLE DATA           3   COPY public.revoked_token (id, expire) FROM stdin;
    public          postgres    false    286   g9      t          0    18412    role_attribute 
   TABLE DATA           B   COPY public.role_attribute (id, role_id, name, value) FROM stdin;
    public          postgres    false    287   �9      u          0    18417    scope_mapping 
   TABLE DATA           ;   COPY public.scope_mapping (client_id, role_id) FROM stdin;
    public          postgres    false    288   �9      v          0    18420    scope_policy 
   TABLE DATA           ;   COPY public.scope_policy (scope_id, policy_id) FROM stdin;
    public          postgres    false    289   Q:      w          0    18423    server_config 
   TABLE DATA           J   COPY public.server_config (server_config_key, value, version) FROM stdin;
    public          postgres    false    290   n:      x          0    18429    user_attribute 
   TABLE DATA           {   COPY public.user_attribute (name, value, user_id, id, long_value_hash, long_value_hash_lower_case, long_value) FROM stdin;
    public          postgres    false    291   �:      y          0    18435    user_consent 
   TABLE DATA           �   COPY public.user_consent (id, client_id, user_id, created_date, last_updated_date, client_storage_provider, external_client_id) FROM stdin;
    public          postgres    false    292   ;      z          0    18440    user_consent_client_scope 
   TABLE DATA           N   COPY public.user_consent_client_scope (user_consent_id, scope_id) FROM stdin;
    public          postgres    false    293   #;      {          0    18443    user_entity 
   TABLE DATA           �   COPY public.user_entity (id, email, email_constraint, email_verified, enabled, federation_link, first_name, last_name, realm_id, username, created_timestamp, service_account_client_link, not_before) FROM stdin;
    public          postgres    false    294   @;      |          0    18451    user_federation_config 
   TABLE DATA           Z   COPY public.user_federation_config (user_federation_provider_id, value, name) FROM stdin;
    public          postgres    false    295   �=      }          0    18456    user_federation_mapper 
   TABLE DATA           t   COPY public.user_federation_mapper (id, name, federation_provider_id, federation_mapper_type, realm_id) FROM stdin;
    public          postgres    false    296   �=      ~          0    18461    user_federation_mapper_config 
   TABLE DATA           _   COPY public.user_federation_mapper_config (user_federation_mapper_id, value, name) FROM stdin;
    public          postgres    false    297   >                0    18466    user_federation_provider 
   TABLE DATA           �   COPY public.user_federation_provider (id, changed_sync_period, display_name, full_sync_period, last_sync, priority, provider_name, realm_id) FROM stdin;
    public          postgres    false    298   (>      �          0    18471    user_group_membership 
   TABLE DATA           S   COPY public.user_group_membership (group_id, user_id, membership_type) FROM stdin;
    public          postgres    false    299   E>      �          0    18474    user_required_action 
   TABLE DATA           H   COPY public.user_required_action (user_id, required_action) FROM stdin;
    public          postgres    false    300   b>      �          0    18478    user_role_mapping 
   TABLE DATA           =   COPY public.user_role_mapping (role_id, user_id) FROM stdin;
    public          postgres    false    301   >      �          0    18481    web_origins 
   TABLE DATA           7   COPY public.web_origins (client_id, value) FROM stdin;
    public          postgres    false    302   @      �           2606    18485    org_domain ORG_DOMAIN_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.org_domain
    ADD CONSTRAINT "ORG_DOMAIN_pkey" PRIMARY KEY (id, name);
 F   ALTER TABLE ONLY public.org_domain DROP CONSTRAINT "ORG_DOMAIN_pkey";
       public            postgres    false    261    261            �           2606    18487    org ORG_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.org
    ADD CONSTRAINT "ORG_pkey" PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.org DROP CONSTRAINT "ORG_pkey";
       public            postgres    false    260            )           2606    18489     server_config SERVER_CONFIG_pkey 
   CONSTRAINT     o   ALTER TABLE ONLY public.server_config
    ADD CONSTRAINT "SERVER_CONFIG_pkey" PRIMARY KEY (server_config_key);
 L   ALTER TABLE ONLY public.server_config DROP CONSTRAINT "SERVER_CONFIG_pkey";
       public            postgres    false    290            �           2606    18491 ,   keycloak_role UK_J3RWUVD56ONTGSUHOGM184WW2-2 
   CONSTRAINT     �   ALTER TABLE ONLY public.keycloak_role
    ADD CONSTRAINT "UK_J3RWUVD56ONTGSUHOGM184WW2-2" UNIQUE (name, client_realm_constraint);
 X   ALTER TABLE ONLY public.keycloak_role DROP CONSTRAINT "UK_J3RWUVD56ONTGSUHOGM184WW2-2";
       public            postgres    false    256    256            J           2606    18493 )   client_auth_flow_bindings c_cli_flow_bind 
   CONSTRAINT     |   ALTER TABLE ONLY public.client_auth_flow_bindings
    ADD CONSTRAINT c_cli_flow_bind PRIMARY KEY (client_id, binding_name);
 S   ALTER TABLE ONLY public.client_auth_flow_bindings DROP CONSTRAINT c_cli_flow_bind;
       public            postgres    false    224    224            Y           2606    18495 $   client_scope_client c_cli_scope_bind 
   CONSTRAINT     s   ALTER TABLE ONLY public.client_scope_client
    ADD CONSTRAINT c_cli_scope_bind PRIMARY KEY (client_id, scope_id);
 N   ALTER TABLE ONLY public.client_scope_client DROP CONSTRAINT c_cli_scope_bind;
       public            postgres    false    229    229            L           2606    18497 .   client_initial_access cnstr_client_init_acc_pk 
   CONSTRAINT     l   ALTER TABLE ONLY public.client_initial_access
    ADD CONSTRAINT cnstr_client_init_acc_pk PRIMARY KEY (id);
 X   ALTER TABLE ONLY public.client_initial_access DROP CONSTRAINT cnstr_client_init_acc_pk;
       public            postgres    false    225            �           2606    18499 ,   realm_default_groups con_group_id_def_groups 
   CONSTRAINT     k   ALTER TABLE ONLY public.realm_default_groups
    ADD CONSTRAINT con_group_id_def_groups UNIQUE (group_id);
 V   ALTER TABLE ONLY public.realm_default_groups DROP CONSTRAINT con_group_id_def_groups;
       public            postgres    false    267            @           2606    18501 !   broker_link constr_broker_link_pk 
   CONSTRAINT     w   ALTER TABLE ONLY public.broker_link
    ADD CONSTRAINT constr_broker_link_pk PRIMARY KEY (identity_provider, user_id);
 K   ALTER TABLE ONLY public.broker_link DROP CONSTRAINT constr_broker_link_pk;
       public            postgres    false    221    221            e           2606    18503 +   component_config constr_component_config_pk 
   CONSTRAINT     i   ALTER TABLE ONLY public.component_config
    ADD CONSTRAINT constr_component_config_pk PRIMARY KEY (id);
 U   ALTER TABLE ONLY public.component_config DROP CONSTRAINT constr_component_config_pk;
       public            postgres    false    232            a           2606    18505    component constr_component_pk 
   CONSTRAINT     [   ALTER TABLE ONLY public.component
    ADD CONSTRAINT constr_component_pk PRIMARY KEY (id);
 G   ALTER TABLE ONLY public.component DROP CONSTRAINT constr_component_pk;
       public            postgres    false    231            �           2606    18507 3   fed_user_required_action constr_fed_required_action 
   CONSTRAINT     �   ALTER TABLE ONLY public.fed_user_required_action
    ADD CONSTRAINT constr_fed_required_action PRIMARY KEY (required_action, user_id);
 ]   ALTER TABLE ONLY public.fed_user_required_action DROP CONSTRAINT constr_fed_required_action;
       public            postgres    false    244    244            x           2606    18509 *   fed_user_attribute constr_fed_user_attr_pk 
   CONSTRAINT     h   ALTER TABLE ONLY public.fed_user_attribute
    ADD CONSTRAINT constr_fed_user_attr_pk PRIMARY KEY (id);
 T   ALTER TABLE ONLY public.fed_user_attribute DROP CONSTRAINT constr_fed_user_attr_pk;
       public            postgres    false    239            }           2606    18511 +   fed_user_consent constr_fed_user_consent_pk 
   CONSTRAINT     i   ALTER TABLE ONLY public.fed_user_consent
    ADD CONSTRAINT constr_fed_user_consent_pk PRIMARY KEY (id);
 U   ALTER TABLE ONLY public.fed_user_consent DROP CONSTRAINT constr_fed_user_consent_pk;
       public            postgres    false    240            �           2606    18513 +   fed_user_credential constr_fed_user_cred_pk 
   CONSTRAINT     i   ALTER TABLE ONLY public.fed_user_credential
    ADD CONSTRAINT constr_fed_user_cred_pk PRIMARY KEY (id);
 U   ALTER TABLE ONLY public.fed_user_credential DROP CONSTRAINT constr_fed_user_cred_pk;
       public            postgres    false    242            �           2606    18515 /   fed_user_group_membership constr_fed_user_group 
   CONSTRAINT     |   ALTER TABLE ONLY public.fed_user_group_membership
    ADD CONSTRAINT constr_fed_user_group PRIMARY KEY (group_id, user_id);
 Y   ALTER TABLE ONLY public.fed_user_group_membership DROP CONSTRAINT constr_fed_user_group;
       public            postgres    false    243    243            �           2606    18517 *   fed_user_role_mapping constr_fed_user_role 
   CONSTRAINT     v   ALTER TABLE ONLY public.fed_user_role_mapping
    ADD CONSTRAINT constr_fed_user_role PRIMARY KEY (role_id, user_id);
 T   ALTER TABLE ONLY public.fed_user_role_mapping DROP CONSTRAINT constr_fed_user_role;
       public            postgres    false    245    245            �           2606    18519 $   federated_user constr_federated_user 
   CONSTRAINT     b   ALTER TABLE ONLY public.federated_user
    ADD CONSTRAINT constr_federated_user PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.federated_user DROP CONSTRAINT constr_federated_user;
       public            postgres    false    247            �           2606    18521 0   realm_default_groups constr_realm_default_groups 
   CONSTRAINT     ~   ALTER TABLE ONLY public.realm_default_groups
    ADD CONSTRAINT constr_realm_default_groups PRIMARY KEY (realm_id, group_id);
 Z   ALTER TABLE ONLY public.realm_default_groups DROP CONSTRAINT constr_realm_default_groups;
       public            postgres    false    267    267            �           2606    18523 8   realm_enabled_event_types constr_realm_enabl_event_types 
   CONSTRAINT     �   ALTER TABLE ONLY public.realm_enabled_event_types
    ADD CONSTRAINT constr_realm_enabl_event_types PRIMARY KEY (realm_id, value);
 b   ALTER TABLE ONLY public.realm_enabled_event_types DROP CONSTRAINT constr_realm_enabl_event_types;
       public            postgres    false    268    268            �           2606    18525 4   realm_events_listeners constr_realm_events_listeners 
   CONSTRAINT        ALTER TABLE ONLY public.realm_events_listeners
    ADD CONSTRAINT constr_realm_events_listeners PRIMARY KEY (realm_id, value);
 ^   ALTER TABLE ONLY public.realm_events_listeners DROP CONSTRAINT constr_realm_events_listeners;
       public            postgres    false    269    269            �           2606    18527 6   realm_supported_locales constr_realm_supported_locales 
   CONSTRAINT     �   ALTER TABLE ONLY public.realm_supported_locales
    ADD CONSTRAINT constr_realm_supported_locales PRIMARY KEY (realm_id, value);
 `   ALTER TABLE ONLY public.realm_supported_locales DROP CONSTRAINT constr_realm_supported_locales;
       public            postgres    false    273    273            �           2606    18529    identity_provider constraint_2b 
   CONSTRAINT     f   ALTER TABLE ONLY public.identity_provider
    ADD CONSTRAINT constraint_2b PRIMARY KEY (internal_id);
 I   ALTER TABLE ONLY public.identity_provider DROP CONSTRAINT constraint_2b;
       public            postgres    false    250            G           2606    18531    client_attributes constraint_3c 
   CONSTRAINT     j   ALTER TABLE ONLY public.client_attributes
    ADD CONSTRAINT constraint_3c PRIMARY KEY (client_id, name);
 I   ALTER TABLE ONLY public.client_attributes DROP CONSTRAINT constraint_3c;
       public            postgres    false    223    223            u           2606    18533    event_entity constraint_4 
   CONSTRAINT     W   ALTER TABLE ONLY public.event_entity
    ADD CONSTRAINT constraint_4 PRIMARY KEY (id);
 C   ALTER TABLE ONLY public.event_entity DROP CONSTRAINT constraint_4;
       public            postgres    false    238            �           2606    18535     federated_identity constraint_40 
   CONSTRAINT     v   ALTER TABLE ONLY public.federated_identity
    ADD CONSTRAINT constraint_40 PRIMARY KEY (identity_provider, user_id);
 J   ALTER TABLE ONLY public.federated_identity DROP CONSTRAINT constraint_40;
       public            postgres    false    246    246            �           2606    18537    realm constraint_4a 
   CONSTRAINT     Q   ALTER TABLE ONLY public.realm
    ADD CONSTRAINT constraint_4a PRIMARY KEY (id);
 =   ALTER TABLE ONLY public.realm DROP CONSTRAINT constraint_4a;
       public            postgres    false    265            L           2606    18539 &   user_federation_provider constraint_5c 
   CONSTRAINT     d   ALTER TABLE ONLY public.user_federation_provider
    ADD CONSTRAINT constraint_5c PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.user_federation_provider DROP CONSTRAINT constraint_5c;
       public            postgres    false    298            B           2606    18541    client constraint_7 
   CONSTRAINT     Q   ALTER TABLE ONLY public.client
    ADD CONSTRAINT constraint_7 PRIMARY KEY (id);
 =   ALTER TABLE ONLY public.client DROP CONSTRAINT constraint_7;
       public            postgres    false    222            #           2606    18543    scope_mapping constraint_81 
   CONSTRAINT     i   ALTER TABLE ONLY public.scope_mapping
    ADD CONSTRAINT constraint_81 PRIMARY KEY (client_id, role_id);
 E   ALTER TABLE ONLY public.scope_mapping DROP CONSTRAINT constraint_81;
       public            postgres    false    288    288            O           2606    18545 '   client_node_registrations constraint_84 
   CONSTRAINT     r   ALTER TABLE ONLY public.client_node_registrations
    ADD CONSTRAINT constraint_84 PRIMARY KEY (client_id, name);
 Q   ALTER TABLE ONLY public.client_node_registrations DROP CONSTRAINT constraint_84;
       public            postgres    false    226    226            �           2606    18547    realm_attribute constraint_9 
   CONSTRAINT     f   ALTER TABLE ONLY public.realm_attribute
    ADD CONSTRAINT constraint_9 PRIMARY KEY (name, realm_id);
 F   ALTER TABLE ONLY public.realm_attribute DROP CONSTRAINT constraint_9;
       public            postgres    false    266    266            �           2606    18549 '   realm_required_credential constraint_92 
   CONSTRAINT     q   ALTER TABLE ONLY public.realm_required_credential
    ADD CONSTRAINT constraint_92 PRIMARY KEY (realm_id, type);
 Q   ALTER TABLE ONLY public.realm_required_credential DROP CONSTRAINT constraint_92;
       public            postgres    false    271    271            �           2606    18551    keycloak_role constraint_a 
   CONSTRAINT     X   ALTER TABLE ONLY public.keycloak_role
    ADD CONSTRAINT constraint_a PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.keycloak_role DROP CONSTRAINT constraint_a;
       public            postgres    false    256            .           2606    18553 0   admin_event_entity constraint_admin_event_entity 
   CONSTRAINT     n   ALTER TABLE ONLY public.admin_event_entity
    ADD CONSTRAINT constraint_admin_event_entity PRIMARY KEY (id);
 Z   ALTER TABLE ONLY public.admin_event_entity DROP CONSTRAINT constraint_admin_event_entity;
       public            postgres    false    215            >           2606    18555 1   authenticator_config_entry constraint_auth_cfg_pk 
   CONSTRAINT     �   ALTER TABLE ONLY public.authenticator_config_entry
    ADD CONSTRAINT constraint_auth_cfg_pk PRIMARY KEY (authenticator_id, name);
 [   ALTER TABLE ONLY public.authenticator_config_entry DROP CONSTRAINT constraint_auth_cfg_pk;
       public            postgres    false    220    220            4           2606    18557 0   authentication_execution constraint_auth_exec_pk 
   CONSTRAINT     n   ALTER TABLE ONLY public.authentication_execution
    ADD CONSTRAINT constraint_auth_exec_pk PRIMARY KEY (id);
 Z   ALTER TABLE ONLY public.authentication_execution DROP CONSTRAINT constraint_auth_exec_pk;
       public            postgres    false    217            8           2606    18559 +   authentication_flow constraint_auth_flow_pk 
   CONSTRAINT     i   ALTER TABLE ONLY public.authentication_flow
    ADD CONSTRAINT constraint_auth_flow_pk PRIMARY KEY (id);
 U   ALTER TABLE ONLY public.authentication_flow DROP CONSTRAINT constraint_auth_flow_pk;
       public            postgres    false    218            ;           2606    18561 '   authenticator_config constraint_auth_pk 
   CONSTRAINT     e   ALTER TABLE ONLY public.authenticator_config
    ADD CONSTRAINT constraint_auth_pk PRIMARY KEY (id);
 Q   ALTER TABLE ONLY public.authenticator_config DROP CONSTRAINT constraint_auth_pk;
       public            postgres    false    219            U           2606    18563    user_role_mapping constraint_c 
   CONSTRAINT     j   ALTER TABLE ONLY public.user_role_mapping
    ADD CONSTRAINT constraint_c PRIMARY KEY (role_id, user_id);
 H   ALTER TABLE ONLY public.user_role_mapping DROP CONSTRAINT constraint_c;
       public            postgres    false    301    301            h           2606    18565 (   composite_role constraint_composite_role 
   CONSTRAINT     y   ALTER TABLE ONLY public.composite_role
    ADD CONSTRAINT constraint_composite_role PRIMARY KEY (composite, child_role);
 R   ALTER TABLE ONLY public.composite_role DROP CONSTRAINT constraint_composite_role;
       public            postgres    false    233    233            �           2606    18567 %   identity_provider_config constraint_d 
   CONSTRAINT     {   ALTER TABLE ONLY public.identity_provider_config
    ADD CONSTRAINT constraint_d PRIMARY KEY (identity_provider_id, name);
 O   ALTER TABLE ONLY public.identity_provider_config DROP CONSTRAINT constraint_d;
       public            postgres    false    251    251            �           2606    18569    policy_config constraint_dpc 
   CONSTRAINT     g   ALTER TABLE ONLY public.policy_config
    ADD CONSTRAINT constraint_dpc PRIMARY KEY (policy_id, name);
 F   ALTER TABLE ONLY public.policy_config DROP CONSTRAINT constraint_dpc;
       public            postgres    false    262    262            �           2606    18571    realm_smtp_config constraint_e 
   CONSTRAINT     h   ALTER TABLE ONLY public.realm_smtp_config
    ADD CONSTRAINT constraint_e PRIMARY KEY (realm_id, name);
 H   ALTER TABLE ONLY public.realm_smtp_config DROP CONSTRAINT constraint_e;
       public            postgres    false    272    272            l           2606    18573    credential constraint_f 
   CONSTRAINT     U   ALTER TABLE ONLY public.credential
    ADD CONSTRAINT constraint_f PRIMARY KEY (id);
 A   ALTER TABLE ONLY public.credential DROP CONSTRAINT constraint_f;
       public            postgres    false    234            D           2606    18575 $   user_federation_config constraint_f9 
   CONSTRAINT     �   ALTER TABLE ONLY public.user_federation_config
    ADD CONSTRAINT constraint_f9 PRIMARY KEY (user_federation_provider_id, name);
 N   ALTER TABLE ONLY public.user_federation_config DROP CONSTRAINT constraint_f9;
       public            postgres    false    295    295                       2606    18577 ,   resource_server_perm_ticket constraint_fapmt 
   CONSTRAINT     j   ALTER TABLE ONLY public.resource_server_perm_ticket
    ADD CONSTRAINT constraint_fapmt PRIMARY KEY (id);
 V   ALTER TABLE ONLY public.resource_server_perm_ticket DROP CONSTRAINT constraint_fapmt;
       public            postgres    false    281                       2606    18579 )   resource_server_resource constraint_farsr 
   CONSTRAINT     g   ALTER TABLE ONLY public.resource_server_resource
    ADD CONSTRAINT constraint_farsr PRIMARY KEY (id);
 S   ALTER TABLE ONLY public.resource_server_resource DROP CONSTRAINT constraint_farsr;
       public            postgres    false    283                       2606    18581 (   resource_server_policy constraint_farsrp 
   CONSTRAINT     f   ALTER TABLE ONLY public.resource_server_policy
    ADD CONSTRAINT constraint_farsrp PRIMARY KEY (id);
 R   ALTER TABLE ONLY public.resource_server_policy DROP CONSTRAINT constraint_farsrp;
       public            postgres    false    282            1           2606    18583 %   associated_policy constraint_farsrpap 
   CONSTRAINT     �   ALTER TABLE ONLY public.associated_policy
    ADD CONSTRAINT constraint_farsrpap PRIMARY KEY (policy_id, associated_policy_id);
 O   ALTER TABLE ONLY public.associated_policy DROP CONSTRAINT constraint_farsrpap;
       public            postgres    false    216    216            �           2606    18585 "   resource_policy constraint_farsrpp 
   CONSTRAINT     t   ALTER TABLE ONLY public.resource_policy
    ADD CONSTRAINT constraint_farsrpp PRIMARY KEY (resource_id, policy_id);
 L   ALTER TABLE ONLY public.resource_policy DROP CONSTRAINT constraint_farsrpp;
       public            postgres    false    278    278                       2606    18587 '   resource_server_scope constraint_farsrs 
   CONSTRAINT     e   ALTER TABLE ONLY public.resource_server_scope
    ADD CONSTRAINT constraint_farsrs PRIMARY KEY (id);
 Q   ALTER TABLE ONLY public.resource_server_scope DROP CONSTRAINT constraint_farsrs;
       public            postgres    false    284                       2606    18589 !   resource_scope constraint_farsrsp 
   CONSTRAINT     r   ALTER TABLE ONLY public.resource_scope
    ADD CONSTRAINT constraint_farsrsp PRIMARY KEY (resource_id, scope_id);
 K   ALTER TABLE ONLY public.resource_scope DROP CONSTRAINT constraint_farsrsp;
       public            postgres    false    279    279            &           2606    18591     scope_policy constraint_farsrsps 
   CONSTRAINT     o   ALTER TABLE ONLY public.scope_policy
    ADD CONSTRAINT constraint_farsrsps PRIMARY KEY (scope_id, policy_id);
 J   ALTER TABLE ONLY public.scope_policy DROP CONSTRAINT constraint_farsrsps;
       public            postgres    false    289    289            <           2606    18593    user_entity constraint_fb 
   CONSTRAINT     W   ALTER TABLE ONLY public.user_entity
    ADD CONSTRAINT constraint_fb PRIMARY KEY (id);
 C   ALTER TABLE ONLY public.user_entity DROP CONSTRAINT constraint_fb;
       public            postgres    false    294            J           2606    18595 9   user_federation_mapper_config constraint_fedmapper_cfg_pm 
   CONSTRAINT     �   ALTER TABLE ONLY public.user_federation_mapper_config
    ADD CONSTRAINT constraint_fedmapper_cfg_pm PRIMARY KEY (user_federation_mapper_id, name);
 c   ALTER TABLE ONLY public.user_federation_mapper_config DROP CONSTRAINT constraint_fedmapper_cfg_pm;
       public            postgres    false    297    297            F           2606    18597 -   user_federation_mapper constraint_fedmapperpm 
   CONSTRAINT     k   ALTER TABLE ONLY public.user_federation_mapper
    ADD CONSTRAINT constraint_fedmapperpm PRIMARY KEY (id);
 W   ALTER TABLE ONLY public.user_federation_mapper DROP CONSTRAINT constraint_fedmapperpm;
       public            postgres    false    296            �           2606    18599 6   fed_user_consent_cl_scope constraint_fgrntcsnt_clsc_pm 
   CONSTRAINT     �   ALTER TABLE ONLY public.fed_user_consent_cl_scope
    ADD CONSTRAINT constraint_fgrntcsnt_clsc_pm PRIMARY KEY (user_consent_id, scope_id);
 `   ALTER TABLE ONLY public.fed_user_consent_cl_scope DROP CONSTRAINT constraint_fgrntcsnt_clsc_pm;
       public            postgres    false    241    241            8           2606    18601 5   user_consent_client_scope constraint_grntcsnt_clsc_pm 
   CONSTRAINT     �   ALTER TABLE ONLY public.user_consent_client_scope
    ADD CONSTRAINT constraint_grntcsnt_clsc_pm PRIMARY KEY (user_consent_id, scope_id);
 _   ALTER TABLE ONLY public.user_consent_client_scope DROP CONSTRAINT constraint_grntcsnt_clsc_pm;
       public            postgres    false    293    293            1           2606    18603 #   user_consent constraint_grntcsnt_pm 
   CONSTRAINT     a   ALTER TABLE ONLY public.user_consent
    ADD CONSTRAINT constraint_grntcsnt_pm PRIMARY KEY (id);
 M   ALTER TABLE ONLY public.user_consent DROP CONSTRAINT constraint_grntcsnt_pm;
       public            postgres    false    292            �           2606    18605    keycloak_group constraint_group 
   CONSTRAINT     ]   ALTER TABLE ONLY public.keycloak_group
    ADD CONSTRAINT constraint_group PRIMARY KEY (id);
 I   ALTER TABLE ONLY public.keycloak_group DROP CONSTRAINT constraint_group;
       public            postgres    false    255            �           2606    18607 -   group_attribute constraint_group_attribute_pk 
   CONSTRAINT     k   ALTER TABLE ONLY public.group_attribute
    ADD CONSTRAINT constraint_group_attribute_pk PRIMARY KEY (id);
 W   ALTER TABLE ONLY public.group_attribute DROP CONSTRAINT constraint_group_attribute_pk;
       public            postgres    false    248            �           2606    18609 (   group_role_mapping constraint_group_role 
   CONSTRAINT     u   ALTER TABLE ONLY public.group_role_mapping
    ADD CONSTRAINT constraint_group_role PRIMARY KEY (role_id, group_id);
 R   ALTER TABLE ONLY public.group_role_mapping DROP CONSTRAINT constraint_group_role;
       public            postgres    false    249    249            �           2606    18611 (   identity_provider_mapper constraint_idpm 
   CONSTRAINT     f   ALTER TABLE ONLY public.identity_provider_mapper
    ADD CONSTRAINT constraint_idpm PRIMARY KEY (id);
 R   ALTER TABLE ONLY public.identity_provider_mapper DROP CONSTRAINT constraint_idpm;
       public            postgres    false    252            �           2606    18613 '   idp_mapper_config constraint_idpmconfig 
   CONSTRAINT     v   ALTER TABLE ONLY public.idp_mapper_config
    ADD CONSTRAINT constraint_idpmconfig PRIMARY KEY (idp_mapper_id, name);
 Q   ALTER TABLE ONLY public.idp_mapper_config DROP CONSTRAINT constraint_idpmconfig;
       public            postgres    false    253    253            �           2606    18615 $   jgroups_ping constraint_jgroups_ping 
   CONSTRAINT     g   ALTER TABLE ONLY public.jgroups_ping
    ADD CONSTRAINT constraint_jgroups_ping PRIMARY KEY (address);
 N   ALTER TABLE ONLY public.jgroups_ping DROP CONSTRAINT constraint_jgroups_ping;
       public            postgres    false    254            �           2606    18617 !   migration_model constraint_migmod 
   CONSTRAINT     _   ALTER TABLE ONLY public.migration_model
    ADD CONSTRAINT constraint_migmod PRIMARY KEY (id);
 K   ALTER TABLE ONLY public.migration_model DROP CONSTRAINT constraint_migmod;
       public            postgres    false    257            �           2606    18619 1   offline_client_session constraint_offl_cl_ses_pk3 
   CONSTRAINT     �   ALTER TABLE ONLY public.offline_client_session
    ADD CONSTRAINT constraint_offl_cl_ses_pk3 PRIMARY KEY (user_session_id, client_id, client_storage_provider, external_client_id, offline_flag);
 [   ALTER TABLE ONLY public.offline_client_session DROP CONSTRAINT constraint_offl_cl_ses_pk3;
       public            postgres    false    258    258    258    258    258            �           2606    18621 /   offline_user_session constraint_offl_us_ses_pk2 
   CONSTRAINT     �   ALTER TABLE ONLY public.offline_user_session
    ADD CONSTRAINT constraint_offl_us_ses_pk2 PRIMARY KEY (user_session_id, offline_flag);
 Y   ALTER TABLE ONLY public.offline_user_session DROP CONSTRAINT constraint_offl_us_ses_pk2;
       public            postgres    false    259    259            �           2606    18623    protocol_mapper constraint_pcm 
   CONSTRAINT     \   ALTER TABLE ONLY public.protocol_mapper
    ADD CONSTRAINT constraint_pcm PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.protocol_mapper DROP CONSTRAINT constraint_pcm;
       public            postgres    false    263            �           2606    18625 *   protocol_mapper_config constraint_pmconfig 
   CONSTRAINT     ~   ALTER TABLE ONLY public.protocol_mapper_config
    ADD CONSTRAINT constraint_pmconfig PRIMARY KEY (protocol_mapper_id, name);
 T   ALTER TABLE ONLY public.protocol_mapper_config DROP CONSTRAINT constraint_pmconfig;
       public            postgres    false    264    264            �           2606    18627 &   redirect_uris constraint_redirect_uris 
   CONSTRAINT     r   ALTER TABLE ONLY public.redirect_uris
    ADD CONSTRAINT constraint_redirect_uris PRIMARY KEY (client_id, value);
 P   ALTER TABLE ONLY public.redirect_uris DROP CONSTRAINT constraint_redirect_uris;
       public            postgres    false    274    274            �           2606    18629 0   required_action_config constraint_req_act_cfg_pk 
   CONSTRAINT     �   ALTER TABLE ONLY public.required_action_config
    ADD CONSTRAINT constraint_req_act_cfg_pk PRIMARY KEY (required_action_id, name);
 Z   ALTER TABLE ONLY public.required_action_config DROP CONSTRAINT constraint_req_act_cfg_pk;
       public            postgres    false    275    275            �           2606    18631 2   required_action_provider constraint_req_act_prv_pk 
   CONSTRAINT     p   ALTER TABLE ONLY public.required_action_provider
    ADD CONSTRAINT constraint_req_act_prv_pk PRIMARY KEY (id);
 \   ALTER TABLE ONLY public.required_action_provider DROP CONSTRAINT constraint_req_act_prv_pk;
       public            postgres    false    276            R           2606    18633 /   user_required_action constraint_required_action 
   CONSTRAINT     �   ALTER TABLE ONLY public.user_required_action
    ADD CONSTRAINT constraint_required_action PRIMARY KEY (required_action, user_id);
 Y   ALTER TABLE ONLY public.user_required_action DROP CONSTRAINT constraint_required_action;
       public            postgres    false    300    300                       2606    18635 '   resource_uris constraint_resour_uris_pk 
   CONSTRAINT     u   ALTER TABLE ONLY public.resource_uris
    ADD CONSTRAINT constraint_resour_uris_pk PRIMARY KEY (resource_id, value);
 Q   ALTER TABLE ONLY public.resource_uris DROP CONSTRAINT constraint_resour_uris_pk;
       public            postgres    false    285    285                        2606    18637 +   role_attribute constraint_role_attribute_pk 
   CONSTRAINT     i   ALTER TABLE ONLY public.role_attribute
    ADD CONSTRAINT constraint_role_attribute_pk PRIMARY KEY (id);
 U   ALTER TABLE ONLY public.role_attribute DROP CONSTRAINT constraint_role_attribute_pk;
       public            postgres    false    287                       2606    18639    revoked_token constraint_rt 
   CONSTRAINT     Y   ALTER TABLE ONLY public.revoked_token
    ADD CONSTRAINT constraint_rt PRIMARY KEY (id);
 E   ALTER TABLE ONLY public.revoked_token DROP CONSTRAINT constraint_rt;
       public            postgres    false    286            +           2606    18641 +   user_attribute constraint_user_attribute_pk 
   CONSTRAINT     i   ALTER TABLE ONLY public.user_attribute
    ADD CONSTRAINT constraint_user_attribute_pk PRIMARY KEY (id);
 U   ALTER TABLE ONLY public.user_attribute DROP CONSTRAINT constraint_user_attribute_pk;
       public            postgres    false    291            O           2606    18643 +   user_group_membership constraint_user_group 
   CONSTRAINT     x   ALTER TABLE ONLY public.user_group_membership
    ADD CONSTRAINT constraint_user_group PRIMARY KEY (group_id, user_id);
 U   ALTER TABLE ONLY public.user_group_membership DROP CONSTRAINT constraint_user_group;
       public            postgres    false    299    299            X           2606    18645 "   web_origins constraint_web_origins 
   CONSTRAINT     n   ALTER TABLE ONLY public.web_origins
    ADD CONSTRAINT constraint_web_origins PRIMARY KEY (client_id, value);
 L   ALTER TABLE ONLY public.web_origins DROP CONSTRAINT constraint_web_origins;
       public            postgres    false    302    302            o           2606    18647 0   databasechangeloglock databasechangeloglock_pkey 
   CONSTRAINT     n   ALTER TABLE ONLY public.databasechangeloglock
    ADD CONSTRAINT databasechangeloglock_pkey PRIMARY KEY (id);
 Z   ALTER TABLE ONLY public.databasechangeloglock DROP CONSTRAINT databasechangeloglock_pkey;
       public            postgres    false    236            W           2606    18649 '   client_scope_attributes pk_cl_tmpl_attr 
   CONSTRAINT     q   ALTER TABLE ONLY public.client_scope_attributes
    ADD CONSTRAINT pk_cl_tmpl_attr PRIMARY KEY (scope_id, name);
 Q   ALTER TABLE ONLY public.client_scope_attributes DROP CONSTRAINT pk_cl_tmpl_attr;
       public            postgres    false    228    228            R           2606    18651    client_scope pk_cli_template 
   CONSTRAINT     Z   ALTER TABLE ONLY public.client_scope
    ADD CONSTRAINT pk_cli_template PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.client_scope DROP CONSTRAINT pk_cli_template;
       public            postgres    false    227                       2606    18653 "   resource_server pk_resource_server 
   CONSTRAINT     `   ALTER TABLE ONLY public.resource_server
    ADD CONSTRAINT pk_resource_server PRIMARY KEY (id);
 L   ALTER TABLE ONLY public.resource_server DROP CONSTRAINT pk_resource_server;
       public            postgres    false    280            _           2606    18655 +   client_scope_role_mapping pk_template_scope 
   CONSTRAINT     x   ALTER TABLE ONLY public.client_scope_role_mapping
    ADD CONSTRAINT pk_template_scope PRIMARY KEY (scope_id, role_id);
 U   ALTER TABLE ONLY public.client_scope_role_mapping DROP CONSTRAINT pk_template_scope;
       public            postgres    false    230    230            s           2606    18657 )   default_client_scope r_def_cli_scope_bind 
   CONSTRAINT     w   ALTER TABLE ONLY public.default_client_scope
    ADD CONSTRAINT r_def_cli_scope_bind PRIMARY KEY (realm_id, scope_id);
 S   ALTER TABLE ONLY public.default_client_scope DROP CONSTRAINT r_def_cli_scope_bind;
       public            postgres    false    237    237            �           2606    18659 ,   realm_localizations realm_localizations_pkey 
   CONSTRAINT     x   ALTER TABLE ONLY public.realm_localizations
    ADD CONSTRAINT realm_localizations_pkey PRIMARY KEY (realm_id, locale);
 V   ALTER TABLE ONLY public.realm_localizations DROP CONSTRAINT realm_localizations_pkey;
       public            postgres    false    270    270            �           2606    18661    resource_attribute res_attr_pk 
   CONSTRAINT     \   ALTER TABLE ONLY public.resource_attribute
    ADD CONSTRAINT res_attr_pk PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.resource_attribute DROP CONSTRAINT res_attr_pk;
       public            postgres    false    277            �           2606    18663    keycloak_group sibling_names 
   CONSTRAINT     o   ALTER TABLE ONLY public.keycloak_group
    ADD CONSTRAINT sibling_names UNIQUE (realm_id, parent_group, name);
 F   ALTER TABLE ONLY public.keycloak_group DROP CONSTRAINT sibling_names;
       public            postgres    false    255    255    255            �           2606    18665 /   identity_provider uk_2daelwnibji49avxsrtuf6xj33 
   CONSTRAINT     ~   ALTER TABLE ONLY public.identity_provider
    ADD CONSTRAINT uk_2daelwnibji49avxsrtuf6xj33 UNIQUE (provider_alias, realm_id);
 Y   ALTER TABLE ONLY public.identity_provider DROP CONSTRAINT uk_2daelwnibji49avxsrtuf6xj33;
       public            postgres    false    250    250            E           2606    18667 #   client uk_b71cjlbenv945rb6gcon438at 
   CONSTRAINT     m   ALTER TABLE ONLY public.client
    ADD CONSTRAINT uk_b71cjlbenv945rb6gcon438at UNIQUE (realm_id, client_id);
 M   ALTER TABLE ONLY public.client DROP CONSTRAINT uk_b71cjlbenv945rb6gcon438at;
       public            postgres    false    222    222            T           2606    18669    client_scope uk_cli_scope 
   CONSTRAINT     ^   ALTER TABLE ONLY public.client_scope
    ADD CONSTRAINT uk_cli_scope UNIQUE (realm_id, name);
 C   ALTER TABLE ONLY public.client_scope DROP CONSTRAINT uk_cli_scope;
       public            postgres    false    227    227            @           2606    18671 (   user_entity uk_dykn684sl8up1crfei6eckhd7 
   CONSTRAINT     y   ALTER TABLE ONLY public.user_entity
    ADD CONSTRAINT uk_dykn684sl8up1crfei6eckhd7 UNIQUE (realm_id, email_constraint);
 R   ALTER TABLE ONLY public.user_entity DROP CONSTRAINT uk_dykn684sl8up1crfei6eckhd7;
       public            postgres    false    294    294            4           2606    18673     user_consent uk_external_consent 
   CONSTRAINT     �   ALTER TABLE ONLY public.user_consent
    ADD CONSTRAINT uk_external_consent UNIQUE (client_storage_provider, external_client_id, user_id);
 J   ALTER TABLE ONLY public.user_consent DROP CONSTRAINT uk_external_consent;
       public            postgres    false    292    292    292                       2606    18675 4   resource_server_resource uk_frsr6t700s9v50bu18ws5ha6 
   CONSTRAINT     �   ALTER TABLE ONLY public.resource_server_resource
    ADD CONSTRAINT uk_frsr6t700s9v50bu18ws5ha6 UNIQUE (name, owner, resource_server_id);
 ^   ALTER TABLE ONLY public.resource_server_resource DROP CONSTRAINT uk_frsr6t700s9v50bu18ws5ha6;
       public            postgres    false    283    283    283            
           2606    18677 7   resource_server_perm_ticket uk_frsr6t700s9v50bu18ws5pmt 
   CONSTRAINT     �   ALTER TABLE ONLY public.resource_server_perm_ticket
    ADD CONSTRAINT uk_frsr6t700s9v50bu18ws5pmt UNIQUE (owner, requester, resource_server_id, resource_id, scope_id);
 a   ALTER TABLE ONLY public.resource_server_perm_ticket DROP CONSTRAINT uk_frsr6t700s9v50bu18ws5pmt;
       public            postgres    false    281    281    281    281    281                       2606    18679 2   resource_server_policy uk_frsrpt700s9v50bu18ws5ha6 
   CONSTRAINT     �   ALTER TABLE ONLY public.resource_server_policy
    ADD CONSTRAINT uk_frsrpt700s9v50bu18ws5ha6 UNIQUE (name, resource_server_id);
 \   ALTER TABLE ONLY public.resource_server_policy DROP CONSTRAINT uk_frsrpt700s9v50bu18ws5ha6;
       public            postgres    false    282    282                       2606    18681 1   resource_server_scope uk_frsrst700s9v50bu18ws5ha6 
   CONSTRAINT     �   ALTER TABLE ONLY public.resource_server_scope
    ADD CONSTRAINT uk_frsrst700s9v50bu18ws5ha6 UNIQUE (name, resource_server_id);
 [   ALTER TABLE ONLY public.resource_server_scope DROP CONSTRAINT uk_frsrst700s9v50bu18ws5ha6;
       public            postgres    false    284    284            6           2606    18683    user_consent uk_local_consent 
   CONSTRAINT     f   ALTER TABLE ONLY public.user_consent
    ADD CONSTRAINT uk_local_consent UNIQUE (client_id, user_id);
 G   ALTER TABLE ONLY public.user_consent DROP CONSTRAINT uk_local_consent;
       public            postgres    false    292    292            �           2606    18685    org uk_org_alias 
   CONSTRAINT     V   ALTER TABLE ONLY public.org
    ADD CONSTRAINT uk_org_alias UNIQUE (realm_id, alias);
 :   ALTER TABLE ONLY public.org DROP CONSTRAINT uk_org_alias;
       public            postgres    false    260    260            �           2606    18687    org uk_org_group 
   CONSTRAINT     O   ALTER TABLE ONLY public.org
    ADD CONSTRAINT uk_org_group UNIQUE (group_id);
 :   ALTER TABLE ONLY public.org DROP CONSTRAINT uk_org_group;
       public            postgres    false    260            �           2606    18689    org uk_org_name 
   CONSTRAINT     T   ALTER TABLE ONLY public.org
    ADD CONSTRAINT uk_org_name UNIQUE (realm_id, name);
 9   ALTER TABLE ONLY public.org DROP CONSTRAINT uk_org_name;
       public            postgres    false    260    260            �           2606    18691 "   realm uk_orvsdmla56612eaefiq6wl5oi 
   CONSTRAINT     ]   ALTER TABLE ONLY public.realm
    ADD CONSTRAINT uk_orvsdmla56612eaefiq6wl5oi UNIQUE (name);
 L   ALTER TABLE ONLY public.realm DROP CONSTRAINT uk_orvsdmla56612eaefiq6wl5oi;
       public            postgres    false    265            B           2606    18693 (   user_entity uk_ru8tt6t700s9v50bu18ws5ha6 
   CONSTRAINT     q   ALTER TABLE ONLY public.user_entity
    ADD CONSTRAINT uk_ru8tt6t700s9v50bu18ws5ha6 UNIQUE (realm_id, username);
 R   ALTER TABLE ONLY public.user_entity DROP CONSTRAINT uk_ru8tt6t700s9v50bu18ws5ha6;
       public            postgres    false    294    294            y           1259    18694    fed_user_attr_long_values    INDEX     i   CREATE INDEX fed_user_attr_long_values ON public.fed_user_attribute USING btree (long_value_hash, name);
 -   DROP INDEX public.fed_user_attr_long_values;
       public            postgres    false    239    239            z           1259    18695 $   fed_user_attr_long_values_lower_case    INDEX        CREATE INDEX fed_user_attr_long_values_lower_case ON public.fed_user_attribute USING btree (long_value_hash_lower_case, name);
 8   DROP INDEX public.fed_user_attr_long_values_lower_case;
       public            postgres    false    239    239            /           1259    18696    idx_admin_event_time    INDEX     i   CREATE INDEX idx_admin_event_time ON public.admin_event_entity USING btree (realm_id, admin_event_time);
 (   DROP INDEX public.idx_admin_event_time;
       public            postgres    false    215    215            2           1259    18697    idx_assoc_pol_assoc_pol_id    INDEX     h   CREATE INDEX idx_assoc_pol_assoc_pol_id ON public.associated_policy USING btree (associated_policy_id);
 .   DROP INDEX public.idx_assoc_pol_assoc_pol_id;
       public            postgres    false    216            <           1259    18698    idx_auth_config_realm    INDEX     Z   CREATE INDEX idx_auth_config_realm ON public.authenticator_config USING btree (realm_id);
 )   DROP INDEX public.idx_auth_config_realm;
       public            postgres    false    219            5           1259    18699    idx_auth_exec_flow    INDEX     Z   CREATE INDEX idx_auth_exec_flow ON public.authentication_execution USING btree (flow_id);
 &   DROP INDEX public.idx_auth_exec_flow;
       public            postgres    false    217            6           1259    18700    idx_auth_exec_realm_flow    INDEX     j   CREATE INDEX idx_auth_exec_realm_flow ON public.authentication_execution USING btree (realm_id, flow_id);
 ,   DROP INDEX public.idx_auth_exec_realm_flow;
       public            postgres    false    217    217            9           1259    18701    idx_auth_flow_realm    INDEX     W   CREATE INDEX idx_auth_flow_realm ON public.authentication_flow USING btree (realm_id);
 '   DROP INDEX public.idx_auth_flow_realm;
       public            postgres    false    218            Z           1259    18702    idx_cl_clscope    INDEX     R   CREATE INDEX idx_cl_clscope ON public.client_scope_client USING btree (scope_id);
 "   DROP INDEX public.idx_cl_clscope;
       public            postgres    false    229            H           1259    18703    idx_client_att_by_name_value    INDEX     q   CREATE INDEX idx_client_att_by_name_value ON public.client_attributes USING btree (name, substr(value, 1, 255));
 0   DROP INDEX public.idx_client_att_by_name_value;
       public            postgres    false    223    223            C           1259    18704    idx_client_id    INDEX     E   CREATE INDEX idx_client_id ON public.client USING btree (client_id);
 !   DROP INDEX public.idx_client_id;
       public            postgres    false    222            M           1259    18705    idx_client_init_acc_realm    INDEX     _   CREATE INDEX idx_client_init_acc_realm ON public.client_initial_access USING btree (realm_id);
 -   DROP INDEX public.idx_client_init_acc_realm;
       public            postgres    false    225            U           1259    18706    idx_clscope_attrs    INDEX     Y   CREATE INDEX idx_clscope_attrs ON public.client_scope_attributes USING btree (scope_id);
 %   DROP INDEX public.idx_clscope_attrs;
       public            postgres    false    228            [           1259    18707    idx_clscope_cl    INDEX     S   CREATE INDEX idx_clscope_cl ON public.client_scope_client USING btree (client_id);
 "   DROP INDEX public.idx_clscope_cl;
       public            postgres    false    229            �           1259    18708    idx_clscope_protmap    INDEX     Z   CREATE INDEX idx_clscope_protmap ON public.protocol_mapper USING btree (client_scope_id);
 '   DROP INDEX public.idx_clscope_protmap;
       public            postgres    false    263            \           1259    18709    idx_clscope_role    INDEX     Z   CREATE INDEX idx_clscope_role ON public.client_scope_role_mapping USING btree (scope_id);
 $   DROP INDEX public.idx_clscope_role;
       public            postgres    false    230            f           1259    18710    idx_compo_config_compo    INDEX     [   CREATE INDEX idx_compo_config_compo ON public.component_config USING btree (component_id);
 *   DROP INDEX public.idx_compo_config_compo;
       public            postgres    false    232            b           1259    18711    idx_component_provider_type    INDEX     Z   CREATE INDEX idx_component_provider_type ON public.component USING btree (provider_type);
 /   DROP INDEX public.idx_component_provider_type;
       public            postgres    false    231            c           1259    18712    idx_component_realm    INDEX     M   CREATE INDEX idx_component_realm ON public.component USING btree (realm_id);
 '   DROP INDEX public.idx_component_realm;
       public            postgres    false    231            i           1259    18713    idx_composite    INDEX     M   CREATE INDEX idx_composite ON public.composite_role USING btree (composite);
 !   DROP INDEX public.idx_composite;
       public            postgres    false    233            j           1259    18714    idx_composite_child    INDEX     T   CREATE INDEX idx_composite_child ON public.composite_role USING btree (child_role);
 '   DROP INDEX public.idx_composite_child;
       public            postgres    false    233            p           1259    18715    idx_defcls_realm    INDEX     U   CREATE INDEX idx_defcls_realm ON public.default_client_scope USING btree (realm_id);
 $   DROP INDEX public.idx_defcls_realm;
       public            postgres    false    237            q           1259    18716    idx_defcls_scope    INDEX     U   CREATE INDEX idx_defcls_scope ON public.default_client_scope USING btree (scope_id);
 $   DROP INDEX public.idx_defcls_scope;
       public            postgres    false    237            v           1259    18717    idx_event_time    INDEX     W   CREATE INDEX idx_event_time ON public.event_entity USING btree (realm_id, event_time);
 "   DROP INDEX public.idx_event_time;
       public            postgres    false    238    238            �           1259    18718    idx_fedidentity_feduser    INDEX     c   CREATE INDEX idx_fedidentity_feduser ON public.federated_identity USING btree (federated_user_id);
 +   DROP INDEX public.idx_fedidentity_feduser;
       public            postgres    false    246            �           1259    18719    idx_fedidentity_user    INDEX     V   CREATE INDEX idx_fedidentity_user ON public.federated_identity USING btree (user_id);
 (   DROP INDEX public.idx_fedidentity_user;
       public            postgres    false    246            {           1259    18720    idx_fu_attribute    INDEX     b   CREATE INDEX idx_fu_attribute ON public.fed_user_attribute USING btree (user_id, realm_id, name);
 $   DROP INDEX public.idx_fu_attribute;
       public            postgres    false    239    239    239            ~           1259    18721    idx_fu_cnsnt_ext    INDEX     }   CREATE INDEX idx_fu_cnsnt_ext ON public.fed_user_consent USING btree (user_id, client_storage_provider, external_client_id);
 $   DROP INDEX public.idx_fu_cnsnt_ext;
       public            postgres    false    240    240    240                       1259    18722    idx_fu_consent    INDEX     Y   CREATE INDEX idx_fu_consent ON public.fed_user_consent USING btree (user_id, client_id);
 "   DROP INDEX public.idx_fu_consent;
       public            postgres    false    240    240            �           1259    18723    idx_fu_consent_ru    INDEX     [   CREATE INDEX idx_fu_consent_ru ON public.fed_user_consent USING btree (realm_id, user_id);
 %   DROP INDEX public.idx_fu_consent_ru;
       public            postgres    false    240    240            �           1259    18724    idx_fu_credential    INDEX     Z   CREATE INDEX idx_fu_credential ON public.fed_user_credential USING btree (user_id, type);
 %   DROP INDEX public.idx_fu_credential;
       public            postgres    false    242    242            �           1259    18725    idx_fu_credential_ru    INDEX     a   CREATE INDEX idx_fu_credential_ru ON public.fed_user_credential USING btree (realm_id, user_id);
 (   DROP INDEX public.idx_fu_credential_ru;
       public            postgres    false    242    242            �           1259    18726    idx_fu_group_membership    INDEX     j   CREATE INDEX idx_fu_group_membership ON public.fed_user_group_membership USING btree (user_id, group_id);
 +   DROP INDEX public.idx_fu_group_membership;
       public            postgres    false    243    243            �           1259    18727    idx_fu_group_membership_ru    INDEX     m   CREATE INDEX idx_fu_group_membership_ru ON public.fed_user_group_membership USING btree (realm_id, user_id);
 .   DROP INDEX public.idx_fu_group_membership_ru;
       public            postgres    false    243    243            �           1259    18728    idx_fu_required_action    INDEX     o   CREATE INDEX idx_fu_required_action ON public.fed_user_required_action USING btree (user_id, required_action);
 *   DROP INDEX public.idx_fu_required_action;
       public            postgres    false    244    244            �           1259    18729    idx_fu_required_action_ru    INDEX     k   CREATE INDEX idx_fu_required_action_ru ON public.fed_user_required_action USING btree (realm_id, user_id);
 -   DROP INDEX public.idx_fu_required_action_ru;
       public            postgres    false    244    244            �           1259    18730    idx_fu_role_mapping    INDEX     a   CREATE INDEX idx_fu_role_mapping ON public.fed_user_role_mapping USING btree (user_id, role_id);
 '   DROP INDEX public.idx_fu_role_mapping;
       public            postgres    false    245    245            �           1259    18731    idx_fu_role_mapping_ru    INDEX     e   CREATE INDEX idx_fu_role_mapping_ru ON public.fed_user_role_mapping USING btree (realm_id, user_id);
 *   DROP INDEX public.idx_fu_role_mapping_ru;
       public            postgres    false    245    245            �           1259    18732    idx_group_att_by_name_value    INDEX     z   CREATE INDEX idx_group_att_by_name_value ON public.group_attribute USING btree (name, ((value)::character varying(250)));
 /   DROP INDEX public.idx_group_att_by_name_value;
       public            postgres    false    248    248            �           1259    18733    idx_group_attr_group    INDEX     T   CREATE INDEX idx_group_attr_group ON public.group_attribute USING btree (group_id);
 (   DROP INDEX public.idx_group_attr_group;
       public            postgres    false    248            �           1259    18734    idx_group_role_mapp_group    INDEX     \   CREATE INDEX idx_group_role_mapp_group ON public.group_role_mapping USING btree (group_id);
 -   DROP INDEX public.idx_group_role_mapp_group;
       public            postgres    false    249            �           1259    18735    idx_id_prov_mapp_realm    INDEX     _   CREATE INDEX idx_id_prov_mapp_realm ON public.identity_provider_mapper USING btree (realm_id);
 *   DROP INDEX public.idx_id_prov_mapp_realm;
       public            postgres    false    252            �           1259    18736    idx_ident_prov_realm    INDEX     V   CREATE INDEX idx_ident_prov_realm ON public.identity_provider USING btree (realm_id);
 (   DROP INDEX public.idx_ident_prov_realm;
       public            postgres    false    250            �           1259    18737    idx_idp_for_login    INDEX     �   CREATE INDEX idx_idp_for_login ON public.identity_provider USING btree (realm_id, enabled, link_only, hide_on_login, organization_id);
 %   DROP INDEX public.idx_idp_for_login;
       public            postgres    false    250    250    250    250    250            �           1259    18738    idx_idp_realm_org    INDEX     d   CREATE INDEX idx_idp_realm_org ON public.identity_provider USING btree (realm_id, organization_id);
 %   DROP INDEX public.idx_idp_realm_org;
       public            postgres    false    250    250            �           1259    18739    idx_keycloak_role_client    INDEX     T   CREATE INDEX idx_keycloak_role_client ON public.keycloak_role USING btree (client);
 ,   DROP INDEX public.idx_keycloak_role_client;
       public            postgres    false    256            �           1259    18740    idx_keycloak_role_realm    INDEX     R   CREATE INDEX idx_keycloak_role_realm ON public.keycloak_role USING btree (realm);
 +   DROP INDEX public.idx_keycloak_role_realm;
       public            postgres    false    256            �           1259    18741 $   idx_offline_uss_by_broker_session_id    INDEX     |   CREATE INDEX idx_offline_uss_by_broker_session_id ON public.offline_user_session USING btree (broker_session_id, realm_id);
 8   DROP INDEX public.idx_offline_uss_by_broker_session_id;
       public            postgres    false    259    259            �           1259    18742 '   idx_offline_uss_by_last_session_refresh    INDEX     �   CREATE INDEX idx_offline_uss_by_last_session_refresh ON public.offline_user_session USING btree (realm_id, offline_flag, last_session_refresh);
 ;   DROP INDEX public.idx_offline_uss_by_last_session_refresh;
       public            postgres    false    259    259    259            �           1259    18743    idx_offline_uss_by_user    INDEX     s   CREATE INDEX idx_offline_uss_by_user ON public.offline_user_session USING btree (user_id, realm_id, offline_flag);
 +   DROP INDEX public.idx_offline_uss_by_user;
       public            postgres    false    259    259    259            �           1259    18744    idx_org_domain_org_id    INDEX     N   CREATE INDEX idx_org_domain_org_id ON public.org_domain USING btree (org_id);
 )   DROP INDEX public.idx_org_domain_org_id;
       public            postgres    false    261                       1259    18745    idx_perm_ticket_owner    INDEX     ^   CREATE INDEX idx_perm_ticket_owner ON public.resource_server_perm_ticket USING btree (owner);
 )   DROP INDEX public.idx_perm_ticket_owner;
       public            postgres    false    281                       1259    18746    idx_perm_ticket_requester    INDEX     f   CREATE INDEX idx_perm_ticket_requester ON public.resource_server_perm_ticket USING btree (requester);
 -   DROP INDEX public.idx_perm_ticket_requester;
       public            postgres    false    281            �           1259    18747    idx_protocol_mapper_client    INDEX     [   CREATE INDEX idx_protocol_mapper_client ON public.protocol_mapper USING btree (client_id);
 .   DROP INDEX public.idx_protocol_mapper_client;
       public            postgres    false    263            �           1259    18748    idx_realm_attr_realm    INDEX     T   CREATE INDEX idx_realm_attr_realm ON public.realm_attribute USING btree (realm_id);
 (   DROP INDEX public.idx_realm_attr_realm;
       public            postgres    false    266            P           1259    18749    idx_realm_clscope    INDEX     N   CREATE INDEX idx_realm_clscope ON public.client_scope USING btree (realm_id);
 %   DROP INDEX public.idx_realm_clscope;
       public            postgres    false    227            �           1259    18750    idx_realm_def_grp_realm    INDEX     \   CREATE INDEX idx_realm_def_grp_realm ON public.realm_default_groups USING btree (realm_id);
 +   DROP INDEX public.idx_realm_def_grp_realm;
       public            postgres    false    267            �           1259    18751    idx_realm_evt_list_realm    INDEX     _   CREATE INDEX idx_realm_evt_list_realm ON public.realm_events_listeners USING btree (realm_id);
 ,   DROP INDEX public.idx_realm_evt_list_realm;
       public            postgres    false    269            �           1259    18752    idx_realm_evt_types_realm    INDEX     c   CREATE INDEX idx_realm_evt_types_realm ON public.realm_enabled_event_types USING btree (realm_id);
 -   DROP INDEX public.idx_realm_evt_types_realm;
       public            postgres    false    268            �           1259    18753    idx_realm_master_adm_cli    INDEX     Y   CREATE INDEX idx_realm_master_adm_cli ON public.realm USING btree (master_admin_client);
 ,   DROP INDEX public.idx_realm_master_adm_cli;
       public            postgres    false    265            �           1259    18754    idx_realm_supp_local_realm    INDEX     b   CREATE INDEX idx_realm_supp_local_realm ON public.realm_supported_locales USING btree (realm_id);
 .   DROP INDEX public.idx_realm_supp_local_realm;
       public            postgres    false    273            �           1259    18755    idx_redir_uri_client    INDEX     S   CREATE INDEX idx_redir_uri_client ON public.redirect_uris USING btree (client_id);
 (   DROP INDEX public.idx_redir_uri_client;
       public            postgres    false    274            �           1259    18756    idx_req_act_prov_realm    INDEX     _   CREATE INDEX idx_req_act_prov_realm ON public.required_action_provider USING btree (realm_id);
 *   DROP INDEX public.idx_req_act_prov_realm;
       public            postgres    false    276            �           1259    18757    idx_res_policy_policy    INDEX     V   CREATE INDEX idx_res_policy_policy ON public.resource_policy USING btree (policy_id);
 )   DROP INDEX public.idx_res_policy_policy;
       public            postgres    false    278                       1259    18758    idx_res_scope_scope    INDEX     R   CREATE INDEX idx_res_scope_scope ON public.resource_scope USING btree (scope_id);
 '   DROP INDEX public.idx_res_scope_scope;
       public            postgres    false    279                       1259    18759    idx_res_serv_pol_res_serv    INDEX     j   CREATE INDEX idx_res_serv_pol_res_serv ON public.resource_server_policy USING btree (resource_server_id);
 -   DROP INDEX public.idx_res_serv_pol_res_serv;
       public            postgres    false    282                       1259    18760    idx_res_srv_res_res_srv    INDEX     j   CREATE INDEX idx_res_srv_res_res_srv ON public.resource_server_resource USING btree (resource_server_id);
 +   DROP INDEX public.idx_res_srv_res_res_srv;
       public            postgres    false    283                       1259    18761    idx_res_srv_scope_res_srv    INDEX     i   CREATE INDEX idx_res_srv_scope_res_srv ON public.resource_server_scope USING btree (resource_server_id);
 -   DROP INDEX public.idx_res_srv_scope_res_srv;
       public            postgres    false    284                       1259    18762    idx_rev_token_on_expire    INDEX     S   CREATE INDEX idx_rev_token_on_expire ON public.revoked_token USING btree (expire);
 +   DROP INDEX public.idx_rev_token_on_expire;
       public            postgres    false    286            !           1259    18763    idx_role_attribute    INDEX     P   CREATE INDEX idx_role_attribute ON public.role_attribute USING btree (role_id);
 &   DROP INDEX public.idx_role_attribute;
       public            postgres    false    287            ]           1259    18764    idx_role_clscope    INDEX     Y   CREATE INDEX idx_role_clscope ON public.client_scope_role_mapping USING btree (role_id);
 $   DROP INDEX public.idx_role_clscope;
       public            postgres    false    230            $           1259    18765    idx_scope_mapping_role    INDEX     S   CREATE INDEX idx_scope_mapping_role ON public.scope_mapping USING btree (role_id);
 *   DROP INDEX public.idx_scope_mapping_role;
       public            postgres    false    288            '           1259    18766    idx_scope_policy_policy    INDEX     U   CREATE INDEX idx_scope_policy_policy ON public.scope_policy USING btree (policy_id);
 +   DROP INDEX public.idx_scope_policy_policy;
       public            postgres    false    289            �           1259    18767    idx_update_time    INDEX     R   CREATE INDEX idx_update_time ON public.migration_model USING btree (update_time);
 #   DROP INDEX public.idx_update_time;
       public            postgres    false    257            9           1259    18768    idx_usconsent_clscope    INDEX     f   CREATE INDEX idx_usconsent_clscope ON public.user_consent_client_scope USING btree (user_consent_id);
 )   DROP INDEX public.idx_usconsent_clscope;
       public            postgres    false    293            :           1259    18769    idx_usconsent_scope_id    INDEX     `   CREATE INDEX idx_usconsent_scope_id ON public.user_consent_client_scope USING btree (scope_id);
 *   DROP INDEX public.idx_usconsent_scope_id;
       public            postgres    false    293            ,           1259    18770    idx_user_attribute    INDEX     P   CREATE INDEX idx_user_attribute ON public.user_attribute USING btree (user_id);
 &   DROP INDEX public.idx_user_attribute;
       public            postgres    false    291            -           1259    18771    idx_user_attribute_name    INDEX     Y   CREATE INDEX idx_user_attribute_name ON public.user_attribute USING btree (name, value);
 +   DROP INDEX public.idx_user_attribute_name;
       public            postgres    false    291    291            2           1259    18772    idx_user_consent    INDEX     L   CREATE INDEX idx_user_consent ON public.user_consent USING btree (user_id);
 $   DROP INDEX public.idx_user_consent;
       public            postgres    false    292            m           1259    18773    idx_user_credential    INDEX     M   CREATE INDEX idx_user_credential ON public.credential USING btree (user_id);
 '   DROP INDEX public.idx_user_credential;
       public            postgres    false    234            =           1259    18774    idx_user_email    INDEX     G   CREATE INDEX idx_user_email ON public.user_entity USING btree (email);
 "   DROP INDEX public.idx_user_email;
       public            postgres    false    294            P           1259    18775    idx_user_group_mapping    INDEX     [   CREATE INDEX idx_user_group_mapping ON public.user_group_membership USING btree (user_id);
 *   DROP INDEX public.idx_user_group_mapping;
       public            postgres    false    299            S           1259    18776    idx_user_reqactions    INDEX     W   CREATE INDEX idx_user_reqactions ON public.user_required_action USING btree (user_id);
 '   DROP INDEX public.idx_user_reqactions;
       public            postgres    false    300            V           1259    18777    idx_user_role_mapping    INDEX     V   CREATE INDEX idx_user_role_mapping ON public.user_role_mapping USING btree (user_id);
 )   DROP INDEX public.idx_user_role_mapping;
       public            postgres    false    301            >           1259    18778    idx_user_service_account    INDEX     q   CREATE INDEX idx_user_service_account ON public.user_entity USING btree (realm_id, service_account_client_link);
 ,   DROP INDEX public.idx_user_service_account;
       public            postgres    false    294    294            G           1259    18779    idx_usr_fed_map_fed_prv    INDEX     l   CREATE INDEX idx_usr_fed_map_fed_prv ON public.user_federation_mapper USING btree (federation_provider_id);
 +   DROP INDEX public.idx_usr_fed_map_fed_prv;
       public            postgres    false    296            H           1259    18780    idx_usr_fed_map_realm    INDEX     \   CREATE INDEX idx_usr_fed_map_realm ON public.user_federation_mapper USING btree (realm_id);
 )   DROP INDEX public.idx_usr_fed_map_realm;
       public            postgres    false    296            M           1259    18781    idx_usr_fed_prv_realm    INDEX     ^   CREATE INDEX idx_usr_fed_prv_realm ON public.user_federation_provider USING btree (realm_id);
 )   DROP INDEX public.idx_usr_fed_prv_realm;
       public            postgres    false    298            Y           1259    18782    idx_web_orig_client    INDEX     P   CREATE INDEX idx_web_orig_client ON public.web_origins USING btree (client_id);
 '   DROP INDEX public.idx_web_orig_client;
       public            postgres    false    302            .           1259    18783    user_attr_long_values    INDEX     a   CREATE INDEX user_attr_long_values ON public.user_attribute USING btree (long_value_hash, name);
 )   DROP INDEX public.user_attr_long_values;
       public            postgres    false    291    291            /           1259    18784     user_attr_long_values_lower_case    INDEX     w   CREATE INDEX user_attr_long_values_lower_case ON public.user_attribute USING btree (long_value_hash_lower_case, name);
 4   DROP INDEX public.user_attr_long_values_lower_case;
       public            postgres    false    291    291            n           2606    18785 $   identity_provider fk2b4ebc52ae5c3b34    FK CONSTRAINT     �   ALTER TABLE ONLY public.identity_provider
    ADD CONSTRAINT fk2b4ebc52ae5c3b34 FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 N   ALTER TABLE ONLY public.identity_provider DROP CONSTRAINT fk2b4ebc52ae5c3b34;
       public          postgres    false    250    3800    265            `           2606    18790 $   client_attributes fk3c47c64beacca966    FK CONSTRAINT     �   ALTER TABLE ONLY public.client_attributes
    ADD CONSTRAINT fk3c47c64beacca966 FOREIGN KEY (client_id) REFERENCES public.client(id);
 N   ALTER TABLE ONLY public.client_attributes DROP CONSTRAINT fk3c47c64beacca966;
       public          postgres    false    3650    222    223            k           2606    18795 %   federated_identity fk404288b92ef007a6    FK CONSTRAINT     �   ALTER TABLE ONLY public.federated_identity
    ADD CONSTRAINT fk404288b92ef007a6 FOREIGN KEY (user_id) REFERENCES public.user_entity(id);
 O   ALTER TABLE ONLY public.federated_identity DROP CONSTRAINT fk404288b92ef007a6;
       public          postgres    false    246    294    3900            b           2606    18800 ,   client_node_registrations fk4129723ba992f594    FK CONSTRAINT     �   ALTER TABLE ONLY public.client_node_registrations
    ADD CONSTRAINT fk4129723ba992f594 FOREIGN KEY (client_id) REFERENCES public.client(id);
 V   ALTER TABLE ONLY public.client_node_registrations DROP CONSTRAINT fk4129723ba992f594;
       public          postgres    false    226    222    3650            ~           2606    18805 *   redirect_uris fk_1burs8pb4ouj97h5wuppahv9f    FK CONSTRAINT     �   ALTER TABLE ONLY public.redirect_uris
    ADD CONSTRAINT fk_1burs8pb4ouj97h5wuppahv9f FOREIGN KEY (client_id) REFERENCES public.client(id);
 T   ALTER TABLE ONLY public.redirect_uris DROP CONSTRAINT fk_1burs8pb4ouj97h5wuppahv9f;
       public          postgres    false    274    222    3650            �           2606    18810 5   user_federation_provider fk_1fj32f6ptolw2qy60cd8n01e8    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_federation_provider
    ADD CONSTRAINT fk_1fj32f6ptolw2qy60cd8n01e8 FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 _   ALTER TABLE ONLY public.user_federation_provider DROP CONSTRAINT fk_1fj32f6ptolw2qy60cd8n01e8;
       public          postgres    false    298    3800    265            {           2606    18815 6   realm_required_credential fk_5hg65lybevavkqfki3kponh9v    FK CONSTRAINT     �   ALTER TABLE ONLY public.realm_required_credential
    ADD CONSTRAINT fk_5hg65lybevavkqfki3kponh9v FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 `   ALTER TABLE ONLY public.realm_required_credential DROP CONSTRAINT fk_5hg65lybevavkqfki3kponh9v;
       public          postgres    false    271    3800    265            �           2606    18820 /   resource_attribute fk_5hrm2vlf9ql5fu022kqepovbr    FK CONSTRAINT     �   ALTER TABLE ONLY public.resource_attribute
    ADD CONSTRAINT fk_5hrm2vlf9ql5fu022kqepovbr FOREIGN KEY (resource_id) REFERENCES public.resource_server_resource(id);
 Y   ALTER TABLE ONLY public.resource_attribute DROP CONSTRAINT fk_5hrm2vlf9ql5fu022kqepovbr;
       public          postgres    false    277    283    3857            �           2606    18825 +   user_attribute fk_5hrm2vlf9ql5fu043kqepovbr    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_attribute
    ADD CONSTRAINT fk_5hrm2vlf9ql5fu043kqepovbr FOREIGN KEY (user_id) REFERENCES public.user_entity(id);
 U   ALTER TABLE ONLY public.user_attribute DROP CONSTRAINT fk_5hrm2vlf9ql5fu043kqepovbr;
       public          postgres    false    3900    291    294            �           2606    18830 1   user_required_action fk_6qj3w1jw9cvafhe19bwsiuvmd    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_required_action
    ADD CONSTRAINT fk_6qj3w1jw9cvafhe19bwsiuvmd FOREIGN KEY (user_id) REFERENCES public.user_entity(id);
 [   ALTER TABLE ONLY public.user_required_action DROP CONSTRAINT fk_6qj3w1jw9cvafhe19bwsiuvmd;
       public          postgres    false    3900    300    294            r           2606    18835 *   keycloak_role fk_6vyqfe4cn4wlq8r6kt5vdsj5c    FK CONSTRAINT     �   ALTER TABLE ONLY public.keycloak_role
    ADD CONSTRAINT fk_6vyqfe4cn4wlq8r6kt5vdsj5c FOREIGN KEY (realm) REFERENCES public.realm(id);
 T   ALTER TABLE ONLY public.keycloak_role DROP CONSTRAINT fk_6vyqfe4cn4wlq8r6kt5vdsj5c;
       public          postgres    false    3800    256    265            |           2606    18840 .   realm_smtp_config fk_70ej8xdxgxd0b9hh6180irr0o    FK CONSTRAINT     �   ALTER TABLE ONLY public.realm_smtp_config
    ADD CONSTRAINT fk_70ej8xdxgxd0b9hh6180irr0o FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 X   ALTER TABLE ONLY public.realm_smtp_config DROP CONSTRAINT fk_70ej8xdxgxd0b9hh6180irr0o;
       public          postgres    false    3800    272    265            w           2606    18845 ,   realm_attribute fk_8shxd6l3e9atqukacxgpffptw    FK CONSTRAINT     �   ALTER TABLE ONLY public.realm_attribute
    ADD CONSTRAINT fk_8shxd6l3e9atqukacxgpffptw FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 V   ALTER TABLE ONLY public.realm_attribute DROP CONSTRAINT fk_8shxd6l3e9atqukacxgpffptw;
       public          postgres    false    265    266    3800            g           2606    18850 +   composite_role fk_a63wvekftu8jo1pnj81e7mce2    FK CONSTRAINT     �   ALTER TABLE ONLY public.composite_role
    ADD CONSTRAINT fk_a63wvekftu8jo1pnj81e7mce2 FOREIGN KEY (composite) REFERENCES public.keycloak_role(id);
 U   ALTER TABLE ONLY public.composite_role DROP CONSTRAINT fk_a63wvekftu8jo1pnj81e7mce2;
       public          postgres    false    3767    233    256            \           2606    18855 *   authentication_execution fk_auth_exec_flow    FK CONSTRAINT     �   ALTER TABLE ONLY public.authentication_execution
    ADD CONSTRAINT fk_auth_exec_flow FOREIGN KEY (flow_id) REFERENCES public.authentication_flow(id);
 T   ALTER TABLE ONLY public.authentication_execution DROP CONSTRAINT fk_auth_exec_flow;
       public          postgres    false    3640    218    217            ]           2606    18860 +   authentication_execution fk_auth_exec_realm    FK CONSTRAINT     �   ALTER TABLE ONLY public.authentication_execution
    ADD CONSTRAINT fk_auth_exec_realm FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 U   ALTER TABLE ONLY public.authentication_execution DROP CONSTRAINT fk_auth_exec_realm;
       public          postgres    false    265    217    3800            ^           2606    18865 &   authentication_flow fk_auth_flow_realm    FK CONSTRAINT     �   ALTER TABLE ONLY public.authentication_flow
    ADD CONSTRAINT fk_auth_flow_realm FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 P   ALTER TABLE ONLY public.authentication_flow DROP CONSTRAINT fk_auth_flow_realm;
       public          postgres    false    265    218    3800            _           2606    18870 "   authenticator_config fk_auth_realm    FK CONSTRAINT     �   ALTER TABLE ONLY public.authenticator_config
    ADD CONSTRAINT fk_auth_realm FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 L   ALTER TABLE ONLY public.authenticator_config DROP CONSTRAINT fk_auth_realm;
       public          postgres    false    3800    219    265            �           2606    18875 .   user_role_mapping fk_c4fqv34p1mbylloxang7b1q3l    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_role_mapping
    ADD CONSTRAINT fk_c4fqv34p1mbylloxang7b1q3l FOREIGN KEY (user_id) REFERENCES public.user_entity(id);
 X   ALTER TABLE ONLY public.user_role_mapping DROP CONSTRAINT fk_c4fqv34p1mbylloxang7b1q3l;
       public          postgres    false    294    301    3900            c           2606    18880 .   client_scope_attributes fk_cl_scope_attr_scope    FK CONSTRAINT     �   ALTER TABLE ONLY public.client_scope_attributes
    ADD CONSTRAINT fk_cl_scope_attr_scope FOREIGN KEY (scope_id) REFERENCES public.client_scope(id);
 X   ALTER TABLE ONLY public.client_scope_attributes DROP CONSTRAINT fk_cl_scope_attr_scope;
       public          postgres    false    3666    227    228            d           2606    18885 .   client_scope_role_mapping fk_cl_scope_rm_scope    FK CONSTRAINT     �   ALTER TABLE ONLY public.client_scope_role_mapping
    ADD CONSTRAINT fk_cl_scope_rm_scope FOREIGN KEY (scope_id) REFERENCES public.client_scope(id);
 X   ALTER TABLE ONLY public.client_scope_role_mapping DROP CONSTRAINT fk_cl_scope_rm_scope;
       public          postgres    false    230    227    3666            t           2606    18890 #   protocol_mapper fk_cli_scope_mapper    FK CONSTRAINT     �   ALTER TABLE ONLY public.protocol_mapper
    ADD CONSTRAINT fk_cli_scope_mapper FOREIGN KEY (client_scope_id) REFERENCES public.client_scope(id);
 M   ALTER TABLE ONLY public.protocol_mapper DROP CONSTRAINT fk_cli_scope_mapper;
       public          postgres    false    263    3666    227            a           2606    18895 .   client_initial_access fk_client_init_acc_realm    FK CONSTRAINT     �   ALTER TABLE ONLY public.client_initial_access
    ADD CONSTRAINT fk_client_init_acc_realm FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 X   ALTER TABLE ONLY public.client_initial_access DROP CONSTRAINT fk_client_init_acc_realm;
       public          postgres    false    265    3800    225            f           2606    18900 $   component_config fk_component_config    FK CONSTRAINT     �   ALTER TABLE ONLY public.component_config
    ADD CONSTRAINT fk_component_config FOREIGN KEY (component_id) REFERENCES public.component(id);
 N   ALTER TABLE ONLY public.component_config DROP CONSTRAINT fk_component_config;
       public          postgres    false    231    3681    232            e           2606    18905    component fk_component_realm    FK CONSTRAINT     |   ALTER TABLE ONLY public.component
    ADD CONSTRAINT fk_component_realm FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 F   ALTER TABLE ONLY public.component DROP CONSTRAINT fk_component_realm;
       public          postgres    false    3800    231    265            x           2606    18910 (   realm_default_groups fk_def_groups_realm    FK CONSTRAINT     �   ALTER TABLE ONLY public.realm_default_groups
    ADD CONSTRAINT fk_def_groups_realm FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 R   ALTER TABLE ONLY public.realm_default_groups DROP CONSTRAINT fk_def_groups_realm;
       public          postgres    false    267    265    3800            �           2606    18915 .   user_federation_mapper_config fk_fedmapper_cfg    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_federation_mapper_config
    ADD CONSTRAINT fk_fedmapper_cfg FOREIGN KEY (user_federation_mapper_id) REFERENCES public.user_federation_mapper(id);
 X   ALTER TABLE ONLY public.user_federation_mapper_config DROP CONSTRAINT fk_fedmapper_cfg;
       public          postgres    false    296    3910    297            �           2606    18920 ,   user_federation_mapper fk_fedmapperpm_fedprv    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_federation_mapper
    ADD CONSTRAINT fk_fedmapperpm_fedprv FOREIGN KEY (federation_provider_id) REFERENCES public.user_federation_provider(id);
 V   ALTER TABLE ONLY public.user_federation_mapper DROP CONSTRAINT fk_fedmapperpm_fedprv;
       public          postgres    false    298    296    3916            �           2606    18925 +   user_federation_mapper fk_fedmapperpm_realm    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_federation_mapper
    ADD CONSTRAINT fk_fedmapperpm_realm FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 U   ALTER TABLE ONLY public.user_federation_mapper DROP CONSTRAINT fk_fedmapperpm_realm;
       public          postgres    false    296    265    3800            Z           2606    18930 .   associated_policy fk_frsr5s213xcx4wnkog82ssrfy    FK CONSTRAINT     �   ALTER TABLE ONLY public.associated_policy
    ADD CONSTRAINT fk_frsr5s213xcx4wnkog82ssrfy FOREIGN KEY (associated_policy_id) REFERENCES public.resource_server_policy(id);
 X   ALTER TABLE ONLY public.associated_policy DROP CONSTRAINT fk_frsr5s213xcx4wnkog82ssrfy;
       public          postgres    false    216    3852    282            �           2606    18935 )   scope_policy fk_frsrasp13xcx4wnkog82ssrfy    FK CONSTRAINT     �   ALTER TABLE ONLY public.scope_policy
    ADD CONSTRAINT fk_frsrasp13xcx4wnkog82ssrfy FOREIGN KEY (policy_id) REFERENCES public.resource_server_policy(id);
 S   ALTER TABLE ONLY public.scope_policy DROP CONSTRAINT fk_frsrasp13xcx4wnkog82ssrfy;
       public          postgres    false    282    3852    289            �           2606    18940 8   resource_server_perm_ticket fk_frsrho213xcx4wnkog82sspmt    FK CONSTRAINT     �   ALTER TABLE ONLY public.resource_server_perm_ticket
    ADD CONSTRAINT fk_frsrho213xcx4wnkog82sspmt FOREIGN KEY (resource_server_id) REFERENCES public.resource_server(id);
 b   ALTER TABLE ONLY public.resource_server_perm_ticket DROP CONSTRAINT fk_frsrho213xcx4wnkog82sspmt;
       public          postgres    false    280    281    3844            �           2606    18945 5   resource_server_resource fk_frsrho213xcx4wnkog82ssrfy    FK CONSTRAINT     �   ALTER TABLE ONLY public.resource_server_resource
    ADD CONSTRAINT fk_frsrho213xcx4wnkog82ssrfy FOREIGN KEY (resource_server_id) REFERENCES public.resource_server(id);
 _   ALTER TABLE ONLY public.resource_server_resource DROP CONSTRAINT fk_frsrho213xcx4wnkog82ssrfy;
       public          postgres    false    283    3844    280            �           2606    18950 8   resource_server_perm_ticket fk_frsrho213xcx4wnkog83sspmt    FK CONSTRAINT     �   ALTER TABLE ONLY public.resource_server_perm_ticket
    ADD CONSTRAINT fk_frsrho213xcx4wnkog83sspmt FOREIGN KEY (resource_id) REFERENCES public.resource_server_resource(id);
 b   ALTER TABLE ONLY public.resource_server_perm_ticket DROP CONSTRAINT fk_frsrho213xcx4wnkog83sspmt;
       public          postgres    false    281    3857    283            �           2606    18955 8   resource_server_perm_ticket fk_frsrho213xcx4wnkog84sspmt    FK CONSTRAINT     �   ALTER TABLE ONLY public.resource_server_perm_ticket
    ADD CONSTRAINT fk_frsrho213xcx4wnkog84sspmt FOREIGN KEY (scope_id) REFERENCES public.resource_server_scope(id);
 b   ALTER TABLE ONLY public.resource_server_perm_ticket DROP CONSTRAINT fk_frsrho213xcx4wnkog84sspmt;
       public          postgres    false    3862    281    284            [           2606    18960 .   associated_policy fk_frsrpas14xcx4wnkog82ssrfy    FK CONSTRAINT     �   ALTER TABLE ONLY public.associated_policy
    ADD CONSTRAINT fk_frsrpas14xcx4wnkog82ssrfy FOREIGN KEY (policy_id) REFERENCES public.resource_server_policy(id);
 X   ALTER TABLE ONLY public.associated_policy DROP CONSTRAINT fk_frsrpas14xcx4wnkog82ssrfy;
       public          postgres    false    282    3852    216            �           2606    18965 )   scope_policy fk_frsrpass3xcx4wnkog82ssrfy    FK CONSTRAINT     �   ALTER TABLE ONLY public.scope_policy
    ADD CONSTRAINT fk_frsrpass3xcx4wnkog82ssrfy FOREIGN KEY (scope_id) REFERENCES public.resource_server_scope(id);
 S   ALTER TABLE ONLY public.scope_policy DROP CONSTRAINT fk_frsrpass3xcx4wnkog82ssrfy;
       public          postgres    false    3862    289    284            �           2606    18970 8   resource_server_perm_ticket fk_frsrpo2128cx4wnkog82ssrfy    FK CONSTRAINT     �   ALTER TABLE ONLY public.resource_server_perm_ticket
    ADD CONSTRAINT fk_frsrpo2128cx4wnkog82ssrfy FOREIGN KEY (policy_id) REFERENCES public.resource_server_policy(id);
 b   ALTER TABLE ONLY public.resource_server_perm_ticket DROP CONSTRAINT fk_frsrpo2128cx4wnkog82ssrfy;
       public          postgres    false    3852    282    281            �           2606    18975 3   resource_server_policy fk_frsrpo213xcx4wnkog82ssrfy    FK CONSTRAINT     �   ALTER TABLE ONLY public.resource_server_policy
    ADD CONSTRAINT fk_frsrpo213xcx4wnkog82ssrfy FOREIGN KEY (resource_server_id) REFERENCES public.resource_server(id);
 ]   ALTER TABLE ONLY public.resource_server_policy DROP CONSTRAINT fk_frsrpo213xcx4wnkog82ssrfy;
       public          postgres    false    282    280    3844            �           2606    18980 +   resource_scope fk_frsrpos13xcx4wnkog82ssrfy    FK CONSTRAINT     �   ALTER TABLE ONLY public.resource_scope
    ADD CONSTRAINT fk_frsrpos13xcx4wnkog82ssrfy FOREIGN KEY (resource_id) REFERENCES public.resource_server_resource(id);
 U   ALTER TABLE ONLY public.resource_scope DROP CONSTRAINT fk_frsrpos13xcx4wnkog82ssrfy;
       public          postgres    false    279    283    3857            �           2606    18985 ,   resource_policy fk_frsrpos53xcx4wnkog82ssrfy    FK CONSTRAINT     �   ALTER TABLE ONLY public.resource_policy
    ADD CONSTRAINT fk_frsrpos53xcx4wnkog82ssrfy FOREIGN KEY (resource_id) REFERENCES public.resource_server_resource(id);
 V   ALTER TABLE ONLY public.resource_policy DROP CONSTRAINT fk_frsrpos53xcx4wnkog82ssrfy;
       public          postgres    false    283    278    3857            �           2606    18990 ,   resource_policy fk_frsrpp213xcx4wnkog82ssrfy    FK CONSTRAINT     �   ALTER TABLE ONLY public.resource_policy
    ADD CONSTRAINT fk_frsrpp213xcx4wnkog82ssrfy FOREIGN KEY (policy_id) REFERENCES public.resource_server_policy(id);
 V   ALTER TABLE ONLY public.resource_policy DROP CONSTRAINT fk_frsrpp213xcx4wnkog82ssrfy;
       public          postgres    false    278    3852    282            �           2606    18995 +   resource_scope fk_frsrps213xcx4wnkog82ssrfy    FK CONSTRAINT     �   ALTER TABLE ONLY public.resource_scope
    ADD CONSTRAINT fk_frsrps213xcx4wnkog82ssrfy FOREIGN KEY (scope_id) REFERENCES public.resource_server_scope(id);
 U   ALTER TABLE ONLY public.resource_scope DROP CONSTRAINT fk_frsrps213xcx4wnkog82ssrfy;
       public          postgres    false    3862    284    279            �           2606    19000 2   resource_server_scope fk_frsrso213xcx4wnkog82ssrfy    FK CONSTRAINT     �   ALTER TABLE ONLY public.resource_server_scope
    ADD CONSTRAINT fk_frsrso213xcx4wnkog82ssrfy FOREIGN KEY (resource_server_id) REFERENCES public.resource_server(id);
 \   ALTER TABLE ONLY public.resource_server_scope DROP CONSTRAINT fk_frsrso213xcx4wnkog82ssrfy;
       public          postgres    false    284    280    3844            h           2606    19005 +   composite_role fk_gr7thllb9lu8q4vqa4524jjy8    FK CONSTRAINT     �   ALTER TABLE ONLY public.composite_role
    ADD CONSTRAINT fk_gr7thllb9lu8q4vqa4524jjy8 FOREIGN KEY (child_role) REFERENCES public.keycloak_role(id);
 U   ALTER TABLE ONLY public.composite_role DROP CONSTRAINT fk_gr7thllb9lu8q4vqa4524jjy8;
       public          postgres    false    233    256    3767            �           2606    19010 .   user_consent_client_scope fk_grntcsnt_clsc_usc    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_consent_client_scope
    ADD CONSTRAINT fk_grntcsnt_clsc_usc FOREIGN KEY (user_consent_id) REFERENCES public.user_consent(id);
 X   ALTER TABLE ONLY public.user_consent_client_scope DROP CONSTRAINT fk_grntcsnt_clsc_usc;
       public          postgres    false    293    292    3889            �           2606    19015    user_consent fk_grntcsnt_user    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_consent
    ADD CONSTRAINT fk_grntcsnt_user FOREIGN KEY (user_id) REFERENCES public.user_entity(id);
 G   ALTER TABLE ONLY public.user_consent DROP CONSTRAINT fk_grntcsnt_user;
       public          postgres    false    292    294    3900            l           2606    19020 (   group_attribute fk_group_attribute_group    FK CONSTRAINT     �   ALTER TABLE ONLY public.group_attribute
    ADD CONSTRAINT fk_group_attribute_group FOREIGN KEY (group_id) REFERENCES public.keycloak_group(id);
 R   ALTER TABLE ONLY public.group_attribute DROP CONSTRAINT fk_group_attribute_group;
       public          postgres    false    255    248    3761            m           2606    19025 &   group_role_mapping fk_group_role_group    FK CONSTRAINT     �   ALTER TABLE ONLY public.group_role_mapping
    ADD CONSTRAINT fk_group_role_group FOREIGN KEY (group_id) REFERENCES public.keycloak_group(id);
 P   ALTER TABLE ONLY public.group_role_mapping DROP CONSTRAINT fk_group_role_group;
       public          postgres    false    249    3761    255            y           2606    19030 6   realm_enabled_event_types fk_h846o4h0w8epx5nwedrf5y69j    FK CONSTRAINT     �   ALTER TABLE ONLY public.realm_enabled_event_types
    ADD CONSTRAINT fk_h846o4h0w8epx5nwedrf5y69j FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 `   ALTER TABLE ONLY public.realm_enabled_event_types DROP CONSTRAINT fk_h846o4h0w8epx5nwedrf5y69j;
       public          postgres    false    268    3800    265            z           2606    19035 3   realm_events_listeners fk_h846o4h0w8epx5nxev9f5y69j    FK CONSTRAINT     �   ALTER TABLE ONLY public.realm_events_listeners
    ADD CONSTRAINT fk_h846o4h0w8epx5nxev9f5y69j FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 ]   ALTER TABLE ONLY public.realm_events_listeners DROP CONSTRAINT fk_h846o4h0w8epx5nxev9f5y69j;
       public          postgres    false    265    269    3800            p           2606    19040 &   identity_provider_mapper fk_idpm_realm    FK CONSTRAINT     �   ALTER TABLE ONLY public.identity_provider_mapper
    ADD CONSTRAINT fk_idpm_realm FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 P   ALTER TABLE ONLY public.identity_provider_mapper DROP CONSTRAINT fk_idpm_realm;
       public          postgres    false    252    265    3800            q           2606    19045    idp_mapper_config fk_idpmconfig    FK CONSTRAINT     �   ALTER TABLE ONLY public.idp_mapper_config
    ADD CONSTRAINT fk_idpmconfig FOREIGN KEY (idp_mapper_id) REFERENCES public.identity_provider_mapper(id);
 I   ALTER TABLE ONLY public.idp_mapper_config DROP CONSTRAINT fk_idpmconfig;
       public          postgres    false    3754    253    252            �           2606    19050 (   web_origins fk_lojpho213xcx4wnkog82ssrfy    FK CONSTRAINT     �   ALTER TABLE ONLY public.web_origins
    ADD CONSTRAINT fk_lojpho213xcx4wnkog82ssrfy FOREIGN KEY (client_id) REFERENCES public.client(id);
 R   ALTER TABLE ONLY public.web_origins DROP CONSTRAINT fk_lojpho213xcx4wnkog82ssrfy;
       public          postgres    false    222    3650    302            �           2606    19055 *   scope_mapping fk_ouse064plmlr732lxjcn1q5f1    FK CONSTRAINT     �   ALTER TABLE ONLY public.scope_mapping
    ADD CONSTRAINT fk_ouse064plmlr732lxjcn1q5f1 FOREIGN KEY (client_id) REFERENCES public.client(id);
 T   ALTER TABLE ONLY public.scope_mapping DROP CONSTRAINT fk_ouse064plmlr732lxjcn1q5f1;
       public          postgres    false    3650    222    288            u           2606    19060    protocol_mapper fk_pcm_realm    FK CONSTRAINT     ~   ALTER TABLE ONLY public.protocol_mapper
    ADD CONSTRAINT fk_pcm_realm FOREIGN KEY (client_id) REFERENCES public.client(id);
 F   ALTER TABLE ONLY public.protocol_mapper DROP CONSTRAINT fk_pcm_realm;
       public          postgres    false    3650    222    263            i           2606    19065 '   credential fk_pfyr0glasqyl0dei3kl69r6v0    FK CONSTRAINT     �   ALTER TABLE ONLY public.credential
    ADD CONSTRAINT fk_pfyr0glasqyl0dei3kl69r6v0 FOREIGN KEY (user_id) REFERENCES public.user_entity(id);
 Q   ALTER TABLE ONLY public.credential DROP CONSTRAINT fk_pfyr0glasqyl0dei3kl69r6v0;
       public          postgres    false    234    294    3900            v           2606    19070 "   protocol_mapper_config fk_pmconfig    FK CONSTRAINT     �   ALTER TABLE ONLY public.protocol_mapper_config
    ADD CONSTRAINT fk_pmconfig FOREIGN KEY (protocol_mapper_id) REFERENCES public.protocol_mapper(id);
 L   ALTER TABLE ONLY public.protocol_mapper_config DROP CONSTRAINT fk_pmconfig;
       public          postgres    false    264    3794    263            j           2606    19075 -   default_client_scope fk_r_def_cli_scope_realm    FK CONSTRAINT     �   ALTER TABLE ONLY public.default_client_scope
    ADD CONSTRAINT fk_r_def_cli_scope_realm FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 W   ALTER TABLE ONLY public.default_client_scope DROP CONSTRAINT fk_r_def_cli_scope_realm;
       public          postgres    false    237    265    3800                       2606    19080 )   required_action_provider fk_req_act_realm    FK CONSTRAINT     �   ALTER TABLE ONLY public.required_action_provider
    ADD CONSTRAINT fk_req_act_realm FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 S   ALTER TABLE ONLY public.required_action_provider DROP CONSTRAINT fk_req_act_realm;
       public          postgres    false    3800    265    276            �           2606    19085 %   resource_uris fk_resource_server_uris    FK CONSTRAINT     �   ALTER TABLE ONLY public.resource_uris
    ADD CONSTRAINT fk_resource_server_uris FOREIGN KEY (resource_id) REFERENCES public.resource_server_resource(id);
 O   ALTER TABLE ONLY public.resource_uris DROP CONSTRAINT fk_resource_server_uris;
       public          postgres    false    3857    285    283            �           2606    19090 #   role_attribute fk_role_attribute_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.role_attribute
    ADD CONSTRAINT fk_role_attribute_id FOREIGN KEY (role_id) REFERENCES public.keycloak_role(id);
 M   ALTER TABLE ONLY public.role_attribute DROP CONSTRAINT fk_role_attribute_id;
       public          postgres    false    3767    287    256            }           2606    19095 2   realm_supported_locales fk_supported_locales_realm    FK CONSTRAINT     �   ALTER TABLE ONLY public.realm_supported_locales
    ADD CONSTRAINT fk_supported_locales_realm FOREIGN KEY (realm_id) REFERENCES public.realm(id);
 \   ALTER TABLE ONLY public.realm_supported_locales DROP CONSTRAINT fk_supported_locales_realm;
       public          postgres    false    3800    265    273            �           2606    19100 3   user_federation_config fk_t13hpu1j94r2ebpekr39x5eu5    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_federation_config
    ADD CONSTRAINT fk_t13hpu1j94r2ebpekr39x5eu5 FOREIGN KEY (user_federation_provider_id) REFERENCES public.user_federation_provider(id);
 ]   ALTER TABLE ONLY public.user_federation_config DROP CONSTRAINT fk_t13hpu1j94r2ebpekr39x5eu5;
       public          postgres    false    298    295    3916            �           2606    19105 (   user_group_membership fk_user_group_user    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_group_membership
    ADD CONSTRAINT fk_user_group_user FOREIGN KEY (user_id) REFERENCES public.user_entity(id);
 R   ALTER TABLE ONLY public.user_group_membership DROP CONSTRAINT fk_user_group_user;
       public          postgres    false    3900    299    294            s           2606    19110 !   policy_config fkdc34197cf864c4e43    FK CONSTRAINT     �   ALTER TABLE ONLY public.policy_config
    ADD CONSTRAINT fkdc34197cf864c4e43 FOREIGN KEY (policy_id) REFERENCES public.resource_server_policy(id);
 K   ALTER TABLE ONLY public.policy_config DROP CONSTRAINT fkdc34197cf864c4e43;
       public          postgres    false    262    3852    282            o           2606    19115 +   identity_provider_config fkdc4897cf864c4e43    FK CONSTRAINT     �   ALTER TABLE ONLY public.identity_provider_config
    ADD CONSTRAINT fkdc4897cf864c4e43 FOREIGN KEY (identity_provider_id) REFERENCES public.identity_provider(internal_id);
 U   ALTER TABLE ONLY public.identity_provider_config DROP CONSTRAINT fkdc4897cf864c4e43;
       public          postgres    false    3745    250    251            ,      x������ � �      -      x������ � �      .      x��[�v9�|��{���'��%H��mK^��ٯ�Ȣ,��=.ns^x,��
�%2Y�!*��QN˥��:��:/M=������;�v�ݍ��?zǁ[N��]"��%Z�""�����s#ת�K�����e�V��.��e����%H�D����RY�x��Wn���2_�<}�O�7���J����ӭh�(�]o��1�(y��z��p<��>=���ܓ�Ó����M�D����ԝ- ��3�#j1+�P�?�����;��u�@��.�צd���J_=��đ�6�����;VO�Wy���k*�=��Q�����z|B������?��L�|(�i,�l��D��Z�C��1*]�]���wLI�8�vv�y7>�,*���0�ρrZ�N B�Rn�A�t�p<>��������(�A���7�>� ]�o���h��K�5',�M��/�BO�5��ǯW�r'��6U$S���(]��ސ��@\����[O-�>=����ɟ���Zw����-���F�å0ĉrˇ����X/CPNm�w��Ge�t3�ܙW�9�~��{3��9�Q�>Ku��״�S_z	�T��>؅ �h$v-��xԉ"Z�0Q�(�J��*Zcc����7�pІ��V�>o�{ ]$w��KE��U�F
gWJ������7�Ec��Y^G���0o ���e�N�l#��F{�~:<��b��Wtj�c�P�2@�ye�) ��׹��)\D֋հ@�nEᑋ�����Rt�uK�r]. ���Q]_:\�+��:�i�]�>%�I��v��<]�Xq`rA"��9&u1jHQ*��їY��������k��M���
��<M{)�7nR�l�H�z����Ż���ꡖ���Œjw�b��,�T?�;�ӗg�ӽv��M�7�~r�Ɓx�~:m:�q�<A1'��z�:��~v�������������d	E��!��DAd��w��-�B '�!T|v�����8�_�����Κ!��F�ޑ

�'䴢���<汤��!�M<ca�}5��jFD	��s�n
a��Ze�k��.�.����-D"	b�5�ԜG�G�x�c���PL�{)7f�5B/����M��.@�bn���ԙ̇���&��FO҅7~K��YU��j1�P$e��s�g�<WG#o1�|@��gE���Y�k ������I�m�#n�8�҇�ڨe8��#�7^]��`�$�l\�<����YX<������i�	�%���5�j��T>�����-��N��
H���
�΅+�a�U� �3�~S(�,6kV0cv�!qR��~\�![�)�dѿb��yп̤���z��LѾ�ḓ�Ata5�f���κ�ը/,�o��+�t������j�l�I3��{�5�Yx�GA�]CW;1n�f(�g��d$�r�K�#UK���R,��`��.)6�V\S��,�h����n��4�a�o����3��༵%
�����7��<�Is���&���ܡ�r�j��Y:�w�6�����U�`�-��R�m!b�+�u��S)nΜ���lvϓ���`b!�ib�45�W�Q���5�6 ���χ�?�!ޅ�b��!Xm_�]>K*��� ���뚘�D��l��\��}��D���մu6k�b��O qlLa`I��_CPbf�d��l?�O}:�ø���r1&ZH���#��\0���0i=h[�J{�D�E�K�X6W�ǽ�Z���<}2k\�l��4�\�7��B�#b`�Ts<� ���s��E�	���H
�QrZ ���HF$�&z��Á����3���;ﲏ��7D[��W�(J�k)!�H0��P-��sR��r��"|q;��
A�V���ر}���������s&S�'[�zi�+ℹ!u���n2��#�?�3\fWТ{O��`\V�l�N��pl̵AH��8�;��
�
a�:���$��a�X�96�2���߃��$�
�VI v�]�Zm`LN�_yw�����JX�r]/�d ��z�>��_V/����f�\�J�2|KW��Z��
��������];��g�v͒.�,l�o��"��X`���G߯^n�b�;�+��G7�툍�y[Pj3�Y����[��l�U0�:Zv��!�0ӊ�҄����wҺ%��̴C#&�`0�T�X���1�R�BV����;�iL(P>�a��Z+�_�^v����D�xYpV.���	ƨꕦB:��_�]^8�M��UQV�)�{�6�'[�����|)��q1L|NBP�$�~�����t>;�hܝs�m�u�5*�fG �Gο%��6mfk�ǫ9����&�qb
�o���h���]�Yk)
n�d�	��1�Vu1U�s[`,��}uV�U��	��-��5w�7���W9�yZ�q��@W���e0��Vo�cm�أ�J6�aq
�.AbF��&�����l`��xM҄��P��FG��:'o_����?��$�o���$D焽UByX*7�A��Ε��Y^$�/6}��q�q��]���F����ʵ�5Z��|'fQ��/�O�cȉo��X Cc��~��������bG҃��ny�	d,굻��o�F�k�`������v�eG���+-��U���ƛV/�v&����&��m2,�m�`���r�\\L��E�1�"-Ιj��<�vhzK`t��I�FL���q�<z�\(2}X��m���X�Z^3�5�ړ�(a¸2+��M�ʠ1��z����lr��b���N�/����F7�{V� ���CZ����;��M�.��\.7B�
��htӞQ�貶 �/?������6}-E�m��`�A�	]�"X���?�u?l�n�b�'Ρ��&�qZռ �dӞZ�4J� �[<��QD]A �ީYwa�	]�q�o|�t�lӷO%�I�!�4�l}��}��&��hx7hK�~��K�N-�!���m������M�-Q���jp��l-�\���I�BB�
��l9t�ۉ�|��2^>DF=�o�_��ibU��UZn��M�g�� �TpoB�I�V���-n֫@(�j�|J��
UW)���R"J�_>���.@�Zn�&�eo;8�=�¥��a]cH:��%s���	䬪` G�#���=��xR���%��:� �l�����L��h�N�[q�<�qmܔ�z�ĩ��~1�cO(�ze{����~�k�Dr�d~��J����p�f�,3�(�I?�����> ���I�">�[L�|Y4&��3@ۦ�P�6}E�4Wda�s���O���A�a}?�~��ۅ���]v�(T�=r)$�P���[^���zJ~@:���,9ٞ�Ĭ��+����i��H��[���w�*� ��w��N���
��=a}0є+.X�dۄڽ(�(��S�Q�?l��쉫0@��/f��/6}����֖�#�/�5
�CO�D@�ki��X��{�6��o-1��G�&�V9j%D��������9��f��މ�k5? �RQK.���)EuRׄR�eW*����A���o��	�=(.W�S�1:�k��D;\'���T���f'�Ӄ���h������:�ٚ�
+l6FNr`TD?�@sxo�Ӑ
�����O6}���,cb��|mɕlr3`p5�h�];��YX�Dn'�-r��_�,h����Z@�ƶ��_i��
+���`�W4��3�\^������s���,A?�#h+��5{�&�*��W?�A�r�KPcu�wm{�vv3�m	�_�}�BЫ�rqa�a�u89@��{�S�]�.́&,�m��ɘ��Ľb��o[��N}w�9�)��d**�*.�%ܑ���s�ۏ�`6����ӐH�M�a����ƹ�q�v��:ڨ�S�c�,�rI�I.�An��]�.����"@�����q@o��G\;���'֤<�;?Yu_����;���戦��H=(H�
&��8�Xֿ���Bu����[���,���)�����⥫@�����D��b�
��x{|��;�]�F�g��V[��N�wp�,q�� 9�#    �������� Y`�J      /     x��X�v�|^}�~�Z���Q��D'v�б��2�r�] �0_���)�>�6��^H`9@�tWWw1G����ϊL��l���sm�y�\�x;�8�s�q������T�~Z�!��I�R,��bM��F^*�d�B�<��S��Y������ִ@��D�E�P�%�h>�Mڲ��?#�.��x�v��e[����rLs��3��x���g���vژ�2�ƖL�"�Q�Ͱ��NR@���\�~�������3�����F ��ݸ�]M[�����u�ɫ&��T�(ddɔ�TԄ��]�!�P����m����K�߼������w�ն ���[��pfM%uL%(_ɔV)e�Լ����~xyDr��d��Ҽ��d.��m��S�$2�����|:���c��{o����b�Rl��W�d2�gV(�5��	]����f?ޟ<*x?�۝�,l�c
��΂b2����dUjq�w���3�6;�~��P�4^�~8V�?:]�����Щ#��ޟM��tui64��^&p<ɐ�x���fo~&�vg�զ����u^��Ɵ��9y���ߜ�z�_�n��iK+�l��j�qc��lu@�9���I�����������ۇT���Q ��ˠVi�� �5P7@�씪�@ERڴ��G��9J�YN�yx^z�ݸO�<��!�����	�;���/��{�;JY������l*g�������L�9ZiM���7�)�%��}`I�o:��0>$R�Բ$�3s��\s����Vd��<��NY��h3<�n^f�{sdz���$�O����x����Acd���TrvT����$L�_1�6<����6/�ϯ�ҁ�u���{r? �M�,;�͑/Ҵ���v����q���z�n�
�:K"V�KΆRM��i�jߊ�<��f|�۩�Q|�<0m�:��#�#mp�~���f5W:L�uOu g*�Z��@�S��$=;;����|R�1�`p҃�s�Zvi_��!U"9aa]Ò� +�2B�s�^ڒ�ƀ�x�I���ZQ��O>D����0t3r�~z����ߍ�K�@������y+Z�켠指�Dؐ0��!�kC]���"�u��B�<>��ރ^��1��i�����u�6�*������ϑ#��X-� ���q;xTR�*��j!�SEE?��~=�L.���p ��^��v�fF�j�\0�-P�4��!�AV�c_�9(���;��&Z��ئd��_ �� �k�<Jʳ�~x�=M���c�_��*P��j@��,>�e߁b`�sIx�����0I˽S���QR�C`W���.�L�NyK�BL�JCԬ��au�|ǲ���	�?d�J��Ծ�k����8�k;�5���Ԫ�V�BA\b��`ar���Oǲ&_��*�f��8<���m&
���h�Q��Q�?v,FT�=�[k�L��I2Ԕ���I�˚tA��o>`LGF($.��V���9�UJ�8)H:�ذ/0�Y�l��%a`>ֱ<
�C��k���{�q�)c��b<KÜm�r,kH�e̥H����$M7�1�7fE��,_ر���AVP}y��FN#����κoñ����(������S���NFkk��˪ə���*�C?h	��PeAfy6_�����Z��ÂB�t2>&lq
K]7[F4�r��8�5�P5z���7��Q�H��Zc9�qD�����u���T���U�/2ow_`��YU�C�5PS���0GY��w��i���^q���ܷ|�����TJ��V�/a��`��ٓ'O���      0   �   x���KR1CיS�M�?��]ش�nj�����s (Xi#�I杺`@V��g�1L1c�z:�s����q�����z���dh-��!ghB�{Oi�Mf�%���ɦ.g�UZ�ZN�p���~���K>��CEҘf�
"����h�U�gJ?|PB�}��+֡����Y]W/���:��1�S-��(�~��'��Ӷm�+n      1   �   x����m�  ��d#�	���!�I
\u��Rh8:��{������T� nT��c�M琥�ǫu1O���ռ�����S��r�1{����$�w
Z~T�8� �$o��iܗ�6F���y���s_F[Ӝ�Ѯ�XQ���\��d��U��A�ޖ�����2��jf�6���u]� �<gs      2      x������ � �      3   �  x��V�nA</_�����8&�(�H�Y�zzzdX"X"����$�؄ d	q`{����kHS"��MJ�T6��2`[Ф��!�n�Z�����0.W��n���a�jjL�a�d����i�1�KQ��X9�x���m�j-��e��ǝ���63ţ	�@l6��ȐB�r0�V�Y�T�D��~�&�|⺝���O�;�gR^��~Q��}�4���<���C>i�y����g������|U�<S��g@�	��"�L��=�3v߮�����S_�Qe�����A.� {�.�sc��Y����a:�`}L�h�����
�e��1�����"�p4c��~�� �բ?�d��`���5-y��[�|�^�&T.�B�U�k�C�1�7�X��ZUS�	(Nz���x��flvZ���Ws�ܜ��"�VM�m��V��O^q?��F�b	V�E9H���>�S6r��/��1]\��w����X sɒd��+y2���Ѣ_A�e�E[F��@�����8hQ�Ų�tN����c,2�Y�$*�F�UЅu�h�"���+(8;�e�DcH,!%�&�m����i
���3c^��d]'��g�oj�T3 �,�]C�U�(�I��rq�9�ڔ�O�4�0�W"�UI��
o���JM�2!*�D6�S�+��o���;R�k�փ�\�9@
2V�D��#vi����;�+�0���AO\N���8����*T      4   �  x����n�0��֫KH��#��r��+R*����w�Է��_��gg�:9Ծh��z_<���Ys���6����|���yX�6uY����E�]>��tAh�C��	�3��9�8�8�td���i·�|ӷ��]�C�A�]hI[����4<ɻ+�q8��_|�
�x]�6�yR<a9����sm��l�Z�!ھ��-����T��Pq:.l		"�(=�gr�~�:�(}�ԉ,���J� Y���/,o)�� hM�V�L�;�lG���:�3T쎈\tN�&�B�9D�T��˭���SM��qP�i�&kɋ`�B�Kl�ú�q�7�o����Tp\+Q3^��V��1�z���/n�<�ア��Iѐ�qDB:_��x�ucˮ��y���1����b��K��?�\�+�������#�=��«B��z7�*Dַ�(�A�^�J�R݀Gi�PժOPu�+{� e���ʟ�i����      5      x������ � �      6      x������ � �      7      x������ � �      8   �  x���OoG����c{`1�g�[�^Z4�z)9�d���!�M�O_�,��J�����7��Qݦ���ХW>y��1��<WO���ާq�7�Y�]���P;Td���\�l�����ݯw2�����2��ǁ����<x�����<6��O�p"�09h�B��C�f�)Eߋ��2ɛi<��۫׿�3��C��nB�"Z�h��P�j]b�]��'�,��u���q��4���k�%�ލw�s�L���D90�z/5�ww����l��c���.d#;R�sւ�h-�ݚ���q�D�C���Bv���%�X(];2"�ޢö������Z:|�Tz�Z:hi��x��6�u��-�F7r�t����Z�&��}X,5Ao�U�����2'NG}ٯ�ٟ&�0���N��i�����Ru���i���U{\m�\������o-���8o!�N��AڠU�s�k��}m�����G�ӑL
�J�`������<��Õ!���S?���Ž>�RS���R��Ե�!�^�d���N���-���{ug>���;*�(������.{�Y�}��E�r�^$6����1@֩�ʦ5���F�掇S�U�x{��2C�M3PZ.�+u�)�b�5��N���OhY��k�p'<vU�D�*��A�J������p.�,D4NKu���B+���:<�I�8��|��jm\?]�G�*-�ǓSO����=�?�L��v��Y�Q2�}e�U��(���P�CXtv.��κܬh�F��+�����Q��Y��1?:&ŎE�S-z�T`���5����_%�%拷1��,��瘦η�	m	��_g���/��E+8�"�~qE>J��3�?�|�h��4�t~B�k$��:К6ewf�*^d~��*�%D_t�i=Ŝ�q�Y�*9���-T|���}b�g����	R]�9V݋����F^b~�&����I�.�o���®������/��5�O�5�=��I�n"dta��*	M�4{�����̷Lc�I�%�j)���dH.F�0m�ϙ���f~q�d�.ҾZ
�I�B�;nL!��7pk+�BY�ן��hZ�����d[1`�3�7����/��kp)����tNK�ёm��1�::l����h�{H�(G2`�73k�0a�_3�χɦ��󻛛�� ���8      9     x��W��#7�Wߡ�����l�N�ڂu�B����[���͒�D�SSEvWW_Zu����!���� E"�H���ݯ_�M���S��p9�r���~��U��+��e���?0���_���o8��_���z���rK ���DtN��:���g�0��[�r��rҟ����T���2��GjT��P��0�m���#v� W;D��&��`�`�ڋkS�K����2�']���x��W���޼�i�ߞ؅�S#�A9�{��{��cx7����~<��Zg�!�3�� c�KG�І�~Fv�Cr@��Z��?��u�S�ym��R=C��#tj!�,��F��a����X��6d�Z3�$���z�!�Pz�է��%���j�x[K�߬cC;� *j�����	��kk֜Z��|V@�o����]\+U����\J�9*ޡ�T��G�z�Q��<�
I�t�ͯ��b�U�9�u���h���'������%	�� [4Qt�Im�(ڨ,4 �T��T��:����?�ކuz�P���2&WFaֳK�I�����~?^�k��Nn�h��ȱ��&o �YZ��I=hs���yj�+�J\90�0�`�&^' ��ϰ���O�~�3�K�ϥJ�yfA�	��MZ%�-�{�VdD� bVH#8 T�<���g
�0^L\뼶cv�7�!�T�ӆ�i׎G$&_�m�0^K\ˬ�Lɫt�KϱY�Q�r-��jY�k�&�%��:��(��̐����h٦F��Ԗ)��2�<J.`����Ym�T�J�6"��Zd� �m0�p�s�~z_K/%�%��RiAh�
UlaHϸF�v�X]�V�U3���,�|W����99aKj͓��6�\�U(�:F���SK V}��,ҭ��c�f��M2%��%�T����Q�;X(�z�>>�+���l��e>J^ ي:1�D��'-,���Y˵�s /��4^ ٺ���fM�����ɺ�rte�&L�JN�h�3�k�܆�����?ȴ�      :   �  x���ˍ�:E�qw.e�OV.�������a�����ZT�iՙ�K�_�V�6�kV��|N��O������5u�]��i�ʸ�ܾV����o"�4j+V�;-+�?���Uc��m���
}Z>�Z�e��{���9��¨��f_g'���"�cH���
��hk�^�:Ŏ�G����Z����̽�B[}��[��{y)��F�s�w�I�3m��F�ۻoZ��Ӷ�N�3����y��]3�j���?�5�3-c��)����O��<�򵢍��Y}�{ߩ�m���<a�*�J��|�j��V��Ϧ���o~�X4�>]3���Tb=��[�Ҫ�S������W�:��ީ�R�!Ԃ�Pb-f��!Ԃ�PB-h��!6��jQCc�ְp��Ԧ�OPvj=��BH�"-j��!Ң�H�"-j���!Ң�ЬBC��ރߺ-ߦ֍ڢ�Y�<U�wk��PB-h���!Ԃ�PB-h��!Ԃ�ج2C��cl=�nZ
4�!Y~-�0�icQC��4�Z�jAC��4�Z�jAClV�!Ԣ���5�gmV���My���Ne��!Ԣ�H�B-h���!Ң�H�"-j���!4��iACu�S����׵�w�����|Ϯu��R�ݚ���_���к>��n��һ��n���Ggv�Ǖ��-����+j�]���6�Y�u�G
�7�+HS�<t�#l���x��*W֢����Y�8'��:n�u���쥹�/�p�/
�_��+m���Y#���t�䏵۩-hTk�i+���ڸ6�^�-��tGX>4{t&z����A�C���`�ڛ��s�!95�x�Z���l-]�w�zi��n7��E�pkg}H���vu�{����4�W�ǮSg7m�]��:MG\Is�'�
�[KR��w�sE��Zۚ�2��Q������M��bC��4�Z�jAC��4�Z��/f���!Ԃ�v�ZSV�=��яԘ��vZ�'�w�!Ԃ�PB-h��!Ԃ�PB-h��3�Z�jACm��j�g
���OLz=������9�Z�jAC��4�Z�jAC���b�X�B-hh==�J�6vײw�����1��B-h��!Ԃ�PB-h��!Ԃ��|1C���4��O��e7=��z��Rd�GmQ܍B-h��!Ԃ�PB-h��!Ԃ��|1C���4�}��s5!Ԟ�Rl�`]]��}ˠ�PB-h��!Ԃ�PB-h��!6_�k1C�������?��{      ;   s   x���!����l!(b.���C�}wUWW[�����@jJq�����ɢ��A��\�w�t�tk�J���cw�&/���ȷ%�cC������#e��iU�`����m���I&u      <   S  x��X�nG}��B?@a��"EQ�Ma��[^8����U���}�VX���6��m�Yy�<�Cqe�m��M��|��CMU��X����x8G����8,Pc�`&ΰ��L���A]�RTǳ	�ܛ���g��M���n;�aM��w�_w��Ǯ߭���������v��7���]�����aYS�ZB��0�s$+X�%�,��1-���A��>����u�:[��/��¨k҈��zpVF�@�e���\?�6�կ��y�}7`�L�9�6��͛LHml�PZ�@�TR�E\��/���a�s��Ӽl���b}F�Lh-gɝ��:�{*T8���6��a�ա?��oV�q�����ݞ'��G�����?�����N�mRBLԐZ�@�$BY����s��|FG��7x�W̴'W�Z�B��#�9(�`�",�{K�>oļ#���dTZ7���Y��X��h�()�d|~����-rPZ:Œ�w�hm�j�7rYź8׼��h2�˥�BY��N�綫|�v�_�*������I�XސjWe����;���x/͞'fߪ��R�H]����#�Z����x���k3�å�3���6�
*y�G-J�3͂��r�bV�a�_�<SMXrF�I�vT�(��@ʦ�#F�n�y�i�#�nNBı?�n�HY�;_7ֿ��꼞�n̍}�"ל2�J�udEF��x��6�j��kX$3΀'������Yԛt��jD�p�
j�u�Z(:K�i���*�'849�9ԛs@I��T���j�PS�B.��駩7��,�M��6��-B1F�9��q� !�P3���h��s�75ք&ˬ"��$5�5�+G$χJ��GC٤�_h(�vOߤ���'-t�2�8#�>)>�Q��f��߇�IN^n(��1�1�����#�\���@��\s�Oe��<�P6[���mX�#C59�%��R�1Ӟ�&yy��l&>lU�X��8�T$��I���t0�"էy|q�>xiJ��"�<)Z/+,�zy_�慫� �g~9�>���me�G	��,�"{�\����[���|bSp���?&%O#���+v^����П����O3�R      =      x�ռYӣ:�-���+v��o.�i$����a����>�D�@�7`��Q���kժ.k��sNVĹ/_:HS�s�9��,s�"a �yD˄��0"�Ae��~�� X^�I�Y �1r,	L$�2q(�
��ʲLb4�=�EuC�/};��|(@��<� �D�Qx�g8,�0eE`�/X�,���2���� aF!�D���L��}�%�@MCZ�:�31CG�G�I���^����+�E^�"b6��aF�Q�D,�t�q�o0�}��CO~���(�P`P(�t:��#.f0')�$)��aG���v|3q(!!
eqH���A�UV�,1��f"ʒ���/�$y(Kt�<b D1#cD��]"�Y����uI�2��_{�@�
1G�6�K2���gBeA�D��6�.E<�e�u���W;$�8��G|rJ��H�� �I�D"���@���~�[�b� ��h���L�
��XB"�@���$E!ĜH��vx�B
O C�GR��bHM��"�Q	#�1�Bу�<f#�����@�8�0��C��2�dF2E�b���32	R��c���Vhn*�B�R�D&��!�af|��@�0���Hh,򄑕�v�P_S�>����F<���+����Xb�����B0���k�?���AǄ0��$H���F�(�� �
'����7�!�B��ZECA�t!CF���$T��!	���o�Q�	a!� LC!��bB��!��U~�,�,a%�C.��7G� ��\TXI	cE&�|!�帘�)ڷ,�L(J<ó���<T���?�"�	IH/�O�ß�!�l0��"��eJd�)�4aB&bC���<��DeF���³�WX�ĘQ0��1-�>)�,cpl!� (|���t���0��eFbcL��sY�����pV%LK��Y]��<�q����(��B'�Eq������.0Zhi^a,_߿��ڬ��@[᨟#�|�Z:e����Q�G�a��E�PhEeh�R`G��iB�I<�a
��i������Neb��s�!�� �	�B��2,��)�h)࿯�"�_(T�����?��1(��5RX�O�X%��+�
�)�B+ǀAD�d}$I"D����#QK�/-rњI��W=v2�Qg=4�+F2G95$~,��-#^�ęei*����_b��,�)�!)`��0,3�roZ9��KD�*���䋩��Ǽ^�7s�J�@��ݨ�*)�i�i�ȮT�۩�1my�ط�oۛ�z�oW��_�q�F��{��n�����ƃ���/���ƄA�߷�$��TYm}yj=6����*�W�Q�\?��N�[����9Y����mP|4۽l�.>x��<���u���Dam7��x`��5�MU��^
*nQ19�u0��2z�w�rNi��n���=�y��G��Y'��-��|K|��ϊz#Z��<��kl>g!*xy�ܓö:+�n�Ǧb7�VN�>QE�0� ���?��|��d����X��mwo�Xy���K^�;����-cR���{�����v<�����k�x�R��7Tr3��'Ip��lm#M�kʯ�6'U���+M/7���7�����\�����P���Y��=�luC�~�n��X�s�����	�&�P��ي%R��G�X��Q�kꡮ K�m�J�A���In�PN�5g������t��:���F.)�[��ܮ4�����c�T���?Z��i��p���{و�z��:=���3�+���Ur�E߱B3��im\N�})�	���g�;�v'��
؊�a������&��ؽ�w]��},Wn���n�_{%~h)��T����o*۾�]���!�� ��k�[��I�R{KD���\ޤ{����|Y�ƛK����rwDsU���Ē)�R}Ls[�FX�#�}i]��ב/]�*�����c�ÈQ3!�h�H�(
	�}_���Fqċ�Q�
mV�h���H��(s�w7���s �m�f�zXӈSR�q�[��+Ġzχi�	�%9�Y����������S?��B8�{�?y@Vڑ��y��ͩZ{��.A�>����Y{viP��R�������^���t?���ܸC\͸7}�<��Oف�qy��j��C���:/'!K�yi���:��CpX�1w}�����l=h\�~q��W�7��^)�1('$��I��������:����'o.�H�Q�J�wis��Ӽ��Έ�cY\Vm���x�����rŇ�ޣ[ꭒ�|9N��8yr��d�!�y��f���{���F�����Y�6�WY�3��S|/8XX1<�'Np�!�?1oR���N���y�6't�H_{v0>����VkH��C�(]���k�%�l��v�RƬ�&��/d��ѭ�" K�aw���j��~�~��/Sʲ�$��yan��i(����� M2s��β;����*ٸ��{�&��=g�g���Q��M�l���H̫�u����&��k��{Cv���^P_6˓p��h��l\����;��x��	�ݹ�VL�{�v�9�E��_7Y�UZ���Ve�	�9�/�g��w��;=|;�`�T���T>@� GΝ�<`������ð�2��кl�&���U���UH�����p�;`O�g��q��s���q�܋\���]�'��[}S����8wͨ��t���[�
�q�x�����J%��0�N�����Ձ��6�I����"uu�3|�C�#���_ʭ?��s��)�i%���݃��K�t<��Œ=5/��n4��p;h���u�n�xz�h���x�\������f�diln�ڋ7nlg��`h�����cG�U);	���V1�M-�e�}ẌԵ�!+�Y����բ����ݰ�#�뮼� Zu�U1�.��v��kz��e%��[��J,���7��<���R���\����_/�H<��}�»�ˑ�gr���ET/�ݲxG�e��J��\tX^C�g53�\
o�5	:�j}����0���������e�a���uM�<�6<? �4Ӡ�I�.v���[|v`Os5߻��Xi� N��W�d:�r��w즻�uk����*^���4T�X?/m�a��Zk�>�N�U���g�;�H�9_���Hd�|�ߜ�������h���f�[�s�)��>�\��P�$��^�!��g4Ǜ[x9-V�%\ŵ0_g��C�d|�O���-�G�$�:U�nY�\8�e�ە����l��Y"�,�D/�*-E�`J�yI���Ƙ�ǈ0�$P�*
���dd"Q/c����#�J����T>|��0�w��c���g���Co���l��o����u����7�V�����GI��֗���G��]מ�g%%�*��X��,�t�,�r��4m��g]W��:�6{���%�]*5����1�^�{m[s[^�6�U�z�?؃>WF0�`�x���*G�gi��d�Y�	���(1 �T�G����gN�Ǘ�r��(� #�ُ��*Sx��d����T���U!"�ʌ�"L��L(��c���k��(T"*��KP-���B��
�G��A��z��L(Q�$"�YQ$$})������g��qV���΋������u���������������������)�������_�^���Be�������$Uҧ�O�������~z������wi���fa��D)jQԓ���瞆��mU�3���~�I��O���4�}d]�k���������K7?����Dp��=}�1�=�m�@�O��Qّ?��/�&���d�?�OF���?��7��u��nk��z럻�/�~�O����+�]��Q����z��㡷'm=4ߤ� =�����oO( ��:U=�|{}C��͚�X�M�_��w�1�Y��GKb�\_���w�����+ "+)b �;� e��D�) ��2�T�FJ<`�L>�u�"�YZ��/�F�:Ϝ�
`����*���g�x?mv�"N���+%h蝊�d�o�@qi�w`9�ȫaaL��ê��ɏ(�c[�����9T�fs�Lb8/�q1�����To�    ]wjm�w���=��h	w�nba�q2ǵ"\��b[�|V�H-Z/�s4�S�b��fuy�b��%v�~u�Q	�"�����,hR�Z����3Xwղ��Q���l�\�ȗ���B�0�8��dGy�h�{~�b�*���e�͖%δc^�FI���v�KX��������:+�h��t[����ٽ��r���>�Z��]6��β-$�>��\X��N�S��W�f�-7�e?�k{���׷�Γs�5F=6�bB�0��U��qz���m�mS��|y��e�{OG�dom<������\�SuY�[��A������?2i�?oi��mR_�mpoF�HesK��5��N;~�u�;�}i��\kY������%tV!��c���$��K�6t�M2�S<l�	��/لo$r.`-�qaD����}��b�΀�>�5kO��Y8o��e���*�zSx��'������Gn�'�u�^x�/�&���v�Q{*�&�p�)��+��iLk���1�t��s��V���m�&���jY���r/~*�8�#��ej�R$���(������pvҼ��X�������#��O�C�ţ��4�.���׻����,�w�ZCX�'g�o�@��7ej�(Q�lS,�f��Iִ�v���X�~���(�Ku���&�k3TWwv�Xk˪�����I�u���u�7֚�u�hmjC��Nmrm��!���|����H�Gm��r��-�oA7��UL�y�|g���4g��h�7�������\_�-"V���(]�7��v�o��v|a?E%��
���R�Z�
�5���u�Yi�&�4���_x\93����ȣۼ�vj�e��Y�<�� �g>���-"D%PC��y`̕M��q��C���/��}X�
���j�����m�'(���P��:n�y�?��V�vO���xk�+�;�"}c'w_�n�p0;���koZ���j���:4����l��r2�|6C�p4 :+�p)B턦�Ʉ�2��~��(�/x��1oz-���ܞG�=�k<Ȳ�Ӻ�&mY~|&�9T�]P�#)�fY��a=�닒���iܜ/�8ЇF?��,Y�x��H�����a?�#�r�u�L��ؽwFSQrN��FߝN_d��a�ϛD��L(�� i���W��Ū��u��^��=[ܯ_���^z��rY��V���6��-v�)�l�&�_˜;!-e��ys.'"�J[l
<��nX�O����ٿ��s
��p�x�,�(5唧��r��bb.�t�(��z`�{�,�N��TLB��|^m���ҫ��)���;���̪o�ƍ�ͮ�����']�\��+�vG��59�_Vw2�c�zŽ���^{�cj/�l�o%z���K�tӜ���m��+����5�e{<=_U۫��藣r��m89p+��|g�4��o�E��u�_���ػ}P�Җ
{�9��%��yn; .����e��X��N�S�i%��J�|�X�+�� <_*=�e���՗.^W%1v$�3�G�
�J�${��.�Jvz4eaH�07�'C�S9U��	�.ZuR,�Wy���K�n��Ȇ�_M'	j��U��|���K�&�\jD"��"�>\��==����x"\1�'JVT~�����,䫵/��ֶ�+n����5ZTs�v��v_����LoIQ���Y���ɹK�K�tq]���0����2�x)��Lb �jVA�����q2��K�?��o��WITD1�&��� ����$�a���ѿ
x�2'u{�F!˳<mRCۖY���C�%Q&!�N �����#�C�6�ňQ>/[y�B�(!���	��T���d���6gdN�bA�D�o����?�(������t�q;��M���+'�~j�8���78�3Ź���޽w8�%ʜ����kחj�	{IVcs��1��\.����vHd=Զ�����b�w�{��cؾX||��䴰^�N��j�?5ueU�y6Mg��m��6����>��K���ZSg�^:���(����qTwEYp��~�k=������ŭ��O��oM�������F6���v��6������t����n�]��	��n�
�Wd?��S�.=��e�|y�/�7뮶p���cӫNy�o+���o���Z>��r���9�0龥�01��A��'S'�LP�%�m�C�=��%��%�ݓ���b��^�s�A⾲��(4�ss�4�|�>��fQS6�}Ԟ����R��<����G{-�j7,{�lF85Vy��jOp[�{I=�p%PA��N���4l�w��Z����$�s{�a	�Ҿfc�wu[���Y�Ά^��кx�Q��/v�_kk;y�R[��e���u99	I�mD��qq�^3���}�zwoZ�V:^<JM���U`^�<H��-[˶�X���h���kz�:��������B���9��א(+��,S��eF�x�~B!��^�}i���Q�*�������5�[�;�E�T�X���X��wX-�/���y���֦�8�tC'R+��?%n�wzT�i~�6�<�VdqWm���սK�<o���W�e�H.�tm�����~z"�v�K��N2lȘ�\�J�q�<g{����qX?^�����b:viZ�Cे�S%,e�+|�%&�bޮb�b�W'π�Q��5�ݭ��7v�Y���4ٖ�.I��@��U�����?���9��`���4�F�P�ʃ��k��֯����}W�˿�m���S��\��[�*L�Z�\�Y�pq�N�6�����e�0�h���,$�����§a��8�k*<�g�G�Z�>Han��|�9�����Xҝ�mp,������ns�&����ݘN���4m�]��jɋ���*>�T��b���vV�n&k�{�Rx��"�f��gε���[��\������-�����$�V�?��Mt�3�W�3)<�g�A���;{ހ������>	���vw���Ѹ'{���Y���ݞ����������e�����7��sS�{����f��]�~����?��J�d��C�}��������_�%Zʋ�����U}����W�Mۊ�9�߫��<.��˄J��jx�Á;/�Ǆ�N��%��.�^wT�a��-��/���N��1�Y7��L	�c�m�V���WGG���iC�@Z^`\J#�D[6��R�~s����Kw�v߃�}?t��Zw]ͱ�ݮ���r�X=���d����D+/C�(W�?�Q��QyS;�^*�Sz=�Z1u�M�Χm�������q���^�"���8d��s�̯�Ci��K#�[P
CC^wH�gi��J��1,�lg�.��/�kp ���Ɯk�N\�E||���=o&;�wu��Ms�)�w�c���n���Z��GBz�vm9m����NS���_�+/�`�\�`�mb,��w6���5�%>I�}��}2���=�S��-rȯy��bc�z��:�2'٣~��ے�`!���ܪ����M!.ʧi���)����;�'ID!D��H�������s�ʧè�sR},��l	F����H[���W�;޶��jɳ��,�]����<��8 
�+i��+�ǧ��a]?���vYvf3:��PF�fBw�[�?��K9;��������w���_�M�qϣeVpt�{l=�����0h�}�?|�@�@L�l�~��`��6cE�x�����_�lDo�DJc?�`>��x�T��!�rpQ���ٿ��#�X�$�0<m���22�e^���Ţ |�Ø�p�2X$�ӳ@�B�`cNIƄ�W�l�����K	�f��b���y��(w�"ϯmz6D2�S.y.��zI<����:9�0�o�}�N�~��������LVoV,���u�u�w�x��r�2�j!n�.yף���b���\I���0�-�P�FK����]��#]mXu��\x��?���o�4�ҝ�˶a������v��[pMG6���u���Zv�- �����,��*l��i�*J��q�Y��Z[����^֦|�Z+��ZU�#�mI(O$�Y�i\6�j��9�^���q�/	�!��6�|�-� I  �.rU�$�].�S����5�氍�z�,���/�}��Vy��b�\���[R6��u�[�s��r�@�t�:=&��.}c���x�je�Tz�Ů�HD:�n{s�ͺ����l�x�����kb��*���bn?�'��Z��Y3R	/��N���X��q8]�ͣ�`����%@n�L��fr��qʮ���li��[��ʹ����09Izʔ�n�Ty�(F8*���SX�D~9�uy��<��n�	O�c��O��Ok��b.���(��+���s,S�,A��Od��J��K󿃤��X%D
;�!��X`0�
(��
�w7�߽Ț�q`s�t< f2ɠ�쥅:�D�I�9 ���۶�h<*�8ٳa��f��c�؛K�G�����,��X.S6
�nR*h��l�L[���� 
�Z��g�f&\(ۨ��F�*|a�g�8؅��v9��ڶu�[}�-m��4�}��y�e�yQ��J���{j΁sځco�Еfn���6k������Q�i�}f��ȟ�Vv��z��=�d|!�^I��س�9of4��X_�w8]_�Y����χ}�E�8�%�>��+	\��7�[�C������N~=�5���Ӱ~T�'~���ׇD�GR��]{s}���6��ǳnpgy��~1�t��1<p����ԟ�g������wY�l[�|��	�[�a�mgWR��J��}��e#���t"�W�v}���i��K�v�>�߶��{�����Lq����|N2���~�����ߒ��˽��88�TU�5�'�\�L߮���Y���~�I���pn���$9L~��o����~W�J��Zs��I�F������1�ז�;)��Y���dH#0���a��iO�/ӝSg��w�n󼣮5Uq����&���j\��ޏ��37a�Z��XM��|9��.�XujO�4v�
��Qv��ڝ��i��"N��4��SD/|�G��Q�γ�����ٔ�>=�˭����4�Ui�8�O��|g�{�I�c��nq6`���4�lz�e�;_�q�~)YH{*�u�u�9Ɖ�����G�jO��boՈ�A4�4�t�u(__�;zd�v�j��Ç����o�:c+��m$V���X�-������Y����c���\�It;?BϞ.5̹�k�>����c��n'��ˑ��n}��ւ�ʭ������`�QZ�h3�ؕ��iB��r�x�n߷�漷�GV!�;5�G��6�,ݥ�'%yT�֕�����y�eo�w���b���}_��${��y�����,�H�Y�8�$����K��/�}�%���^8�>��	�I,$/�3���h{�C����a2�}ll/g��}yDЌZj����bZU�S�ajѨ���]�\�Fh�ϋ�aq���"�۽����E�H�c����k,�<��-֪�a��˪7m἟����GU;�v���/�tH� �F�l9�R7r܂VZ��H��0*+&QĞ��ָ㢲���x!`�9�^�t���5�����x{'��k�yLi5��s��<#�<%ނ��T����}_%�'��b$!J�9FA��T8)�g	#�$�E�9
���YN�")�(3/)�Xj���:8���/"b�����t%�I,� �0X�!�B."1��~8E0�1����6C6�-rQC.�V~_�W�Ő�T��L��ؐ��g�"�dQQ�g���?�^������r7�h���Q���j]4�Ν֪�U�?2���p-��*��ݎaŌ�s���9�M��U7��c-W�����Q���toF���P46�ٸ6eW�V�(tǉ��b�6Z�d�S.K6���9���r�n����]8��g�|E�މ	#���$0�F��D�ąC����c�@(��z�H
��,�k4����  E�ٯ��E"�Bz�����R.�D� ��_�8BU`���.�sVEF�y.FATx��%7(	aH$��k��6$&�9�#�W>.c@�&���96G%&�%�4RO(���.�����2�&ԣ��5=֬ �7�W�}��Ɵ�f<�|6M22��b�;����9T>bB�t��s��>�}�a��Z�"A1�!@�R|�nB 3���"'ɡ@�7'&)�����W>gMc��0)f8^'�)���0�]�!u��Y{��
yʹ%�ʔC@��=Y��3�� <%ӱ�}�H��
��(8�9ᓄ(�l�c&T��yF" I"���s�'X�3�p�� �#�A��0&�(
���G��?��h|s�N�g�Z�!�,Q��1������s�D�7Q�`~VW�'%b#�U,�2�*H�;�o\�p����Y��sj� �����B�A�ɏ��q�_"��IP�G�����.��I�03�9�O/�B1<E�����R,Rt�������|7�:Y�h���2P�Ѐ��̅zc(�?���8aH��@qB�;�@I�B��z#������.e<���� Z���*R"�y��c(��ii�c�"�?�D:�~?�9�(����^��σc	�SI� ����U	q1-,�%n�,��C��<8�XZ-^�p� Y�7�5�bI�E�>}�rH��4�dG�(��ӈ�i�E! �U[�S�i�s1�#N����8fc�4tp\�}�6�2�$6dDL1����G����i�)r3�(R���򘃌:�
�����C&I��;P"!���H�#�
��,�h�N(��͏�7XF2!��jA�� )��h�bL�+VbJ7�6���c�cI4�Y|~���i�R�i��0��������
��1<��5(�����A2B|q��������O�5��,~���J��1CJt#Ls��7L�?�����_�~�� Q�.}      >   �  x��X[�$�
���'l�y�����_�U�
3���TbBTWY�Tg(I�!�Șo[�[[�o���٨�M�9��ly)�����/Hsu^�u9��dR��@�u�Z�7��#gt%<tI�v*�Fr�s;��7��[�K��Hڹ@��u�\��i�9�j�0���i�q��=|����s�$w4J�$��{�/7}�Ϟ���:�3��v]He����ސb!?�;�2��byk@J���G$�=��)_�d&e�Eq�w����Rɰ>K�zKd\q|���G5%�c��* ���p�=F>���4�X�[tD�d0���Bg�c��}h.3:}b�F�&4Yx���ߐ�=K�8�����F�r�ig?v��J΃�F��:�x~��xW�z����݀�?�I)}/:�y�ӭk�#���tphAGt?�ZvZ���z�q<�O�<�m�'��W��U��6�]���%��hT��/�m{i��9��B���$ǝh'�Mm�~��E��j�������9�5�/�ޯo�)78Z�{��9��r�O�(}*��$]N�-��Z�0�2�لpa��9����?U;sVg���6
;>-Xs~T�B	��*�7^?�`d�/`b@I:�32r�ٶ��hoy���Q����G������&=Io�C��$��ɝ��g���$X��9o��
���ޕ�↏S�%PJU{~:��-j%�@�%����T�����/k%�R(y[q5�E�-N||*��5�&�=��6�RXv�<q��X�� <?}
�ǘ"jP�V�2޿,�)�2,�i&񘧀46�k)(
b�3zcY���HM�[Q,� Z���� 
��:\���pv�Yj0+8��.d���L}��x���(�݆��~u�pO~װ����6��*��
���ykM\��<�n��B�b�P��OE�eⱱ־oH���
����$�#{^�~|��X���"p��{9s�z�t�MXӎP�)fsz��o������e�O������
��5��v��"il�t��?�	�\.�	��{i�۽H�[Ɵ��nW1'���x�^�^�ac�mu����ac`	��:� q�/��S{C�J��F΄4�_ώ�E�ày���$���􉁤\��e>�(�!��{t�P���n�ha�c��&��v�s,�ܴor���_�x���3f�!���C��\_�{`�>�֭E�������?��8a�f���x;lq�	�����>���P�5��v�V�՘��9ԛ��Į�x�7�j0^>�n��++l���UMY���	�Rᢹ}�D�,&�L�G>�E����'���pR�������t�57��og�0�	�f�wXk�	Z�#n�����3�<��z���f��!X�!=p��9p��{dA���'���/�
0Fx��|�c�w��B�~� ��9w�u����V���d^!�5`F�t$j��?���*8���*�������v~/����S�^D�vOy�9ׁ���J��O2*����C�7[�F��f2�����:�t��������|	�����1d��i���B2?���%���f�����<~�R�ɔ� �;9fp���t���3O��o?�؅�A�]펎��>f�M|l��\�/���޻]F1���b�*�5l�?ai$߀�$�w�s����~���f̍�      ?   �  x�՗�n*�����۴�Ö��<%(N��Gf*�����&����y ���*۔>���ˌb�� ��(�S�	��LP��~�ݽ�áH3w�,s�0P)P�AW�rJqwHP�%�DID���,��ݗ��:�O����^��u���p�k��Z����h���x�nu�o�_J���*�M���r�եaa�����o�ڹe�Lwz3Й���g���?��+��B���	1����<͖�bw��<�����������E��J�������4�8����?��y�t��1��[��Wr���=7�Y�_������߬�!���
�4J���B	���o9*�CPI0�(��Y&�4?�K�$R����&�T;|M��X�:{ZW�&��f�9�5��27���N�]~�>�T��.���i7�y��@H����"L��Ie�q��]�'
�Xhc�h��b� ����I]�A_N����k�m�Y����xwzjv�m��������V��맕�d�����3���k�v�nv�.�<}��N+`9�g�A�pdƈkJ}��\�Wj� 1Ac�g��o0C�P'������0Ȯ�߯���$�ɺ�_QO4j4o�=���zm3Y/w���z�zA�����x�=���|8QbLַ�<R9�M�@xa"���L��H� ��3zE?(�(�As !u�YmQ|��?�ȄD���t��v�����?�7���+����4��>Ok�~����'�|P��|��|Qn�������@���>���Zh����#L0%��׮{�,=X#(V��F!�S�@���c���_n�Jc�7Gh������ �SG�����K���8�]��Z7��~U����W^�ݴ_����hĈ�FåF�ܷ*��3�#�(�W�T�Ψ�(UB1�E<� -2Q�D���dH���B�M;Eh'|Ne�8�2�9Ԓyo��-p�<u��72I�d��O�����}�HYo� �j	(�N��	 "$��
Y�<F�qH�mTj�:Nt8���Q���K�0���z��p�7���@ݑ�����g_^\�徟��Y2����k��\�+^}�&�i@]Ѭx�������b�((���{��$1��Z	�(�׮K�ք�?w�Q���BT��@��ș���?)��>�C��}?{�?^��#e�\֫�q�,��	�.��?�"�I�O���~ ���y�^m6���Y��`��l������/ҌK��Q�p4\�*b���e�����?���4�e��^ﹲ�{�P����x�w�f�S{�T��J�,�Zf���f�x��\���}�M�6	�t�E�JF5��c�o�p(t����h4
��R��\1�E�X�j��>�3I�O��>t�6���a����$&����8�j?B�6���"��뢾�/Ĥ���r�߾����o���s      @      x��]{S#G����S���z?n�"�1�@���"�z�h'���OY�TR���=_���Gu��Q�������=�ݙ�����G���O�.��_��/�࿚�7�-Ά��������~o�n�_�u����>@|���;M�$��4<�����"b��,��Dp,cXE���[���ބ����6��������p:�_O�N�ד�����?�?pt:�O�{}9�����*?�q���b|9��GM��0���tc���AQ��y��>��+�#��h`Ο��d�-�An�QDR�N>]O�Ap�()��\���!k�g:����\���߇G���zy�QL�b�YAW��H�����k�u8Z�#�GOU��Mx�dVǨ�W��IO�N���{x�%xy���Q4�`��c�����r:)U&6��o�n缾��T.���Ծ�0R�����!��TIC=q�yl����$E�X�;�nI�]�����x�c��tt6|���Ư����+o��Iq�?wPO^���av��E;�TQ¸嫴[�\�Z8��&�[�I�
$�wڏ�.��Q��x:>�^���'=�]��OF�Fw�h/!ՙ��7LY!VM>g�r����ND������j���>-���k�h�, �)�B��$)���Z��\��:��
��������&�#ĳчʬ_����t��a����]_�E@M�]H�s^��U�-3�q��ћ-�2
o�"��BjR呿���fn��/�v7L�F�Ы�G{ĝ�#�-�ݨ��8�:j���O��԰��?l��J���V��F2�fB��UB��JD��`�<O�c�ǈ�"vOQ�u2�/�������g�nd�I��H�3��9Ƅ��a;6�;�TE���tJ��j���rz8������1�,�:��*����� +�(%�q��`"s�sf-���4I�o�nx�d���̕&R��\F��Qj@�`����4	F�븘�b^��� @��z�\��%�8��!0�I�@T�+II9�k�$o2<<=� �寞�^Ki�i��ONNG���>��y�<�S/�[���)|����fv���%���H����/>�UP�����~�)&N���Ug��"rC,��#)f�bX\D$��BjbM��U~��|�TK>g�6*��-�9CLh�āpg��Z��/���%]Q���N��z�Ӗ�kTtcaԿ�F�:>饜{���l{�j=�^9�UD�ĂVi���Kd(������ה����!
j��� �U
�sDq�^;�0�Ty��/6��d|u�d|�_�f�t'���LD5�%��4�{5�lx�~8��8j������˧6өkXn2���׭?
����6�����)�H��{DA�C\"#^��I�㩡�55=�]�6�|mX�����ˣ�Ŋ䓵8�?�?���X
0/Y��G��W��F���^��`�]$	�ZI��{g qjɨ�
b��0
�� ��!������SX�����x2�~<[�ouGfs��rWe�C��kMpV��(�h~Ux���!��#���?r[��Z,�	�
���߫R�m-�n�\r��(H����EJIM�}�>4h�� l�f�k��f?�ɹm�����q~{T�2�u�B�w�G��H�gɷ5��# �(��X�D��jCR:�v�g���y4����"^LF?�E
�ŻM
[��z::�����d::I;�Í��Ļ����?��!�P�i7��Q��0:Hi1��"���Ĉ>NF50`@.���X�K��N=�LJ�F�W£eH:���?���K?�S�g���w�Qc儞]D�ë���u�l�L�0�a�� �q��qע6O�_�9H������C�B"�H)7�Pa�7J�(%A�EP2����_��&G����+��/qr8�|�1���쿟B�˳�>]^��TL%B��G��_a���<�s���������
+�HI�
��;ƬI��sli*�`�(\�,��dN���k{�I�#k�\�!k�p#Q+*��d��z���R#�"p�iS�A��OƟ������&�����։D_F&m�խ�k����eb���t�I���H��I�"-iA3xE��\}DX{DP�1 \�QY�����j�Ow�Z?Տov�?�^��`x���"̾܁�Z�1�<T��ݒ�j㔴l��d8RH�Ns�f�!��FjBdH9�@�iX3@�p�A�c���u�̻���p�t<�ht�����}��vKf��SҲ5�$X��J&�b��`&5�;iH� r���w��V�U�e�
�Up*HA�L��t�I�P�9��Ӝ0�u���4��R49��:�^����n��>��nB�����,f��@?�XE,G� C	,/�!B'��
�16��j��xxy4]�U���]R�ee����s�f�H�l=C���;Q�*�D��5,�>�QZ)����ܶ�@�d"*�2�T@�P���ڥ��of|� ܚ������~�x,n̯����/�����f�����T�e$Vx��a8�"����(�r͛������b�t?H/�Gd�"p�4I�;��GI�
�+B���%��=@���=����g��{0��o����-h4�J&��r�Fc j�-�J�Hk���@K`ۛ�
i�>�{�+0%FH��5�w�q-wֻd }��� b�A���3oB[�oF���gh�;i����L��H,�&Z�����[��ՎYs��*�=:�܏����ǯ�gBb�3�RhQ�|W�A`$G��;�) a���He��.��BZ��$���2��ے>o{�����x3�����0^���B)F�`$GJ�$���ҡ.��`XK1�?�}y��w�0	�K�&j�L!�Ciq]T�Z�X4*�����* ^�H���z��V~UC�T����]a-Ak�@��*���Hx�X^7����;�\B������. "��
���%N;���"<̟.���/��[����,q����2���|IAPw��e����8�e�*�TDX)4(�%�.� �`Έn�Ym���}����r�t�l%��B�4�&
��f��ˢK�J\�E�!a),oJ�_qedQ�7�m����.����I@\Qfǝ���8/-x\Ǒc�`��C�S�Q�C��O���M��:!̗����m�W�우���1�5w)���<�b�r��*����Ry��i�����*J�Trc<f�Gt������Ŧ����u�>.w�|#����q�-�n�?�'Oa�R$�ld�c�D�\(�6ZC��^Bd�~#�-ߦ�/n�N��R)�.x��w�V���~�s�K�8���-#�ro���E^�W����n^?X�w���{$������x����e{b��m�\����f�2��)Q��6m�ˈ@��t� &���m����wu�|c��a�%���cm��}����.��l��$}$��Vl9�E2<�y�!!n��T8�F{�ʵ9qHqb"i+��ܑZ�<�I[w�F9��$��*x��T$4P�<�:*�R�J�p���+��a+�!ǒ����졧XZh�(�����`�	fD����9Q��2abӡ�V"Ҳ]Y�`7y��k�Y%"-x�BB`jq�3E�C_+}J:6a<+Q::�r���G�ǣ��&7���'��rc��::�_]��a����O�{c�Z��� B�AG+��6'a�jfx4T�
�������{�R	B�ި� s�.K:#�U*��A;�@d$T�cD�����(��맫�W?s1>�~���8�p����'Ӎ=������|�Fp�:�-�����Ĺ�KضEk���q`��ʓ��Jm��1hD�ŎxN�F��ץ�z4�E�[g�ɧ��)G�ê/��Cժ���������Z��������S͚4"�ӯ��b7D���R�<�,+FK����o�R�#��b#S�i6�_����prv=}N����8��b��Y{hM�ujs2��|L:��}>�4����%��6�J�[���U>�,1�E�^B\�}�eTt* m�p�0    �>�����5"� �*�����`�� ⯖ٻ����ڵ�������m<�"+���2È�"�Ha)1
2����ئku]MF�[�==T��u�U����5��^�_�Їy�r$}W��_��֌m�^�%A/�A��" @g� �99��,�QX�tAbC���㢙�::�cqL�_�7_g�yw����$���"CE�5` EjU5wZ����|����� ����ty��{��]�W� �c[�ּ'�H�О���"�X"�X����E�hV���7�%r������-dI^�>��S�{�,U����9ˍu5ms���6DL�����B৤��ژ�
��?G��^j���j���P�J���
͞[_�������S�F9��5�Y��Bwܟ�'5��2�a~�0��,�VIq�H*ChA:yԎy!�����9����%UW&4ϗ���z���|���<�NT�U�1�W|��4���z�����0)
�!ᗍ�M��ȋ���qʘ���1��F�$�̻WW��SD�օ�"��)X���e�^���a0��F�G@E�zNE|y����˕�,��'��.t햬~^��zvYȃ�g�^]*[]������8l����k���ԧ�w
(ep�`})�1�:vn�]^����>�//�`��Z�g�G亥����J]M�W���z�y2�S�*o�dk��b��,d~��3ヴ�2�2���]L;A>Z�`�V�TI�2��2 ����q�l�ʇ�E��i�"]�,\5Ib<��Z �y������P��v(�����A��2�X�~bw��eq{��.>*U!��� l b<鈁E#�ЊZM�T֤��s�5���]�W(�I!���I ND	�it�_C������O2X]�7��=�����0 t�0� �8n
$)1��lk����4?�ʎ�G�GF�˷<y1����oy����J��˯W�z)�y4_^N�(%E��Q�^]4X	��&����hRԹ�ر��k��㔲^�;�6C+Ct�n~5�~�pc����@�;9�;8"�(d!��b�N����J� Y�@{��O5�ؿ��Hz0xE_�8_,��`v���v&Ja����[.����U,�AF��S�w�*%I7yo�=��s�����+��Z��Ԟ%�,���?�_�)]���A�����)��뙸u��0$k<S�%5��	�bKmC�^�f�G�U��+�j��T�?�s�?��v|�#V=�$��I�֚��a߫�!�.Tv^I��XkXo<j����X���J�l�Ao��[k{+��^N�4c��T�<Ηv������;R)�h��Be �-tD�`A�H'�:��ęh۲Fu����j�(퉯;��i�Ј�ZZ	O�e�BA?�$���6� ���@{9�}����@}�ew�,+�ؕ�3�
�o)��F�� �����
� xN���k��p�D_R�Oԙ�� )���`���e͢��=�e��He�DzM�Hm�!G���Sx�u�R_�T����ܚ{����0X̺�;�V�ÁL
���;�S���^yiE2e�: �T�Ş/�q�{�0�>}�|:���\�>��/�)��:��>��_?������)�'���L>����۶�L��03,�m��LF$x�o�7��0p�o7J�7� #��}n��XV�o���}�8��������|D?���������T9��~xU���aa��n�����ig�A��v����Be["1Fc] ֥FFE�1�.Gd�X�w:>:<���=a+`�up+/|�<,�7�۸�s�@5!D�B�[)Fn9��@��Y���E�S{d.�\�>����FڝE$)t�� �q�0죆Ŧ��L\�J���ȥ�����CK�i6�]�����P��L�`B:�G��X3/��T�߬��hRmN�u����b2��ܭLfY���L���Bg^� ��kfR���:�[�Mw����Y������ݥ�MU�U�d����o�h�Mm1���i`וRjM�G�"S�%����o̧=X��{�4�Lk��bﮚ��9E��m>�xt�<n�)�g阢�,ڳE;�B'�V謈�Qe1��
)�e��}��L��:YT˼�9^+�wfޚ"�	urPJt�VYp!zD)�,� >;è�S���M-;���q�ב�-�W�S�?�8>7m���$Ul�o_�CT�)��K��Oq]:WD���h�8B��m�vy�
V��Q���/*�87��\K����R������sˬ�+g�|D�Xws��@�PC�� ¢U�e$��O�iW[yLl[u�K�=.����+�y��FCĶ�|zN���)vڐ�J-�w���lw����a��#ҍJ�[T�XPcZ��^�=&�S�zǣ��d�!�%����c��z�eۙ54
�H�8�ܝu��W,Usv�)��i_n�_��ە�q�
�r���Q�0�v.�r�#f���)^:��or��n�| �@	�!kY��(������sƴ�4�A���a%�!B�)Χ���Gp���O:��
)U�陁����>g)#5Jd85�k�d����k=pb����~�iE0%����,>4E��*%��bgF`~�,�O�Hv>�ш�jq*�[t��|]���9��j~�TC��t�K#S�ZmD�T��z�#��:���#V5	��XgmTC���OӚ~k϶�<�	֮�O?��y6�ok�r'"��85=�Ph/�T���Œ(�C0�H�{`��^9�,NR׎Ƚ֡kU�=���05�KUN���i���0��i��V�i�����Z!�V�Y�0gR{��^;���"��}w����/���Ѧ��v�%�XԄ}��-�m&[��s@w�l!��K���hG��Y:���f<�ݨCuYK�UP�� �>�����|AK�q��Y�<m�����{B�T�F�s�B@��蜍�w%Z�-��ц7�J(Bimf��#aTI	a`�ZX�RF"�.L��{�)����]�ן�mc�N�9c� ��չ�t<�(>��`2:>�ä́��:ګj���f�A+(��'�1�FJI��!Iu��a�,שq���/;[�Ц$�3KP��^���$�*���8(Wnf<C�`��2��1��JE,q�:]�*u[Z��i��{��j�]'𪒃#�w͂B�ePYN@]��V���2K�����Ѩ<X�
��k�Bm[�v:�0:�m�j�ϓqz.նL؛�=�z�佖`�jO ���(�8$JjC=1��t}��=o�iZ�of�⭙/_�^ugyR9	��:P�ǂ�ퟃ�4N�g1�F&�3�9N[q̋����*K�X��������}�We"E+�M�F O�������HČG�#����٨v m�k~ P\�d �*��L���5s�D����GS!V<}��LC�:����֦��vI�ڝ퀙���/c	/�6�ZPk��!�|`ޙz��F$��wi�����������+�8Υ��\G� G�Q";�u�������'�:����~��
/�3BM�d�4U��4�����ɺD�n�)p~o�Yx�z�^�ȵ4ZI�m$ ���d�S�,�j�¶�8�_�^����8�z�w�=�8�U�]iV�z[ :O�*���u�-v!
K9�Qp%�;��i�2 2���EnsTN�G~�/`��1���!܃p�Q�f^t�o�!��U����P�1���{��gl��mDS	����]mf�*�M�5U�f�4F[�;Q����e}����(������hn�� |	����m߂!�j�O�2�8?�������$�,J�
�����+�ԥ�%p剠�g H�-m0����$���Cŗ�wgǈK��[W�2�!:x�;x�R����hVٲl����cF�5�{��v6��U^8�����q��,xe	�`OP0��b�>�C;�`�����2�]��)��_�*B� �T��~`�B�~���z�f��i����u��[H9� �h��c@����`BM*ԝ�ت0g[6�������ٝt*�V��@��!J� �  �����: Q��g�'E[��Ƹ��]���g���
q���%/�}n
����e]�=Q:�5F�h����/��L7'��=��V9w�k-8�ڂ �*�`:eWd�i���Cߞ�0t�b��7
��7������p���嵋���djw�PL@������"�(FI!�6�	a#5�Y
nw��o������+�2���pr^?_W�aS>{Z�2�=���P3�������cD����C��R��V�5�XP��w�Zm����i�5ŀ�ខ��-Vz�\�����ͻM��vƊg�?073�#�ܔ��7UF	�N`�ߋ� �:�AV��w+M�F�٠�V���/wpu��ecy���lT�IY���Vo |FJz�B$����q𧆐�kf�S�5]����������S�2���>Ɋv���	���Hm�����@����B���5�z���k!V� `]7�����:�YMH�[�3X~4Q�j����T@?���<����VZ��~���x�qT�-㺔�u�F������I;�{����1U�Ͽ��V �V7���Ii�4)KI�f]��U�M`�xD�7_��#D���S�{��H'k�V&�`�$�p�7e��`������=,�����iVK� �WIE�l��4V�]��t1��Ƃ嚛���{3�)��˨���a�<d�Q��4�3�9�	��_l�f�����Ų��w��r2N�yF�]�li�)SS�4,�����q��ew��ۖw�P$�(�/�%LK���H�~�8���Jk��͙���w��Uw��&��ɭT$���s�U.�:P�dD����1̝�3�$*�/�{`c�ޡ��OX�H�\9�B0����4u�Q������@P�iy�T����˶.��ӫ���	����!Km��ҝ����=�=�b���NE,�!̃s!'T�A��F;+y��)pn�CS����S��YD
��Ȁ��ě_܊�����K�h�Q��g��G�C���벱J�_���\}�]�l]"Nuu�!Lw��2I4/~>�`.�6Mh#���s�Q+�-��_����D`�R�T~1�q���S�d���v��.r�"µ&$��r���A�'��ӫIG��(o1�B�^�4_Z�0*�#�8�2�BکNE��b��`�`�Зm�uZ�o��Q8U��.&�>X�I��Y~æ�JJϽ��cxyj�'V�VUo$z�$���?��O��zA(      A      x�3�L��".C8'F��� RKY      B   �  x��U�� 1���ۀ�^.1Wp�ϱ8�Č	I{�Q�s�X �*�uA�Zg���s�VS��=@���܉q�W������Ƕ� �P��	b�q��~�oX�}��A@q\}ÙkǼe��+��u}��b � �p���Xg}�k���d�X��ќ0���{�x�:�$Ws����O���&/�W���=�C�Cv���u��L~���pxde6��`z6�4�<(2�Y�ۋe,��֋��C+%�-|�~�^<9Z�����`p�1|�a��켂Mʏ ��^��'m�%�b����]-N��ш���Y'�-ϵ_��]zV|w����q�-#�}u��hk.�Y�4�=}��V4Pj�����Xst���U:ܴ�|���G�X�F�!�:�/bg_����
'oIk�w�|X#[�Tq�J��K,�&W�nU����h[]|�Za<�H�	l�?O|%֋e"�-�Kf��Ȩ�9y78ˆ��rJ�U��kp �j�v�6U7w��.z�"�2�ѕ���� 5���6 ���q�J�W�'�__E��E�m�z�k��n�ޞ(m��KFX��z�;-P�N�:vǠ<�jy���^C]J��[[�9�.��=:�L���z���&�Fm�KPk��%��7��o������m���      C      x������ � �      D      x������ � �      E      x������ � �      F      x������ � �      G      x������ � �      H      x������ � �      I      x������ � �      J      x������ � �      K      x������ � �      L      x������ � �      M      x������ � �      N      x������ � �      O      x������ � �      P      x������ � �      Q      x������ � �      R      x������ � �      S      x������ � �      T      x������ � �      U   �  x��[�r�|��#���ep��|��\3 �a��r�I���8�hR����Ē�s l�K� �l�<7�!DbL}��(���Ƹ/5�I��f�����?�Wu��]��w�7��1M>���j|���E��˧�y�mğ���w>s���XtR�P��\o]�N�2�_�����(=��C�/�8�N2��ҫ��2����M����o��~���X�>��:y��X9�X� V��\ڸ�Mj������0E˾��#W���
X���=4�A������Ij>pq3OZ��1B?n'�_�������{�QЦ�7��h�j.�8��ϟ�ݧGؗ�υz
jY�N�����+V4،���~��/�[�B���2R�j ��HJ�E�M��%�>}���q��Ǆ�$P�
���T<S�0z��K+G�_`����>����Ɠ����s'�:l^���.+�$��aBR�aV-��|������������\^|v�4ri�(�7����N�r-�h���{� �<���s�+��2Yu�~�1���i)Μ�[?�1�<o��Jd�����e�HH�J�����{#�#ا��}.�ڦ���k���&�,-'i��/q�E�d�1�R
M���1�jaJ�cBX���c�_�E����I9�='��`
Z�Y�@H��dMe����W��OϝJ�.Q&�!D8s�n���w��\��H��<�~����'{E	0+ #�<���i�*V�Ԣ{���'�~�<9�_*M�
(�Xh"�{�����U��'����W�aV�}p8�>�݅��rHM7��_�n?|���:����K��:'vXkF��~���IBI-����:s������@����H[۠ozڲ�h=q4j�V��J2{Tѫ@�͙vB�[z���������ǧ}���tpY�S(U�������}�z��;�`A��`��
g&gѵٓ�&G�H>~�����T?���Ih��QOi�8����\Bǀy������ޟ�΅^0��$l(����f���X�?fJO�_�υr˹� )V���5D2��G��}=��_������>�p��� ���j���0��6n'�1o�����}.��a3�LÐ X��;RCp<TK��N4p��x�2�YBNI��L��Ȯ��o�5A���}�MOZ�'rm50�d�v�P]��c����2���A�n?<R�͓uWZœ�i�5���� �	�]�lh�Y��5CL����sl����S��V�7��w��c�D�NJ���w���^~�����=C�5N�T�:�:�2WGZ@r��`$ ��%�-R��LL>A��Xf�X*G�A������qpr��eCHN+%��P��Y�Yg0�|��UĲQ��ɘKX�)q�;t�f:���y���C�La�U�,�Cfq�%�(��N�o)o�]�Eѥ��j��w!��t��6��>X�
с!7� �

[�JqXi)��z �����-���W�h�m"~Ĵ4[+zh���oMS�J��{�U;���=��
�#�O/o����*�)KA�a'b�l��b�vhB'�7�K=��P���;��J�������b�V�a�� L.|A��D�˴ԪHǠ.o���Q���)ըa�yJ�������g���/���W�=�h�DPҞ`9��A�yC1x+�1�ʓL'���ku��Yd��3�����uR �E H�G�j&49b�fm�`Y1x�TR
���)���l��f潯ZcT�e�T�V޼.i6_��  ��A-:Њ�J�u��������l���n�-����4I*��-����b�f�\wmBR�y���M��+��V�K��Z�
]k�"��E�F�Y�S��驴�^���"�k%�ְ5���"�]�������{z���MKmz�*@�T֙�_�L�ӹ�����]�u*�����$a�qY�SG�l�lN	;�Cm�
��?g�蜋qF��Q/�Bz��s�G`�Ym�
��:����@<F3�n�у�t��j�\C�5��&e�gLIf^rWԁ�I�����ֹ��J1���܌k[�;4�jw�TE�8|��:uB�;ל�����P3v�M�ll��:נ��3�F��:A�i�)��\5�T�{#�w�֩�S���E$�u_��`/�H� �ΎAMm�
]�����*0��p���h�"i�1��R[�P�	�i�r� 	ne*8@i	�}l�޸�]�u*x�u.!.i������Vd�8���^�sHm�:)s��6"Y���3�:9S��D?Zqn���u�TڰA{(�uȣ��EH�WIC��Ω|Sm��B*�v����x�yu�	��Aq���U[���M�#qQ�Kc��~�U�����u�鶴S�Ѻ�!��2+�:����g�9�U�u.�.~���}�I��'�º��8j�̫$!vKL~����&M�F���=GOi�՛M�7=mi��dz��ࡌ- ���Y3Xh������^�9~�&N�#g3/���SM�ݪ�T���WoN��O�g��~�r��?(�٧�ԙ�`G��GWo���^��\�Zde$��S�1��c�����WoN��z��bR(�6M�P�qG�c����7�|�=_ޞ�D��:)�;�\�|Y�!�y��ͩ��C�������:_����'���4H�}�p��T����֌�3;�����S��w�E·�a�^��!q��uQg§���β������^�2�	�b�����ٺ�0jr�{�_e�A��1�uC�x�@^�/E���KO�`oz��JF���"�V��b^o�ű.v��Vjlm罗��q�%+[R�`�m�`]Ct�3��������M�X�`��}��ްΚ;���_�&������N��dG-)HpA��m���,�ݶ�otݥH�\*R�z?���8��T�iC��#�(w�s�V�?��ݻw�N���      V   7   x��MK�*�42�3�3�44717�0336���MO2����M,--L�b���� U�S      W   �  x���Ak�0��ޟ�sUK�d˾���&�������Qm"KK.,!���MJ	%PzB3���7�Z�z
�)�� I�+ ���Re��P�R[Ri�� �tCxi����B��f���u%T���5�{Hc�6G��@L�L�?�ӂ�o˄�1�c[.��S�������	�GcpP�	b�>��M���&�/�8:�������M{c�K��"��gg�xD���X4a |v�	�lΑk2:M�caX޺:3j����n�́��lʛ�3+��5MO��CK=m0:�-�TL�c�7�6Za9m�&��^Ǉ5�r�����et�lcJ�b�ІYk��6p �6��n$��!�W8W_U���+����}��ޏ�y��������J�����//ٙ�����ϻ��0�ڋ      X   �  x�M�Ko�0E��gx���	A��̐ $�KH�vH��������u�T������sI�0����pYb8T�5��
�YL]�p�c�M0$ȋ!S�A��&��sMh�H,���J_SȈ���H=L��J!���=�|湬� �Ҫ�'Sנ�G:��A�@��Ch�C�KY�cC]�F7�z2�)�9���צ�F�ci�ǲ1���v��B�]4���\Ǖ�>6�q�i�NS���9����}����g>���p?��~9�(�ۢX\5���T�".�,��L���8ՅO5Y\EV�3r�*���-�EWf��7�Ym�5y������*B�e�mV�Yy�Y�ȸRC���Ey2{y���G�������T�c�jٔ��Z*��<U��v��������L��M��Zc�[����O���&��0x݉<~�����vZ��M�]      Y      x������ � �      Z      x������ � �      [      x������ � �      \   �  x��ZɎcɑ<�_�?��#�(�FA�����"��L�҂��c��nU�[�d全z|�0�bn揵h��9$�j�9�:5̞�������N��~��ϗ��~�<��ɂ^\_��i���ϛ�=?>�ӡ�F�Z]�����a�QkV�᧿�Z�>gȸ�&��_�1�z�������>���������$�/�B��G+�B�6C��A�)䢳�������ʴpp��Vθ/�e�����������Χ��3ߟ�^¾��_N��/�;��"k>+���'��v,3�r�4ux����6�7<b�6�M>\�>����r�<|u�חýߋ?=>=~�v�Q
�"���dJ�r״��c��ŬW���-�.<R.�zX�����;��ݰ���l�yI��N'�k��Ȩ�g;�����9�B5�Z��VOQb:,�?������A��a3+�=��cw��\Qsמ�T�����?|(��4�M�dD���Q�)��~�?��?4i�޺��(���x� *B�4�5'�ߏ1�?�G�ru�A��
9�0֌�s;�s>�Y.����r�^S��s�>:/9<>]���Y�Z�͸R(}g�*�V�1.�]�Ǔ��>}���Og�������$t�ͥbL������ab�\5B��&��QU���Iټ�z����� �B]s
��	��3�Bcg:b?�������ņ�G
v�Ţݙ#Xmc�^��t����O��a!Rz�� K a��2Rߝ�I�{績���:ي(�Pib�3R��B.�4^w*�_>�.	�#����@8(��,k)���O�w ȳUTw�t���>����R��k�x��w|�5�W�ޘq1u�<pu~Ap��?�����@���߿��-g������إ�j(����zn��fЈ��V�_���\����lQF�v���辬e��an�wcւ�#�cv �����g�����VJ�HE�!sq�,�g$�Ò�kjfM�їC[EX6Y7p�,AM�
M	!j��ڌ��PKP����T�|P��]<���Q����w[�~;-���v���/ PIM�**�0,���Q%�2F��b��SGmn�D|z�c��#��r�/��
��iE���YG���*A�i�(���\�dAj��ZD�Y�),A�p�m������o�0ػ������w���}��|MdH����a(KN8&���S��|���2���&0�i���Ҙ*��j�ӇwTj-��A?�}a���@���b}2=�D2|��`��0�jP��w�@Q�ç���㻊�*HP�#š�@�E�`���*8�xC>���|ỳ���&u�����m����Q!���[G�'*Ç� ?�!Q�}�4&����c���Q�/��������	C�%��daLZ�!��U@e��Sg��au;��L���� �����c�ȥ�_�p�{��)i푂� $�Nơ~GH��<��Z����{G��h
�V���w���k��Xy���;z�G�_��	��½i�����<�����f�n[�$Ѫ��"a�4i��I�׈���O0N�1������=f�����@������.)��߯+�/&g��$P��� �STc_3�#Xr 2'˞y`�]�+L�F"��6�fI�v�k�4���Ov��{[k�
B�[��=X�4cW�uU�z[Բ
��&~��ۡ��A�ᑸ�f|�^k���~Z#���w�&��m�����E� �lq�C(M�=ZGؑA�n�&	fzf����E$�w��0�f��BX���W9������4ǂ��<[�u�Lk�߸-�
G��R�Y��V�m� ��=B��F�m[t�9eRA$��=����se���u[t��!Z�p�-a�����H�m(����-ۢ�@P�|]q�'Fk��m���,�+&�-ۢ�@�}R�����e��*ش�R�@��ۢ�0$���^���6�/��+CO�xö�*�3Jk��r��mTCX�20��zö�*)yK���_{ce)l�#��C�[t]c�J�
��l )p�A�!����Mۢ�P��TsM8�}���u9�i�-ۢ�@�6&Zs�pб�Fw�Ɗ�}���::0�69���g�G�X_����mۢ�`�&LI���E,@��8d���hh��EJ-��pm+94�6��f�Y���|ԕ�w7���ј��Go`�
��m�5H����(�VDU��͏�`�Zgj��m�H��^[�� m��QacJb�7m����d-:R�y,eȨH��mk�Zߏ����߫�4����m$ھ�f_A�@c6�܋P�aۢ��\�3���^��H,[U;�"��[�EU@Ep��
����)�8�����q�Ȕ�Vw"+����L�T�p���m�UP�U+e�G��m�C3�ĺխ��o|F~-�~)����&��i�!y�č�����M�Vt�0���J��P�wv�F��=v�w|t�'� ���4��;�EIk4�f���0�8�?#�e��BV ;'�iX�� ��]����W^�.��ۢ�0,s)iK�i.� �YB7��UI�wo�E%V����)����m�Xtqf�q�D�d�����q��+B7n�Pk�'�l�{�Pq�tD�p�A_�1U!��_p�5�����M�"���m�U�A�3��2�y�AKR�{������ݸ-j�u|�4����]6)3��r�rt4��+c8�M��$�GK%A�Nn��m�UH
s���j[��K:�VOMZi���-�
OO��V��l�k(#a���tC��"���h����C��5bPPU q�8��H�.��7�@y�aJ=i��N�	`LR	 C��[ȡ4
�6�5i�]S�=���/Ok9�(�B�K�$�����ob��O����g>�������E�!��-5x���Nc�����7����x<�����      ]   t  x��\M�$��=���'l����XHZ_�E�d��ZWW5��%ȋ���	�ݑ�`�aT3��#_������c:X'l(A�Ժ�Y�P��$���������|}j�v8��o���}=�����x�������������|�]���&�|���s��z�-�qʏL��c�N����z>���S�?�Ҏ�bn������6kQ@��2j ��]��k��"��x����C���;_d���1�x�������O���\�놭�)�h-��Eih6���� _(�s;A��}�&��N��5#x�B�`��\H��(|r lsUde��5VU[��%>��s+���ݸ��;56M)^���m�T��>h�@�Lɋ�I�J1���}����yB=�L�4!x�F�d���xgv	�4�E��h����F.�9H�X����}��}��D`�l©	��Gk�XX�.']�Ga���=�Rq5��eoqX��]|�.���S[�o͚�;Ef�I^9�n8�{��+a|θ�i�&ia��]Ρ��Sl�)��Poϗw�jB>��L5�x�G��11 8�*N�0����
�[�IT�9��A�4!v���H���lwR�ܻЪ{գ����� ΂/�1�O臝����ӥ�v�4x�M��eeQ�/k �F�9y|ϕ�"y���^+��,U���9h�8�˹�U�a�fʲ�k�88ڧ�z��Q�2A�"7Y�ţ$U�G>�9H�X�ӡ��[�a�h¨9�+�X��\m	���gM¦�p0"���ԊLu�D�s�Nq��O�o������ ة��jB�C��2�=�	� ��m.� ��E����).I�&�MC���Ux?\�7j�2� ة����|����mTXЍqս����&F�ƄC2�\�,8���5ph��6�?����a�h�+������fq��Y�J�U+�Z\�98KQ`|"}n��Gf�9H�X�r��~\攷nM4 v�&ܚԼ򊅤���%�q�[BhP]$��[��n�Q��a���A'�9����w9j�xة��Q���S��Q5M{U����UD�+4ܧ��a��� =b�_��WD�C��^M4v*'���~��W�+�X�r>[>�u�a���x_b��Q���V�Jo�y�p�}9c��������S��h�/oY�����A,�������o'���_M�!�F�z���6�����L����/�3���G�u������d��woï����P��,�+G�cfo��Q6P�,=��>����~<�ڷϏ�]������N�Թ7[���E>9��X6f��t�,���̤��>�eMi�|}x���c,|e�(��ة���ت�Z�*��7�/��j%��6x�l~�HNt���|������Ry�:8��r��y-C���a���x|>�?��3�`,T?�;��?mos/�z~�������W��v�=���/8�k�Y��W�(���C�IXe���<��[�����k>Ǻ�Y(���O�6�����=���Ytg��T���R6����Q|h���<���9��\�J�-��Q���u'*n�|M`j���X��BnO(��2��������ի��ѯF�&���H���R�	<%ѭ����:�砃W|�jB?�ME�,�O��I,�V�b�����VY�
��-pJ�d�in8~'8`'�*�	E���\Ft��RM�gH�8�8��7���~��_��W$Yԟ�K��`%�9`'po����Ǉ��u���$3��D�T.CD`��(�ިGSC�Jf3���T�!�ִ^�AYY-|�t�B�x�%��#�~)�9#����oh��p���$ի.����J�Jd���T%�cE[�~��g���|�	���sM_�39ȍԣξ�r��"�ApǑL���Bi1&���� `8}%��E2�_�9`'�J�7�=�7*3�,J)4a�Rt�<���C�aX���XG�O�����*8���s>���������7��@;J
�2��e�a݋��m���u��,<u�@�����v.����%n?4)�3��.������a�dj���^�80��2�%�u�0������v��U�m�eas�.��[��a�h*Y3%y��� 7*jK�Օ.d����n�w�Jݤs��P���AW�r��������Z���`A7�jS-�{܋i�p�M��]���n��fXV���j9�͒���NՄY��W^��^��A���Ζ�>�+J�.)o���a#����ߪV��;ESVMI^;�nD�.�ZpV�J�G�
V�l�k�k0����A��r����	��S2�N^Ǩ؆K5�T3"fɏD�C�++z�y�=��9h�8�͚҉�NՔQ��Ԕ��TF*����(Y���UĀ~��ǮS�vx��� �b����M� v�&���.�`a鑅#��.����l��OK2]t���! �����:��;Ef���YaQl݅h6��#�&��[vi�E
.C�>[/�w!�w!���p��^��ɫ�ׇ�܆O�'���+A�e#����y�z�%���O��ݢ	��S3�ӌ�O�F�k\��'�k�/w�%	��J3Ѓgk�9�B"��	�
��V���˸	�,/KFtB�j�U>�p��s�����L臝����ƕv���'#�s�ȿ��S������ʢ�G}|�,|�+�a�f«)�+�X���B�DU�5�
��Yz���Wg>]�΁\��o�TN�5�uӥ��V�zU8Yb$�z�B�&rTYh��էaҚ�AW�p��%�	�S1U�׻.�ᠶ*�
,5��VY0�K�D��R�ཏU��pxF�	8�**�:[�FE��u~��-�b ?�N�~4Y�� ��� ����ncQ�uP���kvd~���A�Lr�ԢO4vꦎ'٪�Ztx#��bs7s���4�[�9DW�����i
���{p���M����[�G�?X,K��&v�pZ��u5�� ��>wSpY��9^�sPT�1�iT�0�qA9�b�f`��������Öu΃Ł
��>|*?ڂN`q�d-�����b�O%7�|���,�6�i{�;ww�E�Qs(c��U�K-��j� �
��&c�.9֌�9���+����/���Ҥ�D��h�U40LS�96jJ�4����5%\��^{S���l�E�ph��$7R���,�Ċ�K��ȑ��jB栨	��vʤfr�����m䎠�����=��@)�b�צ:�v&8`'��mI٦(z78i��$x!��\��um\���P�Y�E.�
[���Z��-n`K��>�`4u�9`'po���,$uzlr֠�m9l�ZZ]Z*�r���°ؚE2�q>�R=>��u�s�|�9����!R=��(�T�/@���Ǘ
8���;�ԥ��������Hea�ӗ{��Z*���1�2J��_�a1�P|�	�2.�m_'9Ѝ�<%m[���Y��b��F�w�8DU���f���s����'���Q�t��ux��{9s�Y	�5B�2	���mP�WU��{�����N�M��A9.���_��țۘפֿ���/�a�3S���jT�������w��U��x�x4���r�	<>�x��-���R�������r�|8�Z�Y�?�_��2��͞������|�����~��ӧR|��      ^     x��S�nU1�s��(v���Ca`�Ƕ�D�}���С:�X9��|?�"�i谭/��
BLЏ��\��QF-�>}���k���������}�����L<?�|~w��퇂r[=j���0�#�m�yf� 8t�ձ��Ok���r.!�Q�?����[,�ן�.�>A����� �u���+�Uc�0��:���h��Ѓjsw*���hՀ��,Zѧ�8½Y�j��x�=����b[�V�ņoy����J�!{��#
�EO���7=Ϡ�lpp�<$�Ey4Ԏ\���9Ҝ�h�(�@�*���c%�>.�t�It�����p��H�Q�֣�/���_���|��EN��$	���s%h1�Ta���U�݅@f*�vu�[p=M-d�>OLL�1mLŢ�д +�U����uR��8R0U��"�#�l/���{8�Syj�6���Q:v�,qr,��RI�3@{K����%���f�Y!�,��D���b$4⟯�y5�3Kt;��a�Ӛ�D�������r�����      _   �  x���Ms�6������K)Sԇ��Ɍ�؉�v�Jr{h;\J�@� �j'����Ē�,Oo����r��wɛ��[�f
,��Z9Pn|n�[^i)�r�6�R���d�N�1��V�N���i6Ӕ5�,Ix�"�٠ޝ���e��ZYIi�DQl`�U|TV��m8ԙvv�&T��mșae��/N/���O[�Gw�F-|�5|�Y�|����)�ic�������խ��^�ފ�:#�����u<�HJv�	�i5;�n�$����r��h���%�F��;8ӆÕ�Á���LZ�*0%S��s�gz�B��J|,f��r��%_�=r�9�Srq}>\����Ϙ�s�1��UN\��$Q)�(��/s�g�z"T0��D��(n�\�Z���/K�L��.��"��L�s��� ����V��b��3Ʊ�i�V`��ܲL¥�Nt!�Sc�;�g`��I}; �m��I[��s���i��>�zq�MӼϓ!Q.l%��[�gXr���k�GWJ��(�=.��o�g<�z�cwn�푭�z�����o�
6�n$&�9܄c9���%m��(�t#]R(�zk�o^��sQ�_�T��	�;Y4H��k��$��L��6�ü�6���,�{i;�;:}h'�C��L�D"�"�E2E"뻦H��"����")���"�17� ���H�?j�$�wL����)�(�L�*��)�;M��~�I�]�P8��!�A@@��Y�f�c4{�����-�s,�0�js�]cw	������M����v��l���� {�Y0I�Rt�1BԽ/V��a/�Ga�]���xN}!��*�����;�&��ơk/`�]�vN�+�?�=[��|s��n#8���1>�����C��d`V��A�Ǚ�V���uJ��x��O�9����[�f2Z�#��Y�DX������pV��&��\������.�p^X���p�w��c��o��]��q	G��p��q��w����)��>�o���<eThO5����\���iR�B}�k|��a�C�7���69���)�U��C����]H�C��ׁ4n��^��Bgi�żStӴ���YVʆ]����p�1ll��U4ſ�|ߠ���]���f��>��	#$�S��M�z�|
bQ�/óꛍ�����R��#u <���@<���f�'�q�c��W�k	����B`_"V�����W���y�vA��߿���L�_b�N��^H͙�j�^��{��(��I�~      `      x������ � �      a      x������ � �      b   \   x�]�1� �9��Gؘw�b�RUe��R���)i͢�z��'T�B�Jf1v;޶��g��|ghL\nr�d���0r��\b*��+�B�T8      c      x������ � �      d   ^   x�m�1� @��ޥ��"p�e���������-��q�e|�ޔ4ю��Ga�;FbV*ŹZ`����c#Cm!�t-�XC��M������=�#u      e      x������ � �      f      x������ � �      g     x����n�0��Q
��DR?y�N��P�p�"v߿������]�,!� �cb1ȱG���x}�o&�u���v�Eu�\��y��%6vk�@�����4�4�F�7��%F��3�u�ڤ@@͜��AK�^�;�ۺo�xh�v&����
�j�)ZS���Em=����! գ�H��i�K������cK�7��hR:6���h��k�G��x�`��2tBT�@4����Dj�����q��eSY��~���n��/�4}�a��      h      x������ � �      i   �  x����nZ9�����?�_?QBVHi�i��Jhl��H* ���wȆ�lr���Ѽ�z<�ة���q�E@�$W2�5&S�c�}�&W,�F���#o�����-Wi���b[�hm霕*��w�g	��pPMg���C�H�Cե����v�����xq;�^M�����J{�n7m����_ȠH�k��L �.�n`�*o�n����\M~��������ج���Ö�����_�hI�K+T�b< ���k��TCA������ݧ���y��}�l��7�j�	���&s�@*�YtY'�m7�>�-F7����d>���us�~�i]�R���/7�]?+M~g%�P��j�Պ�D���pٙ��6�֮����R6�}w��9=}���BƫA�.6�J�*���[��Rp^E���ʖ+��KZ\|_�}$�bZ��w�Ӥ�a"8xH	-d,�.w�m�x��v���1x�{Y^�����9�"-Z]��d4�s��"$l�7�eoR!�}�L��ְ���ݞ�ݧ������ɩXP�h��%i��P�#De-ԒCJ9R�r	_��dŻݩ��z�����&J#����J��T���Rc�A�:�#�,z�黑�B&Iv��fa�PE�-�D�,8��W2���'�M������(C4h�v�Q� ��9�ۘBu�@$�"�
d����a
ڗ7@�;�)ȕV\3���k�P��E�0��A�;�)�-KUY�1&��iԌ��e��� ���v\l�М<��f�:�ՔAn�� �e�5�[B
H
<59yA��PĻZZ�\e`� yog@��� ��1�����	�Lr�8�y�#9r�e����T$�*آU�p�0=A�����XEr�Irj(�+I�m\4٢�%�yo'gA�|r�!ܼ@u�ǡ8�RQ�\�?A��O@�r�����TCN�<JX.�B�� /N ���� ��XG      j      x������ � �      k      x������ � �      l      x������ � �      m      x������ � �      n      x������ � �      o      x������ � �      p      x������ � �      q      x������ � �      r      x������ � �      s      x������ � �      t      x������ � �      u   �   x����1�w���`���/!.��ҬĲL�z@b��'Whܼ<�>̟)&��!2��I���8u�I�s15����ұt�Fʪ5<�ʽ@�J�4z_�&�U~4����I����p��oSe�w�LL)D�(�S>	�,@�m�*=~�1���M�      v      x������ � �      w      x������ � �      x   k   x�%�Q
�  �o�KF�1�K��b��~t����W(���}ף����Vݷ�;��]jI��	��&\���Eu����֮�<�PL*H
E8�dny��������      y      x������ � �      z      x������ � �      {   �  x���ۊ1��'�`˒lߵ�Rh/�F>�@s ;���d&a�LJ�	$����KÙK�f�/@�D,Z�hH�5W���Cu.V��� �R!qQ ��Jt��0N����������� 6�QmJ��4h�����%��(��Y�ɂ�L���Pp��H�d&�����u��{��?�|ܯ�ƙ��y�~�z���m�h�[AG��	�ʱ��%ɚ����gX�F�	��&B䚠b��%�)�&�+��ɸx��8��7�I���B�7ו��@MȖ��M�Wx��y����(��ۼ	�����'-�`�@ɚmO���%+��ɼr��{^��^*��Ѝ����@j?�Z���\�yOz������/���[,�b��"h�CG>2���d��}��2컚nO��;����mJ?���Pה&���{�e3��b#��nʗ�eA��ԾrJ/�P�u�ϻ�����_�ïK��?P���X$��rWT��
X������3b�Fs���4�wgM���Ԉ�߷�q�����Kӟ��?t�*Z�b�*����P?����P�wIC�S�!�URW����*�t�U��cy��M�DR��K!b�� B�>�C��w�[=�t��G�w|�9�J�5�/��e��l�#�:�      |      x������ � �      }      x������ � �      ~      x������ � �            x������ � �      �      x������ � �      �      x������ � �      �   �  x����� !D�rarً����7�v�i�{��8� ��A
9F���^����-�U �΅pc:ʔqG}4%c�8<Av0�k��酘�F�LG��Xf��\2=�u���+�	Z$-�EpE��TC�7�p>��	[�����d-�X���Cb,(��4*:�p��4���7�]hw��� wO0��ʝԇ7�?T�Fe��Vw�
��e7�j��|#=y�5�a�M�^��f�|S�q==�޺�~g��Ξ�,W�k;��(�7B��G�݋ �`Z>�E��CT�o��ebG]��M����	�FxTv=zz"��T{�����[�W/x�~��]Y�u�Dz�m�`GZ�=ʭ����El�o��Ho���9l��j3�!�z������H�|���a�      �   x   x���� ��)%edx�Ћ/B���;�\&#6i�j�7&��.�����s�h-�ޓ�4˔�<�V��z<o����� Q��}��j�ܯO3^�!�1�� ��S�2vC����Z��<&
     