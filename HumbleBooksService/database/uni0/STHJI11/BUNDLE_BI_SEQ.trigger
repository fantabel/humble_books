-- <?xml version = '1.0' encoding = 'UTF-8'?>
-- <trigger xmlns="http://xmlns.oracle.com/jdeveloper/1211/offlinedb">
--   <name>BUNDLE_BI_SEQ</name>
--   <enabled>true</enabled>
--   <properties>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_CONNECTION</key>
--       <value class="java.lang.String">sthji11@uni0</value>
--     </entry>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_ID</key>
--       <value class="oracle.javatools.db.ReferenceID">
--         <name>BUNDLE_BI_SEQ</name>
--         <identifier class="java.math.BigDecimal">459933</identifier>
--         <schemaName>STHJI11</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
--   <statementLevel>true</statementLevel>
-- </trigger>

CREATE OR REPLACE
trigger bundle_bi_seq before insert on bundle for each row when (new.id is null)
declare
    v_id bundle.id%type;
begin
    select bundle_seq.nextval into v_id from dual;
    
    :new.id := v_id;
end bundle_bi_seq;
/
