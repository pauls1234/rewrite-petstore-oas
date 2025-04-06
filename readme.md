Maven commands:

mvn -U org.openrewrite.maven:rewrite-maven-plugin:run -Drewrite.recipeArtifactCoordinates=org.dev:rewrite-petstore-oas:0.0.1-SNAPSHOT -Drewrite.activeRecipes=org.dev.rewrite.petstore.AddOasProperty

mvn -f petstore-a/ -U org.openrewrite.maven:rewrite-maven-plugin:run -Drewrite.recipeArtifactCoordinates=org.dev:rewrite-petstore-oas:0.0.1-SNAPSHOT -Drewrite.activeRecipes=org.dev.rewrite.petstore.AddOasProperty