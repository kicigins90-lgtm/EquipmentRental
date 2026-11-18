import sys

from PySide6.QtWidgets import(
    QApplication,
    QWidget,
    QLabel,
    QPushButton,
    QVBoxLayout,
    QLineEdit
)

class MainWindow(QWidget):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Форма приветствия")
        self.resize(400,200)

        self.label = QLabel("имя")
        self.input = QLineEdit()
        self.input.setPlaceholderText("Введите имя")
        self.button = QPushButton("Поздороваться")

        self.result = QLabel("")


        self.button.clicked.connect(self.hello)

        layout = QVBoxLayout()
        layout.addWidget(self.label)
        layout.addWidget(self.input)
        layout.addWidget(self.button)
        layout.addWidget(self.result)
        self.setLayout(layout)
    def hello(self):
        name = self.input.text()

        if name:
            self.result.setText(f"Привет, {name}")
        else:
            self.result.setText("ВВЕДИ ИМЯ")

app = QApplication(sys.argv)
window = MainWindow()
window.show()
sys.exit(app.exec())