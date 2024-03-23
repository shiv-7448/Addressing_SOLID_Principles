SOLID Principles:-
Single Responsibility Principle (SRP):-
Violated Approach :-
In the initial DocumentManager class, the design violates the Single Responsibility
Principle (SRP), which states that a class should have only one reason to change. The
DocumentManager class was tasked with two distinct responsibilities:
1. Content Management: Managing the content of a document, including adding new
content.
2. Persistence: Saving the content to a file.
Solved Approach :-
In the improved design, the responsibilities are separated into two classes, adhering to the
SRP:
• Document.java: Handles content management. It's responsible for maintaining the
content of the document and providing access to it. This class has no knowledge of
how the content is persisted, making it focused on a single responsibility.
• DocumentPersistence.java: Manages persistence. It's responsible for saving the
content of a Document to a file. This class is decoupled from how the document
content is managed or manipulated, focusing solely on the persistence mechanism.
Open/Closed Principle (OCP):-
Violated approach :-
In the initial design with the DocumentPrinter class, the approach violates the Open/Closed
Principle because it directly prints the document with no consideration for different formats or
customization. This design lacks flexibility, as it can only print in one way, directly to the console,
and does not support different document formats (like PDF, Word, etc.) or different printing
mechanisms (like to a file, over the network, etc.). To support new formats or mechanisms, you
would have to modify the DocumentPrinter class itself, adding new methods or altering the
existing print method, which goes against the OCP.
Solved Approach :-
The improved design introduces the PrintableDocument interface and two concrete
implementations, PlainTextDocument and PDFDocument, which both implement the
print method. This design adheres to the OCP for the following reasons:
1. Extension without Modification: You can add support for new document formats
(like Word, Markdown, etc.) by simply creating new classes that implement the
PrintableDocument interface. There's no need to modify existing classes, thereby
keeping the system open for extension but closed for modification.
2. Decoupling: The system decouples the act of printing from the document content
itself. The DocumentPrinter class is no longer responsible for knowing how to print
each type of document. Instead, each document type knows how to print itself,
which is a more modular and flexible design.
3. Flexibility and Scalability: The new design is more flexible and scalable. Adding a
new document format doesn't require changes to existing code, reducing the risk of
introducing bugs into the system. It's easier to manage and test, as each document
format is handled by its dedicated class.
Liskov Substitution Principle(LSP):-
Violated Approach :-
In the violated scenario, we encountered a ReadOnlyDocument class extending a Document class. The
Document class allowed for content to be added via an addContent method. However, the
ReadOnlyDocument subclass overrode this method in a way that either did nothing or threw an
exception, thus breaking the LSP. This violation manifests because ReadOnlyDocument could not be
used as a drop-in replacement for Document wherever adding content was an expected behavior,
leading to potential runtime errors or unexpected behavior in the system.
Solved Approach :-
The solution involved redesigning the class hierarchy to ensure adherence to LSP. This
was achieved by defining a clear contract for what constitutes a Document through
interfaces and segregating the behaviors into those that all documents share and
those specific to editable documents.
Key Steps in the Solution:
1. Interface Segregation: Two interfaces were defined - Document for basic document
behavior (retrieving content) and EditableDocument for documents that allowed
content modification.
2. Clear Role Definition: Implementations were provided through BasicDocument for
editable documents and ReadOnlyDocument for non-editable ones, each
implementing the appropriate interface.
3. Adherence to LSP: By this design, the ReadOnlyDocument no longer promised
behaviors (content addition) it couldn't fulfill, thus adhering to LSP and ensuring
objects could be substituted without breaking program correctness.
