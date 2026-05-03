package rs.ac.bg.fon.nprog.mvnbiblioteka2026;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.nprog.mvnbiblioteka.interfejs2026.BibliotekaInterface;
import rs.ac.bg.fon.nprog.mvnbiblioteka.interfejs2026.BibliotekaInterfaceTest;

class BibliotekaTest extends BibliotekaInterfaceTest {

	@Override
	public BibliotekaInterface getInstance() {
		return new Biblioteka();
	}

	

}
