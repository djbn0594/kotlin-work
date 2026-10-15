// COMP2850 Portfolio: Week 2
// Function to redact sensitive information in a string

fun redact(doc: String, text: String, redact: Char = 'X'): String {
    return doc.replace(text, redact.toString().repeat(text.length))
}