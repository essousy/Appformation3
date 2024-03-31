package com.baben.apps.appformation3.core.app

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class AuthLocalStorageTest {

    companion object{
        private const val TOKEN: String = "myToken"
    }
    lateinit var sut: AuthLocalStorage
    @Mock
    lateinit var shardPreferenceMock: SharedPreferences
    @Mock
    lateinit var contextMock: Context
    @Mock
    lateinit var editorMock: SharedPreferences.Editor
    @Before
    fun setUp() {
        `when`(contextMock.getSharedPreferences(anyString(), anyInt())).thenReturn(shardPreferenceMock)
        `when`(shardPreferenceMock.edit()).thenReturn(editorMock)
        `when`(editorMock.putString(anyString(), any())).thenReturn(editorMock)
        `when`(shardPreferenceMock.getString(anyString(), any())).thenReturn(TOKEN)
        `when`(editorMock.remove(anyString())).thenReturn(editorMock)
        sut = AuthLocalStorage(contextMock)
    }
    @After
    fun tearDown() {
    }
    //shardPreference exist
    @Test
    fun test_shardPrefences_initialized() {
        //Given
        val keyCaptor = ArgumentCaptor.forClass(String::class.java)
        val modeCaptor = ArgumentCaptor.forClass(Int::class.java)
        //When
        //Then
        verify(contextMock).getSharedPreferences(keyCaptor.capture(), modeCaptor.capture())
        assertNotNull(shardPreferenceMock)
        val expectedKey: String = keyCaptor.value
        val expectedMode: Int = modeCaptor.value
        assertEquals(expectedKey, AuthLocalStorage.SHARD_PREFERENCE_KEY)
        assertEquals(expectedMode, Context.MODE_PRIVATE)
    }
    //save token
    @Test
    fun test_saveToken_tokenSaved(){
        //Given
        val tokenCaptor = ArgumentCaptor.forClass(String::class.java)
        //When
        sut.saveToken(TOKEN)
        //Then
        verify(shardPreferenceMock).edit()
        verify(editorMock).putString(tokenCaptor.capture(), tokenCaptor.capture())
        verify(editorMock).apply()
        val expectedKey: String = tokenCaptor.allValues[0]
        val expectedValue: String = tokenCaptor.allValues[1]

        assertEquals(expectedKey, AuthLocalStorage.TOKEN_Key)
        assertEquals(expectedValue, TOKEN)
    }
    //get token 1-> with token not saved
    @Test
    fun test_getToken_withTokenNotSaved() {
        //Given
        val tokenCaptor = ArgumentCaptor.forClass(String::class.java)
        `when`(shardPreferenceMock.getString(anyString(), any())).thenReturn(AuthLocalStorage.DEFAULT_TOKEN_VALUE)
        //When
        val result: String = sut.getToken()
        //Then
        verify(shardPreferenceMock).getString(tokenCaptor.capture(), tokenCaptor.capture())
        val expectedKey: String = tokenCaptor.allValues[0]
        val expectedDefaultValue: String = tokenCaptor.allValues[1]
        assertEquals(expectedKey, AuthLocalStorage.TOKEN_Key)
        assertEquals(expectedDefaultValue, AuthLocalStorage.DEFAULT_TOKEN_VALUE)
        assertEquals(result, AuthLocalStorage.DEFAULT_TOKEN_VALUE)
    }
    //get token 2-> with token saved
    @Test
    fun test_getToken_withTokenSaved() {
        //Given
        val tokenCaptor = ArgumentCaptor.forClass(String::class.java)
        //When
        sut.saveToken(TOKEN)
        val result: String = sut.getToken()
        //Then
        verify(shardPreferenceMock).getString(tokenCaptor.capture(), tokenCaptor.capture())
        val expectedKey: String = tokenCaptor.allValues[0]
        val expectedDefaultValue: String = tokenCaptor.allValues[1]
        assertEquals(expectedKey, AuthLocalStorage.TOKEN_Key)
        assertEquals(expectedDefaultValue, AuthLocalStorage.DEFAULT_TOKEN_VALUE)
        assertEquals(result, TOKEN)
    }
    //clear token
    @Test
    fun test_clearToken_tokenShouldBeRemoved() {
        //Given
        val tokenCaptor = ArgumentCaptor.forClass(String::class.java)
        `when`(shardPreferenceMock.getString(anyString(), any())).thenReturn(AuthLocalStorage.DEFAULT_TOKEN_VALUE)
        //When
        sut.saveToken(TOKEN)
        sut.clearToken()
        val result = sut.getToken()
        //Then
        verify(shardPreferenceMock).edit()
        verify(editorMock).remove(tokenCaptor.capture())
        verify(editorMock, times(2)).apply()
        val expectedKey = tokenCaptor.value
        assertEquals(result, AuthLocalStorage.DEFAULT_TOKEN_VALUE)
        assertEquals(expectedKey, AuthLocalStorage.TOKEN_Key)

    }
    //Is logged 1-> with token not saved
    @Test
    fun test_isLogged_withTokenNotSaved() {
        //Given
        `when`(shardPreferenceMock.getString(anyString(), any())).thenReturn(AuthLocalStorage.DEFAULT_TOKEN_VALUE)
        //When
        val result: Boolean = sut.isLogged()
        //Then
        verify(shardPreferenceMock).getString(anyString(), any())
        assertFalse(result)
    }
    //Is logged 2-> with token saved
    @Test
    fun test_isLogged_withTokentSaved() {
        //Given
        //When
        sut.saveToken(TOKEN)
        val result: Boolean = sut.isLogged()
        //Then
        verify(shardPreferenceMock).getString(anyString(), any())
        assertTrue(result)
    }
}