<build>
        <plugins>
            <!-- 打包war插件 -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-war-plugin</artifactId>
                <version>${war.version}</version>
                <configuration>
                    <failOnMissingWebXml>false</failOnMissingWebXml>
                    <warName>${project.name}</warName>
                </configuration>
            </plugin>
 
            <!-- 编译java源码插件 -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>${java.version}</source>
                    <target>${java.version}</target>
                </configuration>
                <version>${compiler.version}</version>
            </plugin>
 
        </plugins>
    </build>

