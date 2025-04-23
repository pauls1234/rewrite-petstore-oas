package org.dev.rewrite.petstore.oas;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.nio.file.Path;
import java.util.Map;
import java.util.Optional;

import org.openrewrite.ExecutionContext;
import org.openrewrite.Recipe;
import org.openrewrite.TreeVisitor;
import org.openrewrite.NlsRewrite.Description;
import org.openrewrite.NlsRewrite.DisplayName;
import org.openrewrite.xml.tree.Xml;
import org.openrewrite.maven.MavenIsoVisitor;
import org.openrewrite.maven.tree.MavenResolutionResult;
import org.openrewrite.maven.tree.Pom;

@Value
@EqualsAndHashCode(callSuper = false)
public class FindPomFile extends Recipe {

    @Override
    public @DisplayName String getDisplayName() {
        return "Test";
    }

    @Override
    public @Description String getDescription() {
        return "Test.";
    }
    
    @Override
    public TreeVisitor<?, ExecutionContext> getVisitor() {
        return new MavenIsoVisitor<ExecutionContext>() {
            @Override
            public Xml.Document visitDocument(Xml.Document document, ExecutionContext ctx) {
                Optional <MavenResolutionResult> result = document.getMarkers().findFirst(MavenResolutionResult.class);
                if (result.isPresent()) {
                    Map<Path, Pom> projectPoms = result.get().getProjectPoms();
                    projectPoms.forEach((path, pom) -> System.out.println("path file name: " + path.getFileName() + " pom name: " + pom.getName()));
                }
                return super.visitDocument(document, ctx);
            }
            
            @Override
            public Xml.Tag visitTag(Xml.Tag tag, ExecutionContext ctx) {
                System.out.println("found tag: " + tag.getName() + " value: " + tag.getValue());
                return super.visitTag(tag, ctx);
            }
        };
    }
}
