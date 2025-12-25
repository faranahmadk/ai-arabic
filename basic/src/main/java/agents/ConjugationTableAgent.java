package agents;

import com.google.adk.agents.BaseAgent;
import com.google.adk.agents.LlmAgent;

public class ConjugationTableAgent {

    // The run your agent with Dev UI, the ROOT_AGENT should be a global public static final variable.
    public static final BaseAgent ROOT_AGENT = initAgent();

    public static BaseAgent initAgent() {
        return LlmAgent.builder()
                .name("ConjugationTableAgent")
                .model("gemini-2.5-flash")
                .description("Agent that writes conjugation table")
                .instruction("""
                        Generate a full conjugation table for the Arabic verb [insert verb], including past (فعل ماضی), present (فعل مضارع), and optionally imperative (فعل امر).\s
                        
                        Requirements:
                        ```text
                        1. Columns: Number — plural Singular, Dual, (واحد، مثنّی، جمع).\s
                        
                        2. First column: Number
                        
                        3. Second column: Plural
                        
                        4. Third column : Dual
                        
                        5. Fourth column: Singular
                        
                        6. Rows: Person and Gender: 3rd person (غائب) — Masculine & Feminine 2nd person (مخاطب) — Masculine & Feminine 1st person (متکلم) — Singular & Plural\s
                        
                        7. Include root letters (حروفِ اصل) , brief meaning of the verb and فعل الأم
                        
                        8. For فعل مضارع, provide three forms: مرفوع, منصوب, مجرور\s
                        
                        9. Do not include translations in columns, only in heading or separately if needed.\s
                        
                        10. Use consistent Arabic script, and maintain clarity for practice.
                        
                        11. You MUST write Number column on right-hand side.
                        ```
                        """)
                .build();
    }
}
