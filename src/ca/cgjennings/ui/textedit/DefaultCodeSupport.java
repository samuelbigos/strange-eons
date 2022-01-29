package ca.cgjennings.ui.textedit;

import ca.cgjennings.apps.arkham.editors.CodeEditor;
import ca.cgjennings.apps.arkham.editors.Navigator;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;

/**
 * Default code support; adds basic syntax highlighting based on the editor's
 * code type.
 *
 * @author Chris Jennings <https://cgjennings.ca/contact>
 * @since 3.4
 */
public class DefaultCodeSupport implements CodeSupport {

    @Override
    public void install(CodeEditorBase editor) {
        final SyntaxTextArea ta = editor.getTextArea();

        String id = languageIdFor(editor);
        if (id == null) {
            id = SyntaxConstants.SYNTAX_STYLE_NONE;
        }

        ta.clearParsers();
        ta.setSyntaxEditingStyle(id);
    }

    @Override
    public void uninstall(CodeEditorBase editor) {
        final SyntaxTextArea ta = editor.getTextArea();
        ta.clearParsers();
        ta.setSyntaxEditingStyle(null);
    }

    @Override
    public Navigator createNavigator(CodeEditor codeEditor) {
        return null;
    }
    
    @Override
    public Formatter createFormatter() {
        return null;
    }

    /**
     * Returns a syntax area language ID for the specified editor. The default
     * implementation returns a value based on
     * {@linkplain CodeEditorBase#getCodeType() the editor's code type}.
     *
     * @param editor the editor to determine a language ID for
     * @return a language ID for the editor; may return null for plain text
     */
    protected String languageIdFor(CodeEditorBase editor) {
        String id = null;

        if (editor != null && editor.getCodeType() != null) {
            switch (editor.getCodeType().normalize()) {
                case JAVA:
                    id = SyntaxConstants.SYNTAX_STYLE_JAVA;
                    break;
                case JAVASCRIPT:
                    id = SyntaxConstants.SYNTAX_STYLE_JAVASCRIPT;
                    break;
                case TYPESCRIPT:
                    id = SyntaxConstants.SYNTAX_STYLE_TYPESCRIPT;
                    break;
                case HTML:
                    id = SyntaxConstants.SYNTAX_STYLE_HTML;
                    break;
                case CSS:
                    id = SyntaxConstants.SYNTAX_STYLE_CSS;
                    break;
                case SETTINGS:
                case PROPERTIES:
                    id = SyntaxConstants.SYNTAX_STYLE_PROPERTIES_FILE;
                    break;
                case CLASS_MAP:
                case CONVERSION_MAP:
                case SILHOUETTES:
                case TILES:
                    id = SyntaxConstants.SYNTAX_STYLE_PROPERTIES_FILE;
                    break;
                default:
                    id = SyntaxConstants.SYNTAX_STYLE_NONE;
                    break;
            }
        }

        return id;
    }
}
