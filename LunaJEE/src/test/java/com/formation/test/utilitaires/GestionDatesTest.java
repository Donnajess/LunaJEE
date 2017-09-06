package com.formation.test.utilitaires;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.formation.controle.utilitaires.GestionDates;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GestionDatesTest {

	@Test
	public void testDateEnChaineFR() {
		assertNotNull(GestionDates.tempsEnChaineFR(Instant.now()));
	}

	@Test
	public void testDateEnChaine() {
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
		String text = date.format(formatter);
		assertNotNull(GestionDates.dateEnChaine(Instant.now(), new Locale("fr"), text));
	}

	@Test
	public void test3chaineFRenDate() {
		try {
			assertNotNull(GestionDates.chaineFRenDate("28/08/1994"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test4autres() {
		assertEquals(GestionDates.dateEnChaineFR(Instant.now()), GestionDates.dateEnChaineFR(Instant.now()));
		assertNotNull(GestionDates.instant(LocalDate.now()));
		assertNotNull(GestionDates.instant(LocalDateTime.now()));
		assertNotNull(GestionDates.date(Instant.now()));
		assertNotNull(GestionDates.maintenant());
	}

}
